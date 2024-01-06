package com.example.the_wizards_ficha_de_rpg.outros

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class FuncoesNivel {





    fun calcula_nivel(xp: EditText, bonus: TextView): Int {
        try {
            var xp = xp.text.toString().toInt()
            var NIVEL = 0
            if (xp >= 0) NIVEL = 1
            if (xp >= 20) NIVEL = 2
            if (xp >= 40) NIVEL = 3
            if (xp >= 65) NIVEL = 4
            if (xp >= 95) NIVEL = 5
            if (xp >= 130) NIVEL = 6
            if (xp >= 340) NIVEL = 7
            if (xp >= 700) NIVEL = 8
            if (xp >= 950) NIVEL = 9
            if (xp >= 1280) NIVEL = 10
            if (xp >= 1520) NIVEL = 11
            if (xp >= 3040) NIVEL = 12
            if (xp >= 4060) NIVEL = 13
            if (xp >= 5120) NIVEL = 14
            if (xp >= 6420) NIVEL = 15
            if (xp >= 8560) NIVEL = 16
            if (xp >= 11680) NIVEL = 17
            if (xp >= 15520) NIVEL = 18
            if (xp >= 20040) NIVEL = 19
            if (xp >= 25320) NIVEL = 20
            return NIVEL
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return 0
    }




    fun xp_para_nivel(xp: EditText, nivel: TextView) {
        nivel.text = calcula_nivel(xp,nivel).toString()
    }

    fun ALL_VerificacoesDeXp_Nivei(
        xp: EditText, nivel: TextView, extrabonus: TextView
    ) {
        xp.addTextChangedListener(object : TextWatcher {

            fun atualizarNivel() {
                xp_para_nivel(xp, nivel)

            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Chamado antes que o texto seja alterado
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Chamado quando o texto está sendo alterado
                calcula_nivel(xp,nivel)
                //ATUALIZA
                atualizarNivel()



            }

            override fun afterTextChanged(s: Editable?) {
                // Chamado depois que o texto foi alterado
            }

        })


    }

}