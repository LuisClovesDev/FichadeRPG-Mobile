package com.example.the_wizards_ficha_de_rpg

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.the_wizards_ficha_de_rpg.Salvamento.Data_Class_Item_Doa
import com.example.the_wizards_ficha_de_rpg.adapter.Adapter_Feitico
import com.example.the_wizards_ficha_de_rpg.feitico.FeiticoDao
import com.example.the_wizards_ficha_de_rpg.feitico.Item_feitico
import com.example.the_wizards_ficha_de_rpg.mochila.Mochila
import com.example.the_wizards_ficha_de_rpg.model.Editar_Itens_activity
import com.example.the_wizards_ficha_de_rpg.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton


class test_acitivty_feiticoslist : AppCompatActivity(), Adapter_Feitico.OnFeitico_ItemClickListener {

    // DIALOG NOVO FEITICO
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
    private lateinit var adapterFeiticos: Adapter_Feitico
    // --------------

    override fun onItemClick(Feiticoid: Long) {
        // Agora, você recebe o ID do item aqui
        val intent = Intent(this, Etita_ItemFeitico::class.java).apply {
            putExtra("Fetico_id", Feiticoid) // Passa o ID do item para a próxima atividade
        }
        startActivity(intent)
        // Fechar a atividade (opcional)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_acitivty_feiticoslist)

        Log.d("ListaFeiticos", "A activity_listade_feiticos iniciou")

        val reciclerview = findViewById<RecyclerView>(R.id.Reciclerview_feiticos)
        reciclerview.layoutManager = LinearLayoutManager(this)
        reciclerview.setHasFixedSize(true)

        val ListadeFeiticos: MutableList<Item_feitico> = mutableListOf()
        adapterFeiticos = Adapter_Feitico(
            this,
            ListadeFeiticos,
            this
        )
        reciclerview.adapter = adapterFeiticos




        // Inicializa a instância do DAO
        val feiticoDao = Data_Class_Item_Doa.instancia(this).feiticoDao()

        // Carrega os feitiços do banco de dados
        adapterFeiticos.atualiza(feiticoDao.buscatodos())


        // BOTAO DE CRIAR NOVO FEITIÇO
        val botaoNovo_feitico = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        botaoNovo_feitico.setOnClickListener {
            dialog = Dialog(this)
            dialog.setContentView(R.layout.cria_edita_feitico)
            dialog.show()

            // imagem,
            var Adicionar_Imagem = dialog.findViewById<ImageButton>(R.id.NovaImagem)
            // nome
            var nome_feitico = dialog.findViewById<EditText>(R.id.nome_feitico)
            // mana
            var Custo_de_mana = dialog.findViewById<EditText>(R.id.custo_de_mana)
            // tempo de carga
            var Tempo_de_Carga = dialog.findViewById<EditText>(R.id.tempo_decarga_do_feitico)
            // descriçao
            var descricao_do_feitico = dialog.findViewById<EditText>(R.id.descricao_do_feitico)
            //CONCLUI
            var botao_concluir = dialog.findViewById<Button>(R.id.Butao_de_concluir)

            // adicionar nova imagem configuração
            Adicionar_Imagem.setOnClickListener {
                PermissaoGaleria()
            }
            botao_concluir.setOnClickListener{
                val novo_feitico = Item_feitico(
                    id = 0L,
                    Adicionar_Imagem.drawable.toBitmap(),
                    nome_feitico.text.toString(),
                    Custo_de_mana.text.toString(),
                    Tempo_de_Carga.text.toString(),
                    descricao_do_feitico.text.toString()
                )

                // ROOM DATA BASE
                val db = Data_Class_Item_Doa.instancia(this)
                val feiticoDao = db.feiticoDao()
                feiticoDao.salva(
                    novo_feitico
                )
                feiticoDao.salva()


                //lista_de_itens.add(este)
                adapterFeiticos.atualiza(feiticoDao.buscatodos())
                adapterFeiticos.notifyItemInserted(ListadeFeiticos.size - 1)



                dialog.dismiss()
            }
        }
    }
}