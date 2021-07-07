package com.jadca.catalogo
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import android.app.Application


class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appDependencies))
        }
    }

}