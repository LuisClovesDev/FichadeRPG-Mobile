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
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.the_wizards_ficha_de_rpg.Salvamento.Data_Class_Item_Doa
import com.example.the_wizards_ficha_de_rpg.adapter.Adapter_Feitico
import com.example.the_wizards_ficha_de_rpg.feitico.FeiticoDao
import com.example.the_wizards_ficha_de_rpg.feitico.Item_feitico
import com.example.the_wizards_ficha_de_rpg.mochila.Mochila
import com.example.the_wizards_ficha_de_rpg.model.Item

private var Feiticoid: Long = 0L
private var itemSelecionado: Item_feitico? = null
private lateinit var dialog: Dialog

class Etita_ItemFeitico : AppCompatActivity() {

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
        setContentView(R.layout.activity_etita_item_feitico)

        val Nome_do_feitico = findViewById<TextView>(R.id.Nome_do_feitico_edit)
        val Imagem = findViewById<ImageView>(R.id.Imagem_Edit)
        val Descricao = findViewById<TextView>(R.id.Descricao_item_edit)
        val Custo_de_mana = findViewById<TextView>(R.id.Custo_de_mana_edit)
        val Tempo_de_Carga = findViewById<TextView>(R.id.Tempo_de_carga_edit)

        // Obtem o ID do item da Intent
        Feiticoid = intent.getLongExtra("Fetico_id", 0L)

        // Consulta o banco de dados para obter o objeto Item correspondente
        val db = Data_Class_Item_Doa.instancia(this)
        val FeiticoDAO = db.feiticoDao()
        itemSelecionado = FeiticoDAO.buscaPorId(Feiticoid)

        // Verifica se o itemSelecionado não é nulo
        if (itemSelecionado != null) {

            // Configura a imagem usando o bitmap do itemSelecionado
            Imagem.setImageBitmap(itemSelecionado!!.imagem)

            // Configura os TextViews com os outros atributos do itemSelecionado
            if (Nome_do_feitico != null) {
                Nome_do_feitico.text = itemSelecionado?.nome.toString()
            }
            // Verifica se descricaoTextView não é null antes de usar
            if (Descricao != null) {
                Descricao.text = itemSelecionado?.descricao.toString()
            }
            if (Custo_de_mana != null) {
                Custo_de_mana.text = "Custo de mana: ${itemSelecionado?.custodemana.toString()}"
            }

            if (Tempo_de_Carga != null) {
                Tempo_de_Carga.text = "Tempo de Carga: ${itemSelecionado?.tempodecarga.toString()}"
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_de_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private lateinit var AdapterFeitico: Adapter_Feitico

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val ListadeFeiticos: MutableList<Item_feitico> = mutableListOf()
        AdapterFeitico = Adapter_Feitico(
            this,
            ListadeFeiticos,
        )

        AdapterFeitico = Adapter_Feitico(this, ListadeFeiticos)


        val db = Data_Class_Item_Doa.instancia(this)
        val FeiticoDB = db.feiticoDao()

        when (item.itemId) {
            R.id.menu_Item_Excluir -> {
                // Use let para fazer o smart cast
                itemSelecionado?.let {
                    // Excluir o item do banco de dados
                    FeiticoDB.remover(it)

                    // Mude para a nova atividade
                    val intent = Intent(this, test_acitivty_feiticoslist::class.java)
                    startActivity(intent)

                    // Fechar a atividade (opcional)
                    finish()
                }
            }

            R.id.menu_detalhes_edita -> {
                dialog = Dialog(this)
                dialog.setContentView(R.layout.cria_edita_feitico)
                dialog.show()

                val imagem = dialog.findViewById<ImageButton>(R.id.NovaImagem)
                val Nome = dialog.findViewById<TextView>(R.id.nome_feitico)
                val Custo_mana = dialog.findViewById<TextView>(R.id.custo_de_mana)
                val tempo_carga = dialog.findViewById<TextView>(R.id.tempo_decarga_do_feitico)
                val descricao = dialog.findViewById<TextView>(R.id.descricao_do_feitico)

                val finalizabutao = dialog.findViewById<Button>(R.id.Butao_de_concluir)

                // Carregar os detalhes do itemSelecionado nos campos de edição
                Nome.setText(itemSelecionado?.nome)
                Custo_mana.setText(itemSelecionado?.custodemana)
                tempo_carga.setText(itemSelecionado?.tempodecarga)
                descricao.setText(itemSelecionado?.descricao)
                // Configure a imagem do itemSelecionado
                imagem.setImageBitmap(itemSelecionado?.imagem)

                imagem.setOnClickListener {
                    PermissaoGaleria()
                }

                finalizabutao.setOnClickListener {
                    // Atualiza os valores do itemSelecionado
                    itemSelecionado?.imagem = imagem.drawable.toBitmap()

                    itemSelecionado?.nome = Nome.text.toString()
                    itemSelecionado?.custodemana = Custo_mana.text.toString()
                    itemSelecionado?.tempodecarga = tempo_carga.text.toString()
                    itemSelecionado?.descricao = descricao.text.toString()



                    // Atualiza o item no banco de dados
                    FeiticoDB.atualiza(itemSelecionado!!)

                    // Atualiza a RecyclerView
                    AdapterFeitico.atualiza(FeiticoDB.buscatodos())

                    dialog.dismiss()
                    // Fechar a atividade (opcional)

                    val intent = Intent(this, test_acitivty_feiticoslist::class.java).apply {
                        putExtra("Fetico_id", Feiticoid) // Passa o ID do item para a próxima atividade
                    }
                    startActivity(intent)
                    // Fechar a atividade (opcional)
                    finish()
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }
}