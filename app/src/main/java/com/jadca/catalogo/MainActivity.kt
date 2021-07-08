package com.jadca.catalogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadca.catalogo.extensions.redirecToActivity
import com.jadca.catalogo.product.ui.ListProductActivity
import com.jadca.catalogo.product.ui.ProductoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      // redirecToActivity(ProductoActivity::class.java,"messageX","hola")
      redirecToActivity(ListProductActivity::class.java)
    }
}