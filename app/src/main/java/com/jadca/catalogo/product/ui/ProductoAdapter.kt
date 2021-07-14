package com.jadca.catalogo.product.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jadca.catalogo.R
import com.jadca.catalogo.databinding.ItemProductoBinding
import com.jadca.catalogo.extensions.basicDiffUtil
import com.jadca.catalogo.extensions.inflate
import com.jadca.catalogo.product.model.productoModel
class ProductoAdapter ():RecyclerView.Adapter<ProductoAdapter.ViewHolder>(){
    var list:List<productoModel>by basicDiffUtil(emptyList(),{old,new -> old.id==new.id})
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val binding=ItemProductoBinding.bind(view)

        fun bind(item:productoModel){
           with(binding) {
               textViewDescriptionProducto.text=item.descripcion
               textViewPrecio.text = item.precio.toString()
               imageViewBackgroundStatusProducto.load(""){
                   crossfade(true)
                   crossfade(3)
               }
           }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_producto,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int=list.size
}