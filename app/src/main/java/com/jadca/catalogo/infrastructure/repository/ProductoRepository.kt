package com.jadca.catalogo.infrastructure.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel

class ProductoRepository : IProductoRepository {
    private lateinit var database: DatabaseReference
    init {
        database =   Firebase.database.reference
    }
    override fun AddProducto(productoModel: productoModel) {
        database.child(PRODUCTOS).child(productoModel.id.toString()).setValue(productoModel)
    }

    override  fun GetAll() {
        var ref = database.child(PRODUCTOS)
        var d=ref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.children.mapNotNull { it.getValue(productoModel::class.java) }.toList()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
    companion object    {
       const val PRODUCTOS="productos"
    }
}
