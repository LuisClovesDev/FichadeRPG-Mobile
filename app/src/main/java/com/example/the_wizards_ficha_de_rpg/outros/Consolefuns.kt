package com.example.the_wizards_ficha_de_rpg.outros

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.the_wizards_ficha_de_rpg.outros.SpinnerHelper

class Consolefuns(private val spinner: SpinnerHelper){



    fun showAlertDialog(context: Context,nivelDoPersonagem:Int) {
        val alertDialogBuilder = AlertDialog.Builder(context)

        var textBonus = "erro"


        // COMUNICAÇÃO COM CLASSE ATRIBUTO
try {
    alertDialogBuilder.setTitle("Console de Bônus")
    alertDialogBuilder.setMessage(
        "Bônus Positivo: $textBonus \n" +
                "Bonus Neutro:   \n" +
                "Bonus Negativo: "
    )
}catch (e: NumberFormatException){}


        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            // Ação a ser realizada quando o botão "OK" é clicado
        }

        alertDialogBuilder.setNegativeButton("Cancelar") { dialog, which ->
            // Ação a ser realizada quando o botão "Cancelar" é clicado
        }

        alertDialogBuilder.setNeutralButton("Neutro") { dialog, which ->
            // Ação a ser realizada quando o botão "Neutro" é clicado
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }


}
