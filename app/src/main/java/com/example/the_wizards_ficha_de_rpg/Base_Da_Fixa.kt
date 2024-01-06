package com.example.the_wizards_ficha_de_rpg

import com.example.the_wizards_ficha_de_rpg.outros.FuncoesNivel

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
    var AddAcaoExtra: Int,
    var ElementoSelect: Boolean

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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
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
    0,
    false
)
var Elemento_Nulo = Elementos(
    nome = "Nulo",
    0,
    0,
    0,
    0,
    0,
    0, 0,
    0,
    0,
    0,
    false
)