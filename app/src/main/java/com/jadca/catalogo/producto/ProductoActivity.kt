package com.jadca.catalogo.producto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProviders
import com.jadca.catalogo.databinding.ActivityProductoBinding
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
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
            binding.let {
                descripcion  = it.textInputEditTextDescripcion.text.toString()
                precio =  it.textInputEditTextPrecio.text.toString().toFloat()
            }
            val producto = productoModel(UUID.randomUUID(),descripcion,precio)
            viewModel.addProducto(producto)
            binding.textViewData.text = producto.id.toString()
        }
    }
}