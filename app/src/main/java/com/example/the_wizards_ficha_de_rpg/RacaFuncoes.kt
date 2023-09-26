package com.example.the_wizards_ficha_de_rpg

import android.widget.ImageView

class RacaFuncoes {

    fun MudaImagem(RacaAtual: String?, imageView: ImageView) {

        if (RacaAtual == "Humano") {
            imageView.setImageResource(R.drawable.humano)
        } else if (RacaAtual == "Meio Demonio") {
            imageView.setImageResource(R.drawable.meiodemonio)
        } else if (RacaAtual == "Vampiro") {
            imageView.setImageResource(R.drawable.vampiro)
        } else if (RacaAtual == "Asimar") {
            imageView.setImageResource(R.drawable.asimar)
        } else if (RacaAtual == "Renacido") {
            imageView.setImageResource(R.drawable.renacido)
        }

    }

}