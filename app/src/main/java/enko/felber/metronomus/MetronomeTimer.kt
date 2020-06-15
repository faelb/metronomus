package enko.felber.metronomus

import android.app.Application
import android.os.Handler
import androidx.databinding.DataBindingUtil
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import timber.log.Timber


class MetronomeTimer constructor(binding: FragmentMainScreenBinding) {

    //private var handler = Handler()
    //private lateinit var runnable: Runnable
    val bindingUtil = binding

    fun startTicker(bpm: Int) {

        //convert bpm into millisec 60000/bpm = millisec
        var milliSec = 60000 / bpm
        Timber.i("Millisekunden: " +milliSec +"   BPM: " +bpm)
        //runnable = Runnable {


        // postDelayed re-adds the action to the queue of actions the Handler is cycling
        // through. The delayMillis param tells the handler to run the runnable in
        // 1 second (1000ms)
        //handler.postDelayed(runnable, 1000)
//do the timer stuff}
    }
}
