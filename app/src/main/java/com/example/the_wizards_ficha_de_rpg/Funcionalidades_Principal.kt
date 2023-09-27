package com.example.the_wizards_ficha_de_rpg

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Funcionalidades_Principal {

    // ATRIBUTOS


    fun calculateBonusFromEditText(editText: EditText): String {
        try {

            val pontosText = editText.text?.toString()
            val pontos = pontosText?.toIntOrNull() ?: 0 // Valor padrão, caso a conversão falhe
            var bonus = pontos / 5


            return bonus.toString()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return "0" // Valor padrão caso ocorra uma exceção
    }

    fun calculateBonusFromEditText_for_LifeEndMana(editText: EditText): String {
        try {
            val pontos = editText.text.toString().toInt()
            val bonus = pontos * 2
            return bonus.toString()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return "0" // Valor padrão caso ocorra uma exceção
    }
    fun calculateBonusFromEditText_for_MobilidadeEArmadura(Text: TextView, extrabonusTextViw: TextView): String {
        try {
            var extrabonus = extrabonusTextViw.text.toString().toInt()

            val pontos = Text.text.toString().toInt()

            val bonus = (pontos + (extrabonus *5)) / 10

            return "$bonus M"
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return "ERRO" // Valor padrão caso ocorra uma exceção
    }

    fun calculateBonusFromEditText_forArmadura(Text:TextView, extrabonusTextViw: TextView): String {
        try {
            val pontos = Text.text.toString().toInt()
            var extrabonus = extrabonusTextViw.text.toString().toInt()
            var bonus = -1
            bonus += (pontos + (extrabonus *5)) / 25
            return "$bonus A/F"
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return "0" // Valor padrão caso ocorra uma exceção
    }

    fun Calc_Pontos_Bonus(editText: EditText, bonusTextView: TextView, isLifeORMana: Boolean,
                          IsExtraMobilit: Boolean? = null, IsExtraArmadura: Boolean? = null, extrabonus:TextView,) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nada a fazer antes da mudança de texto
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Atualizar o cálculo do bônus quando o texto mudar
                if (isLifeORMana) {
                    bonusTextView.text = calculateBonusFromEditText_for_LifeEndMana(editText)
                }else if (!isLifeORMana && IsExtraMobilit == false && IsExtraArmadura == true ){
                    bonusTextView.text =  calculateBonusFromEditText_forArmadura(editText,extrabonus)
                }else if (!isLifeORMana && IsExtraMobilit == true){
                    if (extrabonus.text != null){
                        bonusTextView.text =  calculateBonusFromEditText_for_MobilidadeEArmadura(editText,extrabonus)
                    }else{
                        bonusTextView.text = "ERRO"

                    }
                }else if (!isLifeORMana){
                    bonusTextView.text =  calculateBonusFromEditText(editText)
                }

            }


            override fun afterTextChanged(s: Editable?) {
                // Nada a fazer depois da mudança de texto
            }
        })
    }


}