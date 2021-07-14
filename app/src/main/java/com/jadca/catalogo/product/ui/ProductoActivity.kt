package com.jadca.catalogo.product.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.jadca.catalogo.databinding.ActivityProductoBinding
import com.jadca.catalogo.extensions.toast
import com.jadca.catalogo.product.model.productoModel
import com.jadca.catalogo.product.viewModel.ProductoViewModel
import java.util.*

class ProductoActivity : AppCompatActivity() {
   private lateinit var binding: ActivityProductoBinding
    private lateinit var viewModel : ProductoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpEvents()
        setUpViewModel()
    }
    private fun setUpViewModel(){
        viewModel = ViewModelProviders.of(this).get(ProductoViewModel::class.java)
    }
    private fun setUpEvents(){
        binding.buttonGrabarProducto.setOnClickListener{
            var descripcion:String?
            var precio : Float?
                descripcion  = binding.textInputEditTextDescripcion.text.toString()
                precio =  binding.textInputEditTextPrecio.text.toString().toFloat()
            val producto = productoModel(UUID.randomUUID().toString(),descripcion,precio)
            viewModel.add(producto)
            toast("Registro exitoso")
                descripcion  = ""
            binding.textInputEditTextDescripcion.text?.clear()
            binding.textInputEditTextPrecio.text?.clear()
        }
    }
}