package enko.felber.metronomus

import android.media.MediaPlayer
import android.view.View
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.*


class MetronomeTimer constructor(binding: FragmentMainScreenBinding) {

    //private var handler = Handler()
    //private lateinit var runnable: Runnable


    //for coroutine
    private lateinit var viewModelJob: Job

    //um stop zu checken TODO umbennennen weil kein counter mehr (state)
    private var stopCounter:Boolean = true

    //Scope
    private lateinit var uiScope: CoroutineScope

    val bindingUtil = binding
    val clockViews: List<View> =
        listOf(
            binding.clock1,
            binding.clock2,
            binding.clock3,
            binding.clock4
        )

    fun getStopCounterState():Boolean{
        return stopCounter
    }

    fun toggleStopCounterState(){
        stopCounter = !stopCounter
    }

    //needed when switching from Mainscreen to Profiles (if metronom active)
    fun stopCoroutine(){
        if (uiScope != null)
            uiScope.cancel()
    }

    fun stopTicker() {
        toggleStopCounterState()
        if (stopCounter) {
            uiScope.cancel()
            //mach alle wieder hellblau
            for (item in clockViews) {
                item.setBackgroundResource(R.drawable.rounded_textview_inactive)
            }

        }
    }

    fun startTicker(bpm: Int, player: MediaPlayer) {
        //Handling für start-stop klicken
        toggleStopCounterState()
        if (stopCounter) {
            uiScope.cancel()
            //mach alle wieder hellblau
            for(item in clockViews){
                item.setBackgroundResource(R.drawable.rounded_textview_inactive)
            }
            return
        } else { //erstell den job erst hier und mach die coroutine
            viewModelJob = Job()

            uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


            //convert bpm into millisec 60000/bpm = millisec
            var milliSec = 60000 / bpm
            var counter = 0

            //coroutine to use thread
            uiScope.launch {
                while (counter < 4) { //button pause not pressed
                    clockViews[counter].setBackgroundResource(R.drawable.rounded_textview_active)
                    player.start()


                    //BPM Timer Kicken
                    delay(milliSec.toLong())


                    clockViews[counter].setBackgroundResource(R.drawable.rounded_textview_inactive)
                    counter++

                    if (counter == 4) {
                        counter = 0
                    }

                }
            }


        }//else block ende
    }


}
