package com.example.the_wizards_ficha_de_rpg.outros

import android.widget.ImageView
import android.widget.Spinner
import com.example.the_wizards_ficha_de_rpg.R

class RacaFuncoes {

    fun getObjetoRaca(Racanome: String?): Raca? {
        return when (Racanome) {

            "Humano" -> humano
            "Renacido" -> renacido
            "Meio Demonio" -> meiodemonio
            "Asimar" -> asimar
            "Vampiro" -> vampiro
            else -> null
        }

    }

    fun obterTextoDoSpinner(spinner: Spinner): String {
        return spinner.selectedItem.toString()
    }

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