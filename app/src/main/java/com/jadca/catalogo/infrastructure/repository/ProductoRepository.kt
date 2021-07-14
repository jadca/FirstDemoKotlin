package com.jadca.catalogo.infrastructure.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine

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
    override suspend fun GetAllX(): Flow<List<productoModel>?> = flow  {
        var ref = database.child(PRODUCTOS)
        var response : List<productoModel>? = null

        ref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                response = snapshot.children.mapNotNull { it.getValue(productoModel::class.java) }.toList()
                 ref.setValue(response)
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    override    suspend fun GetAllX2(): Flow<List<productoModel>> = callbackFlow {
        val listener = object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError)
            {
                close(error.toException())
            }

            override fun onDataChange(snapshot: DataSnapshot)
            {
                this@callbackFlow.trySend(snapshot.children.mapNotNull {
                   it.getValue(productoModel::class.java)
                }.toList()).isSuccess
            }
        }
        database.child(PRODUCTOS).addValueEventListener(listener)

        awaitClose {
            database.removeEventListener(listener)
        }
    }

    companion object    {
       const val PRODUCTOS="productos"
    }
}
