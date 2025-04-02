package com.example.desafiop1
import com.example.desafiop1.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(private val listaItens: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.imageViewItem) // ID atualizado!
        val textViewNome = view.findViewById<TextView>(R.id.textViewNome)
        val textViewValor = view.findViewById<TextView>(R.id.textViewValor)
        val buttonVender = view.findViewById<Button>(R.id.buttonVender)
        val buttonEditar = view.findViewById<Button>(R.id.buttonEditar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listaItens[position]
        holder.textViewNome.text = item.nome
        holder.textViewValor.text = "R$ ${item.valor}"

        Glide.with(holder.itemView.context).load(item.urlImagem).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return listaItens.size
    }
}
