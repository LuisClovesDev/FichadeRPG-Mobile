package com.example.the_wizards_ficha_de_rpg.outros

import android.widget.TextView
import com.example.the_wizards_ficha_de_rpg.Agua
import com.example.the_wizards_ficha_de_rpg.Ar
import com.example.the_wizards_ficha_de_rpg.Elemento_Nulo
import com.example.the_wizards_ficha_de_rpg.Elementos
import com.example.the_wizards_ficha_de_rpg.Explosao
import com.example.the_wizards_ficha_de_rpg.Ferro
import com.example.the_wizards_ficha_de_rpg.Fogo
import com.example.the_wizards_ficha_de_rpg.Gas
import com.example.the_wizards_ficha_de_rpg.Gelo
import com.example.the_wizards_ficha_de_rpg.Luz
import com.example.the_wizards_ficha_de_rpg.Relampago
import com.example.the_wizards_ficha_de_rpg.Sangue
import com.example.the_wizards_ficha_de_rpg.Sombra
import com.example.the_wizards_ficha_de_rpg.Terra
import com.example.the_wizards_ficha_de_rpg.Verde

class Atribuicao_de_Valores_Extras() {


    fun AtribuicaoELEMENTO(Elemento: Elementos, Nivel: TextView): Elementos {

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
            Elemento.ElementoSelect = true
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
            return Ar
        }

        if (Elemento.nome == "Fogo") {
            Elemento.ElementoSelect = true
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
            return Fogo
        }
        if (Elemento.nome == "Agua") {
            Elemento.ElementoSelect = true
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
            return Agua
        }
        if (Elemento.nome == "Terra") {
            Elemento.ElementoSelect = true
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
            return Terra
        }
        if (Elemento.nome == "Luz") {
            Elemento.ElementoSelect = true
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
            return Luz
        }
        if (Elemento.nome == "Sombra") {
            Elemento.ElementoSelect = true
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
            return Sombra
        }
        if (Elemento.nome == "Explosao") {
            Elemento.ElementoSelect = true
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
            return Explosao
        }
        if (Elemento.nome == "Gelo") {
            Elemento.ElementoSelect = true
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
            return Gelo
        }
        if (Elemento.nome == "Sangue") {
            Elemento.ElementoSelect = true
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
            return Sangue
        }
        if (Elemento.nome == "Relampago") {
            Elemento.ElementoSelect = true
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
            return Relampago
        }
        if (Elemento.nome == "Ferro") {
            Elemento.ElementoSelect = true
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
            return Ferro
        }
        if (Elemento.nome == "Verde") {
            Elemento.ElementoSelect = true
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
            return Verde
        }
        if (Elemento.nome == "Gas") {
            Elemento.ElementoSelect = true
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
            return Gas
        }
        return Elemento_Nulo
    }

    fun AtribuicaoRaca(raca: Raca, Nivel: TextView): Raca {

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


        if (raca.nome == "humano") {

            // Toda vez que evoluir de Nível recebe: Nível x 5 de Vida máxima amais
            // Toda vez que evoluir de Nível recebe: Nível x 5 de Mana máxima amais


            raca.AddVida += 20
            raca.AddMana += 20
            raca.AddDestreza += 1
            raca.AddForca += 1
            raca.AddInteligencia += 1
            raca.AddResistencia += 1
            if (nivel != 1) {
                raca.AddVida += nivel * 5
                raca.AddMana += nivel * 5
            }

            raca.Habili_Raca = " Regenera Nível + PDH de mana por turno."

            return humano
        }
        if (raca.nome == "asimar") {
            raca.AddVida += 20 // Inicialmente recebe -2 de armadura física
            raca.AddMana += 20 // Inicialmente recebe +5 de mana
            raca.AddDestreza += nivel

            if (nivel != 1) {
                raca.AddVida += nivel * 5
                raca.AddMana += nivel * 5

            }

            raca.Habili_Raca =
                "Altura: Nível x 2\n" +
                        "mobilidade ao voar: odobro de sua mobilidade atual."

            return asimar
        }

        if (raca.nome == "renacido") {
            // Se a raça for "renacido", aumente a vida inicial em 10.
            raca.AddVida += 40

            // Aumente a resistência mágica inicial em 2.
            raca.PDH += 2

            // Aumente a resistência mágica com base no nível do personagem.
            // A cada 2 níveis, adicione +1 em resistência mágica.
            if (nivel != 1) {
                raca.ResistenciaMagica += nivel/2
                raca.ArmaduraFisica += nivel/2
                raca.AddVida += nivel * 10
            }

            // Defina que a mana é desconsiderada para esta raça.
            raca.AddMana = 0

            // Defina a passiva de regeneração fora de combate.
            raca.Habili_Raca = "Recebe 1d4 + $nivel de vida por turno fora de combate."
            return renacido
        }
        if (raca.nome == "vampiro") {
            // Inicialmente, recebe -3 de Armadura Física.
            raca.AddForca += 3

            // Inicialmente, recebe +10 de mana.
            raca.AddMana += 15

            // Inicialmente, recebe +5 de vida.
            raca.AddVida += 25

            if (nivel != 1) {
                raca.AddVida += nivel * 8
                raca.AddMana += nivel * 5
            }

            // Define a habilidade especial de dar um buff em uma habilidade.
            // Inicialmente, ganha a passiva "Transformação noturna".
            raca.Habili_Raca =
                "CARACTERISTICA UNICA:\n" +
                        "Causar dano físico faz você recuperar Nível x 2 de vida por ataque."
            return vampiro
        }
        if (raca.nome == "meiodemonio") {
            raca.AddVida += 40 // Inicialmente recebe -2 de armadura física
            raca.AddMana += 30 // Inicialmente recebe +5 de mana
            raca.ArmaduraFisica += 2


            if (nivel != 1) {
                raca.AddVida += nivel * 12
                raca.AddMana += nivel * 2
            }


            raca.Habili_Raca =
                "CARACTERISTICA UNICA:\n" +
                        "\n" +
                        "Seu Nível x2 atual vale como mais de A/F e A/M durante o combate."
            return meiodemonio
        }
        return Raca_Nulo
    }
}