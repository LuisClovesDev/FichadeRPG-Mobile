package com.example.the_wizards_ficha_de_rpg

import android.widget.ImageView

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
                "Ar" -> {
                    imageView.setImageResource(R.drawable.ar)
                    return "Ar"
                }
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