package com.jadca.catalogo

import com.jadca.catalogo.producto.*
import org.koin.dsl.module

val appDependencies = module {
    single<IUsersRepository> { FakeInMemoryUsersRepository() }
    single<IProductoRepository> { ProductoRepository() }

}
