package enko.felber.metronomus

import android.app.Application
import android.media.AsyncPlayer
import android.media.MediaPlayer
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.*
import timber.log.Timber


class MetronomeTimer constructor(binding: FragmentMainScreenBinding) {

    //private var handler = Handler()
    //private lateinit var runnable: Runnable

    //for coroutine
    private var viewModelJob = Job()

    //Scope
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val bindingUtil = binding
    val clockViews: List<View> =
        listOf(
            binding.clock1,
            binding.clock2,
            binding.clock3,
            binding.clock4
        )


    fun startTicker(bpm: Int) {


        //convert bpm into millisec 60000/bpm = millisec
        var milliSec = 60000 / bpm

        //coroutine to use thread
        uiScope.launch {
            for (item in clockViews) {
                item.setBackgroundResource(R.drawable.rounded_textview_active)

                //BPM Timer Kicken
                delay(milliSec.toLong())

                item.setBackgroundResource(R.drawable.rounded_textview_inactive)
            }
        }

        //runnable = Runnable {


    }
}
