package com.jadca.catalogo.extensions

import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.io.Serializable

fun Context.redirecToActivity(classNew:Class<*>,keyValue:String?=null,data:Serializable?=null){
    val intent   = Intent(this, classNew).apply {
       keyValue?.let {
           putExtra(it,data)
       }
    }
    startActivity(intent)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}