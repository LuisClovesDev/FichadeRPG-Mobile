package com.example.the_wizards_ficha_de_rpg

import Consolefuns
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

        val imageView = findViewById<ImageView>(R.id.imageView9) // substitua pelo ID correto
        val imageViewRaca = findViewById<ImageView>(R.id.imageView10) // substitua pelo ID correto

        val spinnerHelper = SpinnerHelper(imageView)
        val spinnerHelperRaca = SpinnerHelper(imageViewRaca)


        // CRIAÇÃO DOS ATRIBUTOS

        var Atributo_Destreza = Atributos(0, 0, 0)

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
        var Armaduras = findViewById<TextView>(R.id.Armadura_Bonus)

        // MUDANÇA DE VALOR DE PONTO PARA BONUS
        F.Calc_Pontos_Bonus(Pontos_DESTREZA, Bonus_DESTREZA, false)
        F.Calc_Pontos_Bonus(Pontos_RESISTENCIA, Bonus_RESISTENCIA, false)
        F.Calc_Pontos_Bonus(Pontos_INTELIGENCIA, Bonus_INTELIGENCIA, false)
        F.Calc_Pontos_Bonus(Pontos_FORCA, Bonus_FORCA, false)
        F.Calc_Pontos_Bonus(Pontos_Vida, Bonus_VIDA, true)
        F.Calc_Pontos_Bonus(Ponto_MANA, Bonus_MANA, true)

        F.Calc_Pontos_Bonus(Pontos_DESTREZA_for_Mobilit, Mobilidade, false, true)
        F.Calc_Pontos_Bonus(Pontos_RESISTENCIA_for_Armadura, Armaduras, false, false, true)

        // ---------------------------------------------------------

        // MUDA EXTRA BONUS


        // BOTOES DE CONSOLE...

        val ImageBotoes: ImageButton = findViewById(R.id.DESTREZABUTAO)

        ImageBotoes.setOnClickListener() {
            var AdVE = Atribuicao_de_Valores_Extras()
            var Ele = Elementos_funcoes()
            val elementoNome = spinnerHelper.selectedItem

// Chame getObjetoElemento para obter um objeto Elementos
            val elemento = Ele.getObjetoElemento(elementoNome)

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

                AdVE.AtribuicaoELEMENTO(elemento, nivel)

                // -------------------------------------

                EXTRABONUSDESTREZA.text = "+${elemento.AddDestreza}"
                EXTRABONUSRESISTENCIA.text = "+${elemento.AddResistencia}"
                EXTRABONUSINTELIGENCIA.text = "+${elemento.AddInteligencia}"
                EXTRABONUSFORCA.text = "+${elemento.AddForca}"
                EXTRABONUSVIDA.text = "+${elemento.AddVida}"
                EXTRABONUSMANA.text = "+${elemento.AddMana}"
            } else {
                // Lide com o caso em que o elemento não foi encontrado
                EXTRABONUSDESTREZA.text = "Elemento não encontrado"
            }
        }

    }


// FIM DA OPERAÇOES INICAIS



}





