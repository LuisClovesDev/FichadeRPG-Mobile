package com.example.the_wizards_ficha_de_rpg

import android.widget.TextView

class Atribuicao_de_Valores_Extras() {




    fun AtribuicaoELEMENTO(Elemento: Elementos, Nivel: TextView, ) {

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
        }

    }
    fun AtribuicaoRaca(raca: Raca, Nivel: TextView, ){

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


        if(raca.nome == "humano"){

                raca.AddVida += 5
                raca.AddMana += 5

            raca.AddVida += nivel*3
            raca.AddMana += nivel*3

            raca.Habili_Raca = " Regenera Nível Dividido por 2 de mana a cada 2 ciclos."

        }
        if (raca.nome == "asimar") {
            raca.AddVida -= 2 // Inicialmente recebe -2 de armadura física
            raca.AddDestreza += 2 // Inicialmente recebe +2 de destreza
            raca.AddMana += 5 // Inicialmente recebe +5 de mana

            val vidaBonus = (nivel / 2) * 3 // A cada 2 níveis recebe +3 de vida
            val manaBonus = nivel * 2 // A cada 1 nível recebe +2 de mana

            raca.AddVida = vidaBonus
            raca.AddMana = manaBonus

            raca.Habili_Raca = "Recebe ${nivel / 2} a mais de turno extra. Sua Resistência Física é cortada pela metade."
        }

        if (raca.nome == "renacido") {
            // Se a raça for "renacido", aumente a vida inicial em 10.
            raca.AddVida += 10

            // Aumente a resistência mágica inicial em 2.
            raca.ResistenciaMagica += 2

            // Aumente a vida com base no nível do personagem.
            // A cada 1 nível, adicione +5 à vida.
            raca.AddVida += nivel * 5

            // Aumente a resistência mágica com base no nível do personagem.
            // A cada 2 níveis, adicione +1 em resistência mágica.
            if (nivel % 2 == 0) {
                raca.ResistenciaMagica += nivel / 2
            }

            // Defina que a mana é desconsiderada para esta raça.
            raca.AddMana = 0

            // Defina a passiva de regeneração fora de combate.
            raca.Habili_Raca = "Recebe 1d4 + $nivel de vida por turno fora de combate."
        }
        if (raca.nome == "vampiro") {
            // Inicialmente, recebe -3 de Armadura Física.
            raca.ArmaduraFisica -= 3

            // Inicialmente, recebe +10 de mana.
            raca.AddMana += 10

            // Inicialmente, recebe +5 de vida.
            raca.AddVida += 5

            // Aumenta a vida com base no nível do personagem.
            // A cada 2 níveis, adicione +1 à vida.
            if (nivel % 2 == 0) {
                raca.AddVida += nivel / 2
            }

            // Aumenta a mana com base no nível do personagem.
            // A cada 1 nível, adicione +4 à mana.
            raca.AddMana += nivel * 4

            // Define a habilidade especial de dar um buff em uma habilidade.
            // Inicialmente, ganha a passiva "Transformação noturna".
            raca.Habili_Raca = "Pode dar um buff em uma habilidade que aumentará o efeito com base no nível e lhe curará" +
                    " ${nivel + 1}d4 de vida. O custo da habilidade irá dobrar de valor de Mana;" +
                    " Transformação noturna: Transforma-se em vampiro ganhando garras e uma pele escura."
        }

    }
}