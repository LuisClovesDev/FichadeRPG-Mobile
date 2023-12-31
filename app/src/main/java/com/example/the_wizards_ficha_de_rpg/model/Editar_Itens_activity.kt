package com.example.the_wizards_ficha_de_rpg.model

import Adapter_Item
import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.the_wizards_ficha_de_rpg.R
import com.example.the_wizards_ficha_de_rpg.Salvamento.Data_Class_Item_Doa
import com.example.the_wizards_ficha_de_rpg.mochila.Mochila

// Importe a classe Item aqui

class Editar_Itens_activity : AppCompatActivity() {

    private var itemId: Long = 0L
    private var itemSelecionado: Item? = null
    private lateinit var dialog: Dialog

    //----------------------------------------------------------------------------

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
            val bitmap: Bitmap? = if (result.resultCode == RESULT_OK && result.data != null) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
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
            } else {
                null
            }

            val Adicionar_Imagem = dialog.findViewById<ImageButton>(R.id.NovaImagem)

            bitmap?.let {
                Adicionar_Imagem?.setImageBitmap(it)
            }
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

    // -----------------------------------------------------------------------


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhes_de_item)

        // Obtem o ID do item da Intent
        itemId = intent.getLongExtra("item_id", 0L)

        // Consulta o banco de dados para obter o objeto Item correspondente
        val db = Data_Class_Item_Doa.instancia(this)
        val itemDao = db.itemDao()
        itemSelecionado = itemDao.buscaPorId(itemId)

        // Verifica se o itemSelecionado não é nulo
        if (itemSelecionado != null) {
            // Use os atributos do itemSelecionado para preencher os componentes visuais
            val imagem = findViewById<ImageView>(R.id.Imagem)
            val nomeTextView = findViewById<TextView>(R.id.Nome_do_item)
            val descricaoTextView = findViewById<TextView>(R.id.descricao_do_item)
            val bonusTextView = findViewById<TextView>(R.id.Bonus_do_item)

            // Configura a imagem usando o bitmap do itemSelecionado
            imagem.setImageBitmap(itemSelecionado!!.bitmap)

            // Configura os TextViews com os outros atributos do itemSelecionado
            if (nomeTextView != null) {
                nomeTextView.text = itemSelecionado?.nome.toString()
            }
            // Verifica se descricaoTextView não é null antes de usar
            if (descricaoTextView != null) {
                descricaoTextView.text = itemSelecionado?.descricao.toString()
            }

// Verifica se bonusTextView não é null antes de usar
            if (bonusTextView != null) {
                bonusTextView.text = itemSelecionado?.bonus.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_de_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private lateinit var adapterItem: Adapter_Item



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val lista_de_itens: MutableList<Item> = mutableListOf()
        adapterItem = Adapter_Item(
            this,
            lista_de_itens,
        )

        adapterItem = Adapter_Item(this, lista_de_itens)


        val db = Data_Class_Item_Doa.instancia(this)
        val itemDao = db.itemDao()

        when (item.itemId) {
            R.id.menu_Item_Excluir -> {
                // Use let para fazer o smart cast
                itemSelecionado?.let {
                    // Excluir o item do banco de dados
                    itemDao.remover(it)

                    // Mude para a nova atividade
                    val intent = Intent(this, Mochila::class.java)
                    startActivity(intent)

                    // Fechar a atividade (opcional)
                    finish()
                }
            }

            R.id.menu_detalhes_edita -> {
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

                // Carregar os detalhes do itemSelecionado nos campos de edição
                Texto_Item_Nome.setText(itemSelecionado?.nome)
                Texto_Descricao_Item.setText(itemSelecionado?.descricao)
                Texto_Bonus_Item.setText(itemSelecionado?.bonus)
                // Configure a imagem do itemSelecionado
                Adicionar_Imagem.setImageBitmap(itemSelecionado?.bitmap)

                Adicionar_Imagem.setOnClickListener {
                    PermissaoGaleria()
                }
                Finalizar_Novo_Item.setOnClickListener {
                    // Atualiza os valores do itemSelecionado
                    itemSelecionado?.nome = Texto_Item_Nome.text.toString()
                    itemSelecionado?.descricao = Texto_Descricao_Item.text.toString()
                    itemSelecionado?.bonus = Texto_Bonus_Item.text.toString()
                    itemSelecionado?.bitmap = Adicionar_Imagem.drawable.toBitmap()


                    // Atualiza o item no banco de dados
                    itemDao.atualiza(itemSelecionado!!)

                    // Atualiza a RecyclerView
                    adapterItem.atualiza(itemDao.buscatodos())

                    dialog.dismiss()
                    // Fechar a atividade (opcional)
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
