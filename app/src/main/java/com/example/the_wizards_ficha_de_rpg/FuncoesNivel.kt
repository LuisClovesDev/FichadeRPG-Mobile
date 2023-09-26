package com.example.the_wizards_ficha_de_rpg

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class FuncoesNivel {





    fun calcula_nivel(xp: EditText, bonus: TextView): Int {
        try {
            var xp = xp.text.toString().toInt()
            var NIVEL = 0
            if (xp >= 9) NIVEL = 1
            if (xp >= 10) NIVEL = 2
            if (xp >= 100) NIVEL = 3
            if (xp >= 200) NIVEL = 4
            if (xp >= 400) NIVEL = 5
            if (xp >= 600) NIVEL = 6
            if (xp >= 1000) NIVEL = 7
            if (xp >= 3200) NIVEL = 8
            if (xp >= 3800) NIVEL = 9
            if (xp >= 4500) NIVEL = 10
            if (xp >= 5700) NIVEL = 11
            if (xp >= 6800) NIVEL = 12
            if (xp >= 7900) NIVEL = 13
            if (xp >= 9000) NIVEL = 14
            if (xp >= 9600) NIVEL = 15
            if (xp >= 10000) NIVEL = 16
            if (xp >= 10800) NIVEL = 17
            if (xp >= 12000) NIVEL = 18
            if (xp >= 12900) NIVEL = 19
            if (xp >= 14500) NIVEL = 20
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