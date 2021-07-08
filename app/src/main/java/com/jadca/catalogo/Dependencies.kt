package com.jadca.catalogo

import com.jadca.catalogo.infrastructure.repository.ProductoRepository
import com.jadca.catalogo.product.model.IProductoRepository
import org.koin.dsl.module

val appDependencies = module {
    single<IProductoRepository> { ProductoRepository() }

}
