package enko.felber.metronomus

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import kotlinx.android.synthetic.main.fragment_main_screen.*
import timber.log.Timber
import kotlin.math.absoluteValue

/**
 * A simple [Fragment] subclass.
 */
class MainScreen : Fragment() {

   private val myBPM: MYBPM = MYBPM(120)//startwert

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //for sounds later on
        var player: MediaPlayer = MediaPlayer.create(context,R.raw.click)




        val binding: FragmentMainScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        val metronomeTimer: MetronomeTimer = MetronomeTimer(binding = binding)


        //+ and - buttons change the bpm textfield
        binding.buttonPlusOne.setOnClickListener {myBPM.bpm = (myBPM.bpm+1) }
        binding.buttonPlusFive.setOnClickListener {myBPM.bpm = (myBPM.bpm+5) }
        binding.buttonMinusOne.setOnClickListener {myBPM.bpm = (myBPM.bpm-1) }
        binding.buttonMinusFive.setOnClickListener {myBPM.bpm = (myBPM.bpm-5) }






        binding.imageViewPlayPause.setOnClickListener {

            //get bpm value from input into data class
            //myBPM.bpm = textViewBPM.text.toString().toInt()

            //starte ticker mit value aus der Dataclass
            metronomeTimer.startTicker(myBPM.bpm,player)

        }



        return binding.root
    }

}
