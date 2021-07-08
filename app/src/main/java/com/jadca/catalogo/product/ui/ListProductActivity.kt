package com.jadca.catalogo.product.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.jadca.catalogo.databinding.ActivityListProductBinding
import com.jadca.catalogo.product.viewModel.ProductoViewModel

class ListProductActivity : AppCompatActivity() {
    private lateinit var binding:ActivityListProductBinding
    private lateinit var viewModel : ProductoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()

        viewModel.getAll()
    }
    private fun setUpViewModel(){
        viewModel = ViewModelProviders.of(this).get(ProductoViewModel::class.java)
    }
}