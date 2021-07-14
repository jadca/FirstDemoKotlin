package com.jadca.catalogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadca.catalogo.databinding.ActivityMainBinding
import com.jadca.catalogo.extensions.redirecToActivity
import com.jadca.catalogo.product.ui.ListProductActivity
import com.jadca.catalogo.product.ui.ProductoActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpEvents()

    }
    private fun setUpEvents(){
       with (binding) {
           crearButton.setOnClickListener {
               redirecToActivity(ProductoActivity::class.java,"messageX","hola")
           }
           listarButton.setOnClickListener{
               redirecToActivity(ListProductActivity::class.java)
           }
       }
    }
}