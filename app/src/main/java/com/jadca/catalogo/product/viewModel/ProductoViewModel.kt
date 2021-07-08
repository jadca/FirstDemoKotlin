package com.jadca.catalogo.product.viewModel

import androidx.lifecycle.ViewModel
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel
import org.koin.java.KoinJavaComponent.inject

class ProductoViewModel() :ViewModel()
{
    private  val productoRepository by inject(IProductoRepository::class.java)

    fun add(productoModel: productoModel){
        productoRepository.AddProducto(productoModel)
    }
    fun getAll(){
        productoRepository.GetAll()
    }
}