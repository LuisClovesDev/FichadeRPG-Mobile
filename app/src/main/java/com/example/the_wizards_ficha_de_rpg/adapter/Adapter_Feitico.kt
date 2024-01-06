package com.example.the_wizards_ficha_de_rpg.adapter

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.the_wizards_ficha_de_rpg.R
import com.example.the_wizards_ficha_de_rpg.feitico.Item_feitico
import com.example.the_wizards_ficha_de_rpg.model.Item

class Adapter_Feitico(
    private val contexto: Context,
    private val Feiticos: MutableList<Item_feitico>,
    private val FeiticoClickListener: OnFeitico_ItemClickListener = object : OnFeitico_ItemClickListener {
        override fun onItemClick(Feiticoid: Long) {
            // Implemente a lógica padrão ou deixe em branco, dependendo do seu caso.
        }
    }
) : RecyclerView.Adapter<Adapter_Feitico.FeiticoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeiticoViewHolder {
        val item_List = LayoutInflater.from(contexto).inflate(R.layout.feitico, parent, false)
        return FeiticoViewHolder(item_List)
    }

    override fun onBindViewHolder(holder: FeiticoViewHolder, position: Int) {
        val feitico = Feiticos[position]

        val bitmapDrawable = BitmapDrawable(contexto.resources, feitico.imagem)
        holder.imagem.setImageDrawable(bitmapDrawable)

        holder.nomedofeitico.text = Feiticos[position].nome
        holder.custo_de_mana.text = "Custo de mana: ${Feiticos[position].custodemana}"
        holder.tempodecarga.text = "Tempo de Carga: ${Feiticos[position].tempodecarga}"
        holder.descricao.text = Feiticos[position].descricao

        holder.itemView.isActivated = feitico.isSelected // Define o estado de seleção

        holder.itemView.setOnClickListener {
            FeiticoClickListener.onItemClick(feitico.id) // Passa o ID do item
        }

    }

    fun atualiza(feiticos: List<Item_feitico>) {
        // Limpa a lista e adiciona os novos feitiços
        Feiticos.clear()
        Feiticos.addAll(feiticos)

        // Notifica o adaptador sobre as mudanças nas posições alteradas
        notifyItemRangeChanged(0, feiticos.size)
    }


    override fun getItemCount(): Int = Feiticos.size

    inner class FeiticoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagem = itemView.findViewById<ImageView>(R.id.imagem)
        val nomedofeitico = itemView.findViewById<TextView>(R.id.nome)
        val custo_de_mana = itemView.findViewById<TextView>(R.id.cust_de_mana)
        val tempodecarga = itemView.findViewById<TextView>(R.id.tempo_de_carga)
        val descricao = itemView.findViewById<TextView>(R.id.ResumoDescritivo)
    }

    interface OnFeitico_ItemClickListener {
        fun onItemClick(FeiticoId: Long)
    }

}


