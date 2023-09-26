package com.example.the_wizards_ficha_de_rpg

import android.widget.TextView

class Atribuicao_de_Valores_Extras() {




    fun AtribuicaoELEMENTO(Elemento: Elementos, Nivel: TextView) {

        var nivel: Int = 0

        try {
            val nivelText = Nivel.text.toString()
            if (nivelText.isNotEmpty()) {
                nivel = nivelText.toInt()
            } else {
                nivel = -1 // Defina o valor padrão desejado quando o texto estiver vazio
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            nivel = -1 // Defina o valor padrão desejado quando a conversão falhar
        }

            if (Elemento.nome == "Ar") {
                if (nivel < 1) {
                    Elemento.AddDestreza = 0
                    Elemento.AddPDH = 0
                    Elemento.AddTempodeCarga = 0
                    Elemento.AddMana = 0
                }
                if (nivel >= 1) {
                    Elemento.AddDestreza += 1
                }
                if (nivel >= 4) {
                    Elemento.AddPDH += 2
                }
                if (nivel >= 6) {
                    Elemento.AddTempodeCarga -= 1
                }
                if (nivel >= 8) {
                    Elemento.AddMana += 5
                }
                if (nivel >= 10) {
                    Elemento.AddDestreza += 2
                }
                if (nivel >= 12) {
                    Elemento.AddTempodeCarga -= 1
                }
                if (nivel >= 14) {
                    Elemento.AddDestreza += 2
                }
                if (nivel >= 16) {
                    Elemento.AddPDH += 2
                }
                if (nivel >= 18) {
                    Elemento.AddMana += 5
                }
                if (nivel >= 20) {
                    Elemento.AddTempodeCarga -= 4
                }
            }

        if (Elemento.nome == "Fogo") {

            if (nivel >= 1) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 4) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 6) {
                Elemento.AddVida += 5
            }
            if (nivel >= 8) {
                Elemento.AddPDH += 1
            }
            if (nivel >= 12) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 14) {
                Elemento.AddAtaqueExtra += 1
            }
            if (nivel >= 18) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 20) {
                Elemento.AddVida += 10
            }
        }
        if (Elemento.nome == "Agua") {

            if (nivel >= 1) {
                Elemento.AddMana += 5
            }
            if (nivel >= 4) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 5) {
                Elemento.AddMana += 5
            }
            if (nivel >= 8) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 10) {
                Elemento.AddMana += 5
            }
            if (nivel >= 13) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 15) {
                Elemento.AddVida += 5
            }
            if (nivel >= 18) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 20) {
                Elemento.AddMana += 5
            }
        }
        if (Elemento.nome == "Terra") {

            if (nivel >= 1) {
                Elemento.AddMana += 5
            }
            if (nivel >= 2) {
                Elemento.AddVida += 5
            }
            if (nivel >= 4) {
                Elemento.AddForca += 1
            }
            if (nivel >= 6) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 8) {
                Elemento.AddVida += 5
            }
            if (nivel >= 10) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 12) {
                Elemento.AddForca += 1
            }
            if (nivel >= 14) {
                Elemento.AddVida += 5
            }
            if (nivel >= 16) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 18) {
                Elemento.AddForca += 1
            }
            if (nivel >= 20) {
                Elemento.AddResistencia += 2
            }
        }
        if (Elemento.nome == "Luz") {

            if (nivel >= 1) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 4) {
                Elemento.AddMana += 5
            }
            if (nivel >= 6) {
                Elemento.AddDestreza += 1
            }
            if (nivel >= 8) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 10) {
                Elemento.AddMana += 5
            }
            if (nivel >= 12) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 14) {
                Elemento.AddResistencia += 1
            }
            if (nivel >= 16) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 18) {
                Elemento.AddMana += 5
            }
            if (nivel >= 20) {
                Elemento.AddInteligencia += 2
            }
        }
        if (Elemento.nome == "Sombra") {

            if (nivel >= 1) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 2) {
                Elemento.AddDestreza += 1
            }
            if (nivel >= 4) {
                Elemento.AddVida += 5
            }
            if (nivel >= 6) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 8) {
                Elemento.AddDestreza += 1
            }
            if (nivel >= 10) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 12) {
                Elemento.AddMana += 5
            }
            if (nivel >= 14) {
                Elemento.AddDestreza += 2
            }
            if (nivel >= 16) {
                Elemento.AddForca += 1
            }
            if (nivel >= 18) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 20) {
                Elemento.AddDestreza += 2
            }
        }
        if (Elemento.nome == "Explosao") {

            if (nivel >= 1) {
                Elemento.AddPDH += 4
            }
            if (nivel >= 2) {
                Elemento.AddVida += 5
            }
            if (nivel >= 4) {
                Elemento.AddForca += 1
            }
            if (nivel >= 6) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 8) {
                Elemento.AddVida += 5
            }
            if (nivel >= 10) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 12) {
                Elemento.AddVida += 5
            }
            if (nivel >= 14) {
                Elemento.AddMana += 5
            }
            if (nivel >= 16) {
                Elemento.AddPDH += 1
            }
            if (nivel >= 18) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 20) {
                Elemento.AddPDH += 1
            }
        }
        if (Elemento.nome == "Gelo") {

            if (nivel >= 1) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 2) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 4) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 6) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 8) {
                Elemento.AddMana += 5
            }
            if (nivel >= 10) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 12) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 14) {
                Elemento.AddMana += 5
            }
            if (nivel >= 16) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 18) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 20) {
                Elemento.AddInteligencia += 2
            }
        }
        if (Elemento.nome == "Sangue") {

            if (nivel >= 1) {
                Elemento.AddVida += 10
            }
            if (nivel >= 2) {
                Elemento.AddPDH += 4
            }
            if (nivel >= 4) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 6) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 8) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 10) {
                Elemento.AddVida += 5
            }
            if (nivel >= 12) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 14) {
                Elemento.AddVida += 10
            }
            if (nivel >= 16) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 18) {
                Elemento.AddDestreza += 2
            }
            if (nivel >= 20) {
                Elemento.AddPDH += 2
            }
        }
        if (Elemento.nome == "Relampago") {

            if (nivel >= 1) {
                Elemento.AddDestreza += 2
            }
            if (nivel >= 2) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 4) {
                Elemento.AddVida += 5
            }
            if (nivel >= 6) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 8) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 10) {
                Elemento.AddMana += 5
            }
            if (nivel >= 12) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 14) {
                Elemento.AddDestreza += 2
            }
            if (nivel >= 16) {
                Elemento.AddTempodeCarga -= 2
            }
            if (nivel >= 18) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 20) {
                Elemento.AddAcaoExtra += 1
            }
        }
        if (Elemento.nome == "Ferro") {

            if (nivel >= 1) {
                Elemento.AddResistencia += 4
            }
            if (nivel >= 2) {
                Elemento.AddForca += 4
            }
            if (nivel >= 4) {
                Elemento.AddVida += 5
            }
            if (nivel >= 6) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 8) {
                Elemento.AddMana += 5
            }
            if (nivel >= 10) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 12) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 14) {
                Elemento.AddVida += 5
            }
            if (nivel >= 16) {
                Elemento.AddForca += 2
            }
            if (nivel >= 18) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 20) {
                Elemento.AddResistencia += 2
            }
        }
        if (Elemento.nome == "Verde") {

            if (nivel >= 1) {
                Elemento.AddVida += 10
            }
            if (nivel >= 2) {
                Elemento.AddMana += 5
            }
            if (nivel >= 4) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 6) {
                Elemento.AddPDH += 1
            }
            if (nivel >= 8) {
                Elemento.AddVida += 5
            }
            if (nivel >= 10) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 12) {
                Elemento.AddVida += 5
            }
            if (nivel >= 14) {
                Elemento.AddMana += 5
            }
            if (nivel >= 16) {
                Elemento.AddResistencia += 2
            }
            if (nivel >= 18) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 20) {
                Elemento.AddPDH += 4
            }
        }
        if (Elemento.nome == "Gas") {

            if (nivel >= 1) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 2) {
                Elemento.AddVida += 5
            }
            if (nivel >= 4) {
                Elemento.AddMana += 5
            }
            if (nivel >= 6) {
                Elemento.AddDestreza += 4
            }
            if (nivel >= 8) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 10) {
                Elemento.AddInteligencia += 1
            }
            if (nivel >= 12) {
                Elemento.AddVida += 5
            }
            if (nivel >= 14) {
                Elemento.AddMana += 5
            }
            if (nivel >= 16) {
                Elemento.AddPDH += 2
            }
            if (nivel >= 18) {
                Elemento.AddInteligencia += 2
            }
            if (nivel >= 20) {
                Elemento.AddPDH += 4
            }
        }


// FIM DAS CONDICIONAIS
    }
}