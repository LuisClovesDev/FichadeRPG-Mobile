package com.example.the_wizards_ficha_de_rpg.outros

import android.widget.ImageView
import android.widget.Spinner
import com.example.the_wizards_ficha_de_rpg.Agua
import com.example.the_wizards_ficha_de_rpg.Ar
import com.example.the_wizards_ficha_de_rpg.Elementos
import com.example.the_wizards_ficha_de_rpg.Explosao
import com.example.the_wizards_ficha_de_rpg.Ferro
import com.example.the_wizards_ficha_de_rpg.Fogo
import com.example.the_wizards_ficha_de_rpg.Gas
import com.example.the_wizards_ficha_de_rpg.Gelo
import com.example.the_wizards_ficha_de_rpg.Luz
import com.example.the_wizards_ficha_de_rpg.R
import com.example.the_wizards_ficha_de_rpg.Relampago
import com.example.the_wizards_ficha_de_rpg.Sangue
import com.example.the_wizards_ficha_de_rpg.Sombra
import com.example.the_wizards_ficha_de_rpg.Terra
import com.example.the_wizards_ficha_de_rpg.Verde

class Elementos_funcoes {


    fun getObjetoElemento(elementoNome: String?): Elementos? {
        return when (elementoNome) {
            "fogo" -> Fogo // Substitua pelo objeto Elementos correto
            "agua" -> Agua // Substitua pelo objeto Elementos correto
            "terra" -> Terra // Substitua pelo objeto Elementos correto
            "Ar" -> Ar // Substitua pelo objeto Elementos correto
            "Luz" -> Luz // luz
            "Sombra" -> Sombra // SOMBRA
            "Explosão" -> Explosao // Explocao
            "Gelo" -> Gelo
            "Sangue" -> Sangue
            "Relampago" -> Relampago
            "Ferro" -> Ferro
            "verde" -> Verde
            "Gas" -> Gas
            // Adicione outros elementos conforme necessário
            else -> null // Retorne null para tratar elementos desconhecidos
        }
    }


    fun MudaImagem(Elementoatual: String?, imageView: ImageView): String {
        if (Elementoatual != null) {
            val resourceId = when (Elementoatual) {
                "fogo" -> R.drawable.fogo
                "agua" -> R.drawable.agua
                "terra" -> R.drawable.terra
                "Ar" -> R.drawable.ar
                "Luz" -> R.drawable.luz
                "Sombra" -> R.drawable.sombra
                "verde" -> R.drawable.verde
                "Relampago" -> R.drawable.eletricidade
                "Gelo" -> R.drawable.gelo
                "Lava" -> R.drawable.lava
                "Sangue" -> R.drawable.sangue
                "Explosão" -> R.drawable.explosao
                "Gas" -> R.drawable.gais
                "Ferro" -> R.drawable.ferro
                else -> {
                    // Se o elemento não for reconhecido, defina uma imagem padrão
                    return "nenhum elemento selecionado"
                }
            }
            imageView.setImageResource(resourceId)
            return Elementoatual
        } else {
            // Se Elementoatual for nulo, defina uma imagem padrão e retorne uma mensagem
            return "Elementoatual é nulo"
        }
    }

    fun obterTextoDoSpinner(spinner: Spinner): String {
        return spinner.selectedItem.toString()
    }
    fun getNomeElemento(RacaAtual: String): String {
        return when (RacaAtual) {
            "fogo" -> "Fogo"
            "agua" -> "Água"
            "terra" -> "Terra"
            "Ar" -> "Ar"
            // Adicione outros elementos conforme necessário
            else -> "Nenhum elemento selecionado"
        }
    }

}