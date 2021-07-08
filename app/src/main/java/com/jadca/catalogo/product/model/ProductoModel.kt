package com.jadca.catalogo.product.model

import java.util.*

data class productoModel( val id : String?,val descripcion:String?="", val precio : Float?=0f)
{
    constructor():this("","",0f)
}