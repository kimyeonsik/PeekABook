package kim.yeonsik.peekabook.di

import android.app.Application
import android.util.Log
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d("KIM", "KoinApplication.onCreate()")

        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                dataSourceModule
            )
        }
    }
}