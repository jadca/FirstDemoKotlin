package com.jadca.catalogo.producto

import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class ProductoViewModel() :ViewModel()
{
    private val productoRepository by inject(IProductoRepository::class.java)
    fun addProducto(productoModel: productoModel){
        productoRepository.AddProducto(productoModel)
    }
}