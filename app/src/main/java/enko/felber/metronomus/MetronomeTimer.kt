package enko.felber.metronomus

import android.app.Application
import android.os.Handler
import timber.log.Timber


class MetronomeTimer {

    //private var handler = Handler()
    //private lateinit var runnable: Runnable


    fun startTicker(bpm: Int) {

        //convert bpm into millisec 60000/bpm = millisec
        var milliSec = 60000 / bpm
        Timber.i("Triggered")
        //runnable = Runnable {


        // postDelayed re-adds the action to the queue of actions the Handler is cycling
        // through. The delayMillis param tells the handler to run the runnable in
        // 1 second (1000ms)
        //handler.postDelayed(runnable, 1000)
//do the timer stuff}
    }
}
