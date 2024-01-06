package com.example.the_wizards_ficha_de_rpg.outros

import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import com.example.the_wizards_ficha_de_rpg.Atributos
import com.example.the_wizards_ficha_de_rpg.Elementos

class SpinnerHelper(private val imageView: ImageView) : AdapterView.OnItemSelectedListener {

    val E = Elementos_funcoes()
    val R = RacaFuncoes()
    private var palavra: String? = null

    var selectedItem: String? = null
        private set


    override fun onItemSelected(
        parent: AdapterView<*>,
        view: View?,
        position: Int,
        id: Long
    ) {
        selectedItem = parent.getItemAtPosition(position) as? String




        E.MudaImagem(selectedItem, imageView)
        palavra = E.MudaImagem(selectedItem, imageView)
        R.MudaImagem(selectedItem, imageView)

    }



    // Método para obter o valor da palavra selecionada
    fun getPalavra(Nivel: Int, elemento: Elementos, atributo: Atributos) {


    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Nenhuma ação necessária aqui
    }
}
