package com.jadca.catalogo.product.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadca.catalogo.databinding.ActivityListProductBinding
import com.jadca.catalogo.extensions.getViewModel
import com.jadca.catalogo.extensions.toast
import com.jadca.catalogo.product.viewModel.ListProductoViewModel
import com.jadca.catalogo.product.viewModel.ProductoViewModel

class ListProductActivity : AppCompatActivity() {
    private lateinit var binding:ActivityListProductBinding
    private lateinit var viewModel:ListProductoViewModel
    private lateinit var productoAdapter:ProductoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
        setUpRecyclerView()
        setUpViewModelObserver()

    }
    private fun setUpViewModel(){
        viewModel = getViewModel {
            ListProductoViewModel()
        }
    }
    private fun setUpViewModelObserver(){
      viewModel.productoModel.observe(this,{
         productoAdapter.list   =it
      })
        viewModel.onMessageError.observe(this,{
            toast(it)
        })
    }
    private fun setUpRecyclerView(){
        with(binding){
            productoAdapter = ProductoAdapter()
            recyclerViewContent.layoutManager = LinearLayoutManager(this@ListProductActivity)
            recyclerViewContent.adapter=productoAdapter
        }
    }
}