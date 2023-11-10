import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.the_wizards_ficha_de_rpg.R
import com.example.the_wizards_ficha_de_rpg.model.Item

class Adapter_Item(
    private val context: Context,
    private val itens: MutableList<Item>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<Adapter_Item.ItemView_Houlder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView_Houlder {
        val item_Lista = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        val houlder = ItemView_Houlder(item_Lista)
        return houlder
    }

    override fun onBindViewHolder(holder: ItemView_Houlder, position: Int) {
        val item = itens[position]
        val bitmapDrawable = BitmapDrawable(context.resources, item.bitmap)
        holder.foto.setImageDrawable(bitmapDrawable)
        holder.nome.text = item.nome
        holder.descricao.text = item.descricao
        holder.bonus.text = item.bonus

        holder.itemView.isActivated = item.isSelected // Define o estado de seleção

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    interface Click_Item{

        fun clickCaItem(item: Item)

    }
    fun atualiza(item: List<Item>) {
        this.itens.clear()
        this.itens.addAll(item)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itens.size

    inner class ItemView_Houlder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.Foto_Item)
        val nome = itemView.findViewById<TextView>(R.id.Nome_Item)
        val descricao = itemView.findViewById<TextView>(R.id.Descricao_item)
        val bonus = itemView.findViewById<TextView>(R.id.Bonus_Item)
    }
}
