package com.jadca.catalogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadca.catalogo.producto.ProductoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        redirecToActivity(ProductoActivity::class.java,"messageX","hola")
    }
}