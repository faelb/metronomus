package enko.felber.metronomus

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class MainScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        val metronomeTimer: MetronomeTimer = MetronomeTimer(binding = binding)

        binding.imageViewPlayPause.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainScreen_to_testFragment)
        }

        //trigger inf clock function for color change of circle
        binding.buttonPlusOne.setOnClickListener { binding.clock1.setBackgroundResource(R.drawable.rounded_textview_active) }


        //holt die bpm als Int aus dem TextView
        val bpm = binding.textViewBPM.text.toString().toInt()
        //Timber.i("" +bpm)

        //TODO put value from getBPM into startTimer onClick function
        metronomeTimer.startTicker(bpm)


        return binding.root
    }

}
