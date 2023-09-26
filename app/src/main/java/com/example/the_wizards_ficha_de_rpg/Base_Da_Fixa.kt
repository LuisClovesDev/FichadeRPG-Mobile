package com.example.the_wizards_ficha_de_rpg

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

val Ni = FuncoesNivel()

class Atributos(
    var pontos: Int,
    var bonus: Int,
    var ExtraBonus: Int

    // BASE DOS ATRIBUTOS COM CONDIÇÃO DE CADA CAIXA DE REPRESENTAÇÃO DO ATRIBUTO
    // FORÇA DESTREZA RESISTENCIA INTELIGENCIA E PDH.
)



class Elementos(
    var nome: String? = null,
    var AddDestreza: Int,
    var AddForca: Int,
    var AddResistencia: Int,
    var AddInteligencia: Int,
    var AddPDH: Int,
    var AddVida: Int,
    var AddMana: Int,
    var AddTempodeCarga: Int,
    var AddAtaqueExtra: Int,
    var AddAcaoExtra: Int

)
var Fogo = Elementos(
    nome = "Fogo",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Terra = Elementos(
    nome = "Terra",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)

var Ar = Elementos(
    nome = "Ar",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)

var Agua = Elementos(
    nome = "Agua",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Luz = Elementos(
    nome = "Luz",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Sombra = Elementos(
    nome = "Sombra",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Gelo = Elementos(
    nome = "Gelo",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Explosao = Elementos(
    nome = "Explosao",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Sangue = Elementos(
    nome = "Sangue",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Relampago = Elementos(
    nome = "Relampago",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Ferro = Elementos(
    nome = "Ferro",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Verde = Elementos(
    nome = "Verde",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)
var Gas = Elementos(
    nome = "Gas",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0
)