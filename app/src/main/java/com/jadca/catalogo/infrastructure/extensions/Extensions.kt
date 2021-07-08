package com.jadca.catalogo.extensions

import android.content.Context
import android.content.Intent
import java.io.Serializable

fun Context.redirecToActivity(classNew:Class<*>,keyValue:String?=null,data:Serializable?=null){
    val intent   = Intent(this, classNew).apply {
       keyValue?.let {
           putExtra(it,data)
       }
    }
    startActivity(intent)
}