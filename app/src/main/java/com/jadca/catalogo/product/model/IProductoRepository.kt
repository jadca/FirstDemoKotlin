package com.jadca.catalogo.product.model

import com.jadca.catalogo.product.model.productoModel

interface IProductoRepository
{
    fun AddProducto(productoModel: productoModel)
     fun GetAll()
}
