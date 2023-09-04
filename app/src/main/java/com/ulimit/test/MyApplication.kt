package com.ulimit.test
import android.app.Application
import com.ulimit.test.KohinModule.networkModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(networkModule)
        }
    }

    companion object{
        lateinit var mPreferences: Preferences
    }
}