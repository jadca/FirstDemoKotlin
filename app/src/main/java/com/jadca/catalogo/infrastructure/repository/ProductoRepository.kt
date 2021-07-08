package com.jadca.catalogo.infrastructure.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel

class ProductoRepository : IProductoRepository {

    private lateinit var database: DatabaseReference
    override fun AddProducto(productoModel: productoModel) {
        database =   Firebase.database.reference
        database.child("productos").child(productoModel.id.toString()).setValue(productoModel)
    }
}
