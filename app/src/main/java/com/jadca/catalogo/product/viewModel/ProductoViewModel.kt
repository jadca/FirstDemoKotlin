package com.jadca.catalogo.product.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import java.util.logging.Level.INFO
import kotlin.math.log

class ProductoViewModel() :ViewModel()
{
    private  val productoRepository by inject(IProductoRepository::class.java)
    init {
        viewModelScope.launch {
            productoRepository.GetAllX2().collect {
            var rr  = it;
            }
        }
    }

    fun add(productoModel: productoModel){
        productoRepository.AddProducto(productoModel)
    }
    fun getAll(){
        productoRepository.GetAll()
    }
}