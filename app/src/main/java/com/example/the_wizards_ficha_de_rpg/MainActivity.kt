package com.example.the_wizards_ficha_de_rpg

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.the_wizards_ficha_de_rpg.Salvamento.Atributos_Save
import com.example.the_wizards_ficha_de_rpg.Salvamento.Data_Class_Item_Doa
import com.example.the_wizards_ficha_de_rpg.mochila.Mochila
import com.example.the_wizards_ficha_de_rpg.outros.Atribuicao_de_Valores_Extras
import com.example.the_wizards_ficha_de_rpg.outros.Elementos_funcoes
import com.example.the_wizards_ficha_de_rpg.outros.Funcionalidades_Principal
import com.example.the_wizards_ficha_de_rpg.outros.FuncoesNivel
import com.example.the_wizards_ficha_de_rpg.outros.Raca
import com.example.the_wizards_ficha_de_rpg.outros.RacaFuncoes
import com.example.the_wizards_ficha_de_rpg.outros.Raca_Nulo
import com.example.the_wizards_ficha_de_rpg.outros.SpinnerHelper
import com.example.the_wizards_ficha_de_rpg.outros.meiodemonio
import com.example.the_wizards_ficha_de_rpg.outros.renacido
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // luis 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val DAO by lazy {
            Data_Class_Item_Doa.instancia(this).mainSave()
        }

        val contexto: Context = this

        Log.d("ListaFeiticos", "app iniciou")

        // Crie um diálogo personalizado
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.ficha_novo_item)

        // Configure outros elementos do diálogo, se necessário
        //val BotaodeNovoItem = findViewById<FloatingActionButton>(R.id.Adicionar)


        // FUNÇÕES DE CALCULO
        val F = Funcionalidades_Principal()


        // NIVEL

        var Ni = FuncoesNivel()

        val xp = findViewById<EditText>(R.id.xp)
        val nivel = findViewById<TextView>(R.id.Nivel)

        var BONUS_EXTRA = findViewById<TextView>(R.id.BonusExtra_DESTREZA)



        Ni.ALL_VerificacoesDeXp_Nivei(xp, nivel, BONUS_EXTRA)

        // ELEMENTOS


        // Dentro da função onCreate ou onde você está configurando os Spinners
        val spinner = findViewById<Spinner>(R.id.ELEMENTOS) // substitua pelo ID correto
        val spinner_raca = findViewById<Spinner>(R.id.RACA_SPINNER) // substitua pelo ID correto
        val spinnerVantagem =
            findViewById<Spinner>(R.id.Vantagem_Sppiner) // substitua pelo ID correto
        val spinnerDesvantagem =
            findViewById<Spinner>(R.id.Desvantegem_Sppiner) // substitua pelo ID correto
        val spinnerpERICIA =
            findViewById<Spinner>(R.id.Pericia_Sppiner) // substitua pelo ID correto

        // VARIAVEIS ARRAY

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.opcoes,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapter_raca = ArrayAdapter.createFromResource(
            this,
            R.array.opcoesRaca,
            android.R.layout.simple_spinner_item
        )
        adapter_raca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapterVantagem = ArrayAdapter.createFromResource(
            this,
            R.array.opcoesVantagem,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapterDESVANTAGENS = ArrayAdapter.createFromResource(
            this,
            R.array.DESVANTAGENS,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapterPericia = ArrayAdapter.createFromResource(
            this,
            R.array.opcoespERICIAS,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var imageView = findViewById<ImageView>(R.id.imageView9) // substitua pelo ID correto
        val imageViewRaca = findViewById<ImageView>(R.id.imageView10) // substitua pelo ID correto

        val spinnerHelper = SpinnerHelper(imageView)
        val spinnerHelperRaca = SpinnerHelper(imageViewRaca)


        // CRIAÇÃO DE ELEMENTOS


        spinner.adapter = adapter
        spinner.onItemSelectedListener = spinnerHelper

        spinner_raca.adapter = adapter_raca
        spinner_raca.onItemSelectedListener = spinnerHelperRaca

        spinnerVantagem.adapter = adapterVantagem
        spinnerVantagem.onItemSelectedListener = spinnerHelper

        spinnerDesvantagem.adapter = adapterDESVANTAGENS
        spinnerDesvantagem.onItemSelectedListener = spinnerHelper

        spinnerpERICIA.adapter = adapterPericia
        spinnerpERICIA.onItemSelectedListener = spinnerHelper


        // COLETA DE CAIXAS DE ATRIBUTO E BONUS

        var Pontos_DESTREZA = findViewById<EditText>(R.id.editaDESTREZA)
        var Pontos_DESTREZA_for_Mobilit = findViewById<EditText>(R.id.editaDESTREZA)

        var Bonus_DESTREZA = findViewById<TextView>(R.id.Bonus_DESTREZA)

        var EXTRABONUSDESTREZA = findViewById<TextView>(R.id.BonusExtra_DESTREZA)
        var EXTRABONUSRESISTENCIA = findViewById<TextView>(R.id.BonusExtra_RESISTENCIA)
        var EXTRABONUSINTELIGENCIA = findViewById<TextView>(R.id.BonusExtra_INTELIGENCIA)
        var EXTRABONUSFORCA = findViewById<TextView>(R.id.BonusExtra_FORCA)
        var EXTRABONUSVIDA = findViewById<TextView>(R.id.BonusExtra_VIDA)
        var EXTRABONUSMANA = findViewById<TextView>(R.id.BonusExtra_MANA)

        var Pontos_RESISTENCIA = findViewById<EditText>(R.id.editaRESISTENCIA)
        var Pontos_RESISTENCIA_for_Armadura = findViewById<EditText>(R.id.editaRESISTENCIA)
        var Bonus_RESISTENCIA = findViewById<TextView>(R.id.Bonus_RESISTENCIA)
        var Pontos_INTELIGENCIA = findViewById<EditText>(R.id.editaINTELIGENCIA)
        var Bonus_INTELIGENCIA = findViewById<TextView>(R.id.Bonus_INTELIGENCIA)
        var Pontos_FORCA = findViewById<EditText>(R.id.editaFORCA)
        var Bonus_FORCA = findViewById<TextView>(R.id.Bonus_FORCA)
        var Pontos_Vida = findViewById<EditText>(R.id.editaVIDA)
        var Bonus_VIDA = findViewById<TextView>(R.id.Bonus_VIDA)
        var Ponto_MANA = findViewById<EditText>(R.id.editaMANA)
        var Bonus_MANA = findViewById<TextView>(R.id.Bonus_MANA)


        var Mobilidade = findViewById<TextView>(R.id.Mobilidade_Bonus)
        var Armaduras = findViewById<TextView>(R.id.Armadura_Fisica_Bonus)

        // PRENCHENDO AUTOMATICAMENTE CASO JÁ AJA ALGUM VALOR SALVO NA CAIXA DE PONTOS

        val db = Data_Class_Item_Doa.instancia(this)
        val atributosSave = db.mainSave().busca()

        if (atributosSave != null) {
            // BUSCA PONTO
            Pontos_DESTREZA.hint = "P: ${atributosSave.ptD}"
            Pontos_RESISTENCIA.hint = "P: ${atributosSave.ptR}"
            Pontos_INTELIGENCIA.hint = "P: ${atributosSave.ptI}"
            Pontos_FORCA.hint = "P: ${atributosSave.ptF}"
            Pontos_Vida.hint = "P: ${atributosSave.ptVI}"
            Ponto_MANA.hint = "P: ${atributosSave.ptMA}"
            // BUSCA BONUS
            Bonus_DESTREZA.text = "${atributosSave.BdD}"
            Bonus_RESISTENCIA.text = "${atributosSave.BdR}"
            Bonus_INTELIGENCIA.text = "${atributosSave.BdI}"
            Bonus_FORCA.text = "${atributosSave.BdF}"
            Bonus_VIDA.text = "${atributosSave.BdVI}"
            Bonus_MANA.text = "${atributosSave.BdMA}"
            // BUSCA PONTO
            EXTRABONUSDESTREZA.text ="${atributosSave.ExD}"
            EXTRABONUSRESISTENCIA.text ="${atributosSave.ExR}"
            EXTRABONUSINTELIGENCIA.text ="${atributosSave.ExI}"
            EXTRABONUSFORCA.text ="${atributosSave.ExF}"
            EXTRABONUSVIDA.text ="${atributosSave.ExVI}"
            EXTRABONUSMANA.text ="${atributosSave.ExMA}"
            // ARMADURAS E MOBILIT
            Armaduras.text = "${atributosSave.Ar_F}"
            Mobilidade.text = "${atributosSave.Ar_M}"
            // NIVEL
            nivel.text = "${atributosSave.Ar_M}"


            //  elemento
            val posicaoElementoSalvo = adapter.getPosition(atributosSave.ele)
            spinner.setSelection(posicaoElementoSalvo)

            // RAÇA
            val posicaoRacaSalva = adapter_raca.getPosition(atributosSave.raca)

            spinner_raca.setSelection(posicaoRacaSalva)






        } else {
            // Não há registro no banco de dados, exiba uma mensagem inicial
            Pontos_DESTREZA.hint = "insira"
            Pontos_RESISTENCIA.hint = "insira"
            Pontos_INTELIGENCIA.hint = "insira"
            Pontos_FORCA.hint = "insira"
            Pontos_Vida.hint = "insira"
            Ponto_MANA.hint = "insira"

            Bonus_DESTREZA.text = "0"
            Bonus_RESISTENCIA.text = "0"
            Bonus_INTELIGENCIA.text = "0"
            Bonus_FORCA.text = "0"
            Bonus_VIDA.text = "0"
            Bonus_MANA.text = "0"
        }


        /*
        // MUDANÇA DE VALOR DE PONTO PARA BONUS
        F.Calc_Pontos_Bonus(Pontos_DESTREZA, Bonus_DESTREZA, false, extrabonus = EXTRABONUSDESTREZA)
        F.Calc_Pontos_Bonus(
            Pontos_RESISTENCIA,
            Bonus_RESISTENCIA,
            false,
            extrabonus = EXTRABONUSRESISTENCIA
        )
        F.Calc_Pontos_Bonus(
            Pontos_INTELIGENCIA,
            Bonus_INTELIGENCIA,
            false,
            extrabonus = EXTRABONUSINTELIGENCIA
        )
        F.Calc_Pontos_Bonus(Pontos_FORCA, Bonus_FORCA, false, extrabonus = EXTRABONUSFORCA)
        F.Calc_Pontos_Bonus(Pontos_Vida, Bonus_VIDA, true, extrabonus = EXTRABONUSVIDA)
        F.Calc_Pontos_Bonus(Ponto_MANA, Bonus_MANA, true, extrabonus = EXTRABONUSMANA)
        EXTRABONUSDESTREZA.text = "0"
        F.Calc_Pontos_Bonus(
            Pontos_DESTREZA_for_Mobilit,
            Mobilidade,
            false,
            true,
            extrabonus = EXTRABONUSDESTREZA
        )
        F.Calc_Pontos_Bonus(
            Pontos_RESISTENCIA_for_Armadura,
            Armaduras,
            false,
            false,
            true,
            extrabonus = EXTRABONUSRESISTENCIA
        )

        */
        // BOTOES DE CONSOLE...

        val ImageBotoes: ImageButton = findViewById(R.id.DESTREZABUTAO)

        ImageBotoes.setOnClickListener() {
            var Atribui = Atribuicao_de_Valores_Extras()
            var Ele = Elementos_funcoes()
            var Rar = RacaFuncoes()
            val elementoNome = spinnerHelper.selectedItem
            val RacaNome = spinnerHelperRaca.selectedItem
            var raca_verificada: Raca = Raca_Nulo
            var elemento_verificado: Elementos = Elemento_Nulo
        // Chame getObjetoElemento para obter um objeto Elementos
            val elemento = Ele.getObjetoElemento(elementoNome)
            val Raca = Rar.getObjetoRaca(RacaNome)

        // ARMADURAS E MOBILIDADE

            var armaduramagica = findViewById<TextView>(R.id.Armadura_Magica_Bonus)
            var armadurafisicaextra = findViewById<TextView>(R.id.Armadura_Fisica_Extra_Bonus)

// Verifique se o elemento não é nulo antes de chamar AtribuicaoELEMENTO
            if (elemento != null) {

                // segurança caso aperte o botão mais de uma vez
                elemento.AddDestreza = 0
                elemento.AddForca = 0
                elemento.AddResistencia = 0
                elemento.AddInteligencia = 0
                elemento.AddVida = 0
                elemento.AddMana = 0
                elemento.AddTempodeCarga = 0
                elemento.AddPDH = 0
                elemento.AddAtaqueExtra = 0
                elemento.AddAcaoExtra = 0
                // ------------------------------------
                elemento_verificado = Atribui.AtribuicaoELEMENTO(elemento, nivel)

            }
            if (Raca != null ) {
                // segurança caso aperte o botão mais de uma vez
                Raca.AddVida = 0
                Raca.AddMana = 0
                Raca.AddInteligencia = 0
                Raca.AddDestreza = 0
                Raca.AddForca = 0
                Raca.AddResistencia = 0
                Raca.ResistenciaMagica = 0
                Raca.ArmaduraFisica = 0
                // ------------------------------------
                raca_verificada = Atribui.AtribuicaoRaca(Raca, nivel)

                Log.d("verifica", "Raça não é igual a null")

            }
            // outra parte


            EXTRABONUSDESTREZA.text = "+${elemento_verificado.AddDestreza + raca_verificada.AddDestreza}"
            EXTRABONUSRESISTENCIA.text = "+${elemento_verificado.AddResistencia +raca_verificada.AddResistencia}"
            EXTRABONUSINTELIGENCIA.text = "+${elemento_verificado.AddInteligencia +raca_verificada.AddInteligencia}"
            EXTRABONUSFORCA.text = "+${elemento_verificado.AddForca +raca_verificada.AddForca}"
            EXTRABONUSVIDA.text = "+${elemento_verificado.AddVida +raca_verificada.AddVida}"
            EXTRABONUSMANA.text = "+${elemento_verificado.AddMana +raca_verificada.AddMana}"

            var Magica = 0
            Magica = (renacido.ResistenciaMagica + meiodemonio.ResistenciaMagica)
            var Fisica = 0
            Fisica = (renacido.ArmaduraFisica + meiodemonio.ArmaduraFisica)
            armaduramagica.text = Magica.toString()
            armadurafisicaextra.text = Fisica.toString()



            //---------------------------

            // MUDANÇA DE VALOR DE PONTO PARA BONUS
            F.Calc_Pontos_Bonus(Pontos_DESTREZA, Bonus_DESTREZA, false, extrabonus = EXTRABONUSDESTREZA)
            F.Calc_Pontos_Bonus(Pontos_RESISTENCIA,Bonus_RESISTENCIA,false,extrabonus = EXTRABONUSRESISTENCIA)
            F.Calc_Pontos_Bonus(Pontos_INTELIGENCIA,Bonus_INTELIGENCIA,false, extrabonus = EXTRABONUSINTELIGENCIA)
            F.Calc_Pontos_Bonus(Pontos_FORCA, Bonus_FORCA, false, extrabonus = EXTRABONUSFORCA)
            F.Calc_Pontos_Bonus(Pontos_Vida, Bonus_VIDA, true, extrabonus = EXTRABONUSVIDA)
            F.Calc_Pontos_Bonus(Ponto_MANA, Bonus_MANA, true, extrabonus = EXTRABONUSMANA)
            F.Calc_Pontos_Bonus(
                Pontos_DESTREZA_for_Mobilit,
                Mobilidade,
                false,
                true,
                extrabonus = EXTRABONUSDESTREZA
            )
            F.Calc_Pontos_Bonus(
                Pontos_RESISTENCIA_for_Armadura,
                Armaduras,
                false,
                false,
                true,
                extrabonus = EXTRABONUSRESISTENCIA
            )

        }
        // -------------------------------------
        // ABRIR INVENTÁRIO
        val ImageButtomMudar: ImageButton = findViewById(R.id.BotaoMochila)

        ImageButtomMudar.setOnClickListener() {
            // Crie um Intent para iniciar a próxima Activity
            val intent = Intent(this, Mochila::class.java)

            // Se desejar, você pode passar dados para a próxima Activity usando putExtra
            intent.putExtra("chave", "valor") // Substitua "chave" e "valor" pelos seus dados

            // Inicie a próxima Activity
            startActivity(intent)
        }
        // FEITIÇO

        var BotaoListadeFeiticos = findViewById<ImageButton>(R.id.BotaoFeiticos)

        BotaoListadeFeiticos.setOnClickListener() {

            val intent = Intent(this, test_acitivty_feiticoslist::class.java)

            Log.d("ListaFeiticos", "abriu lista de feitiços")

            startActivity(intent)
        }


        //SAVE ATRIBUTOS
        var Busca_do_banco_de_dados = findViewById<ImageButton>(R.id.Save_Butao)



        Busca_do_banco_de_dados.setOnClickListener {
            lifecycleScope.launch {
                // COLETA PONTOS
                val ptD = Pontos_DESTREZA.text.toString()
                val ptR = Pontos_RESISTENCIA.text.toString()
                val ptI = Pontos_INTELIGENCIA.text.toString()
                val ptF = Pontos_FORCA.text.toString()
                val ptVI = Pontos_Vida.text.toString()
                val ptMA = Ponto_MANA.text.toString()
                // COLETA BONUS
                val BdD = Bonus_DESTREZA.text.toString()
                val BdR = Bonus_RESISTENCIA.text.toString()
                val BdI = Bonus_INTELIGENCIA.text.toString()
                val BdF = Bonus_FORCA.text.toString()
                val BdVI = Bonus_VIDA.text.toString()
                val BdMA = Bonus_MANA.text.toString()
                // COLETA EXTRABONUS
                val ExD = EXTRABONUSDESTREZA.text.toString()
                val ExR = EXTRABONUSRESISTENCIA.text.toString()
                val ExI = EXTRABONUSINTELIGENCIA.text.toString()
                val ExF = EXTRABONUSFORCA.text.toString()
                val ExVI = EXTRABONUSVIDA.text.toString()
                val ExMA = EXTRABONUSMANA.text.toString()
                //COLETA RAÇA
                var Rar = RacaFuncoes()
                val spinner_raca =
                    findViewById<Spinner>(R.id.RACA_SPINNER) // substitua pelo ID correto
                val Raca = Rar.obterTextoDoSpinner(spinner_raca)
                Log.d("ValorRaça", Raca)
                //COLETA ELEMENTO
                var Ele = Elementos_funcoes()
                val spinner = findViewById<Spinner>(R.id.ELEMENTOS) // substitua pelo ID correto
                val ELE = Ele.obterTextoDoSpinner(spinner)
                //COLETA ARMADURAS A MOBILIT
                var Armaduras = findViewById<TextView>(R.id.Armadura_Fisica_Bonus)
                val Armadura = Armaduras.text.toString()

                var Mobilidade = findViewById<TextView>(R.id.Mobilidade_Bonus)
                val Mob = Mobilidade.text.toString()

                if (listOf(
                        ptD,
                        ptR,
                        ptI,
                        ptF,
                        ptVI,
                        ptMA,
                        BdD,
                        BdR,
                        BdI,
                        BdF,
                        BdVI,
                        BdMA,
                        ExD,
                        ExR,
                        ExI,
                        ExF,
                        ExVI,
                        ExMA,
                        Raca,
                        ELE,
                        Armadura
                    ).all { it.isNotBlank() }
                ) {
                    val atributosSave = Atributos_Save(
                        1001,
                        ptD.toInt(),
                        ptR.toInt(),
                        ptI.toInt(),
                        ptF.toInt(),
                        ptVI.toInt(),
                        ptMA.toInt(),
                        BdD.toInt(),  // Adiciona os bônus aqui
                        BdR.toInt(),
                        BdI.toInt(),
                        BdF.toInt(),
                        BdVI.toInt(),
                        BdMA.toInt(),
                        ExD.toInt(),
                        ExR.toInt(),
                        ExI.toInt(),
                        ExF.toInt(),
                        ExVI.toInt(),
                        ExMA.toInt(),
                        Ar_F = Armadura.toInt(),
                        Ar_M = Mob.toInt(),
                        raca = Raca,
                        ele = ELE

                    )

                    DAO.salva(atributosSave)
                } else {
                    val builder = AlertDialog.Builder(contexto)
                    builder.setTitle("ATENÇÃO")
                    builder.setMessage("Alguns atributos não foram preenchidos. Tem certeza disso?")

                    builder.setPositiveButton("SIM") { dialog, _ ->
                        // Preencher automaticamente com zero se estiver em branco
                        val atributosSave = Atributos_Save(
                            1001,
                            ptD.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ptR.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ptI.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ptF.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ptVI.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ptMA.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            BdD.takeIf { ptD.isNotBlank() }?.toInt() ?: 0,
                            BdR.takeIf { ptR.isNotBlank() }?.toInt() ?: 0,
                            BdI.takeIf { ptI.isNotBlank() }?.toInt() ?: 0,
                            BdF.takeIf { ptF.isNotBlank() }?.toInt() ?: 0,
                            BdVI.takeIf { ptVI.isNotBlank() }?.toInt() ?: 0,
                            BdMA.takeIf { ptMA.isNotBlank() }?.toInt() ?: 0,
                            ExD.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ExR.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ExI.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ExF.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ExVI.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            ExMA.takeIf { it.isNotBlank() }?.toInt() ?: 0,
                            Ar_F = Armadura.toInt(),
                            Ar_M = Mob.toInt(),
                            raca = if (Raca.isNotBlank()) Raca else "nulo",
                            ele = if (ELE.isNotBlank()) ELE else "nulo"

                        )


                        DAO.salva(atributosSave)
                        dialog.dismiss()  // Fecha o dialog
                    }

                    builder.setNegativeButton("NÃO") { dialog, _ ->
                        // Lógica para lidar com o caso em que o usuário escolhe "NÃO"
                        dialog.dismiss()  // Fecha o dialog
                    }
                    builder.show()
                }


            }


        }
    }
}