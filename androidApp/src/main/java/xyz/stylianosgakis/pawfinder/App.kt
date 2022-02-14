package xyz.stylianosgakis.pawfinder

import android.app.Application
import org.koin.android.ext.koin.androidContext
import xyz.stylianosgakis.pawfinder.animals.module.animalsModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
            modules(animalsModule)
        }
    }
}
