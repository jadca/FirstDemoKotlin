package com.jadca.catalogo.product.model

import com.jadca.catalogo.product.model.productoModel
import kotlinx.coroutines.flow.Flow

interface IProductoRepository
{
    fun AddProducto(productoModel: productoModel)
    fun GetAll()
    suspend fun GetAllX():Flow<List<productoModel>?>
    suspend fun GetAllX2():Flow<List<productoModel>?>
}
