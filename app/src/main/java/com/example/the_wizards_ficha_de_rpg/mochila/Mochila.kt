package com.example.the_wizards_ficha_de_rpg.mochila

import Adapter_Item
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract.Data
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.the_wizards_ficha_de_rpg.Data_Class_Item_Doa
import com.example.the_wizards_ficha_de_rpg.R
import com.example.the_wizards_ficha_de_rpg.model.Editar_Itens_activity
import com.example.the_wizards_ficha_de_rpg.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
class Mochila  : AppCompatActivity(), Adapter_Item.OnItemClickListener {

    private lateinit var dialog: Dialog

    companion object {
        private val Permisao_Galeria = Manifest.permission.READ_EXTERNAL_STORAGE
    }

    private val RequestGaleria =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { permissao ->
            if (permissao) {
                resultGaleria.launch(
                    Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                )
            } else {
                showDialogPermissao()
            }
        }

    private val resultGaleria =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val bitmap: Bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(
                    baseContext.contentResolver,
                    result.data?.data
                )
            } else {
                val source = ImageDecoder.createSource(
                    this.contentResolver,
                    result.data?.data!!
                )
                ImageDecoder.decodeBitmap(source)
            }

            var Adicionar_Imagem = dialog.findViewById<ImageButton>(R.id.NovaImagem)

            Adicionar_Imagem?.setImageBitmap(bitmap)

// Agora você pode usar 'drawable' como um Drawable



        }

    fun showDialogPermissao() {
        var builder = AlertDialog.Builder(this)
            .setTitle("VOCÊ PRECISA PERMITIR O ACESSO À GALERIA")
            .setMessage("Para que possamos adicionar uma imagem ao item, precisamos que você permita o acesso")
            .setNegativeButton("Não") { _, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Sim") { _, _ ->
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                dialog.dismiss()
            }
    }

    fun verificaPermissao(permissao: String) =
        ContextCompat.checkSelfPermission(this, permissao) == PackageManager.PERMISSION_GRANTED

    fun PermissaoGaleria() {
        val PermissaoGaleriaAceita = verificaPermissao(Permisao_Galeria)

        when {
            PermissaoGaleriaAceita -> {
                resultGaleria.launch(
                    Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                )
            }

            shouldShowRequestPermissionRationale(Permisao_Galeria) -> showDialogPermissao()

            else -> RequestGaleria.launch(Permisao_Galeria)
        }
    }

    // --------------

    override fun onItemClick(item: Item) {
        // Lidar com o evento de clique aqui, por exemplo, exibir informações sobre o item
        val intent = Intent(this, Editar_Itens_activity::class.java)
        startActivity(intent)

        Toast.makeText(this, "Clicou no item: ${item.nome}", Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mochila)



        val resourceId = R.drawable.fogo // Substitua 'fogo' pelo nome do seu recurso drawable
        val bitmap = BitmapFactory.decodeResource(resources, resourceId)

        val db = Room.databaseBuilder(
            this,
            Data_Class_Item_Doa::class.java,
            "Item.db"
        ).allowMainThreadQueries()
            .build()
        val itemDao = db.itemDao()
        itemDao.salva(
            // MUDA EXTRA BONUS

            Item(
                nome = "Nome do Item",
                descricao = "Descrição do Item",
                bonus = "Bônus do Item",
                bitmap = bitmap,
            )
        )



        val reciclerView_Itens = findViewById<RecyclerView>(R.id.reciclerView_Itens)
        reciclerView_Itens.layoutManager = LinearLayoutManager(this)
        reciclerView_Itens.setHasFixedSize(true)

        val lista_de_itens: MutableList<Item> = mutableListOf()
        val adapterItem = Adapter_Item(this, lista_de_itens, this) // Passa a instância atual da atividade como OnItemClickListener
        reciclerView_Itens.adapter = adapterItem

        val DialogAdicionar = findViewById<FloatingActionButton>(R.id.Adicionar)


        //============

        adapterItem.atualiza(itemDao.buscatodos())

        //========

        DialogAdicionar.setOnClickListener {
            dialog = Dialog(this)
            dialog.setContentView(R.layout.ficha_novo_item)
            dialog.show()

            // imagem,
            var Adicionar_Imagem = dialog.findViewById<ImageButton>(R.id.NovaImagem)
            // nome
            var Texto_Item_Nome = dialog.findViewById<EditText>(R.id.nomedoitem)
            // descrição
            var Texto_Descricao_Item = dialog.findViewById<EditText>(R.id.descricao)
            // bonus
            var Texto_Bonus_Item = dialog.findViewById<EditText>(R.id.bonusdoitem)
            // finalizar
            var Finalizar_Novo_Item = dialog.findViewById<Button>(R.id.ConcluirButtom)

            Adicionar_Imagem.setOnClickListener {
                PermissaoGaleria()
            }
            Finalizar_Novo_Item.setOnClickListener {
                val este = Item(
                    0L,
                    Adicionar_Imagem.drawable.toBitmap(),
                    Texto_Item_Nome.text.toString(),
                    Texto_Descricao_Item.text.toString(),
                    Texto_Bonus_Item.text.toString(),
                )



                lista_de_itens.add(este)
                adapterItem.notifyItemInserted(lista_de_itens.size - 1) // Notifique o adaptador sobre a inserção do novo item

                dialog.dismiss()
            }
        }
    }

}

