package enko.felber.metronomus
//Klasse für Timber Implementierung
import android.app.Application
import timber.log.Timber

class TimerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}