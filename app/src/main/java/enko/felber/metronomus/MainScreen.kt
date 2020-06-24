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
import androidx.navigation.fragment.findNavController
import enko.felber.metronomus.databinding.FragmentMainScreenBinding
import kotlinx.android.synthetic.main.fragment_main_screen.*
import timber.log.Timber
import kotlin.math.absoluteValue

/**
 * A simple [Fragment] subclass.
 */
class MainScreen : Fragment() {

    var myBPM: MYBPM = MYBPM(120)//startwert


    //for sounds later on
    private lateinit var player: MediaPlayer

    private lateinit var binding: FragmentMainScreenBinding

    private lateinit var metronomeTimer: MetronomeTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        player = MediaPlayer.create(context, R.raw.click)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        metronomeTimer = MetronomeTimer(binding = binding)



        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init BPM show
        textViewBPM.invalidate()
        textViewBPM.setText(myBPM.bpm.toString())

        //+ and - buttons change the bpm textfield
        buttonPlusOne.setOnClickListener { myBPM.bpm += 1;textViewBPM.setText(myBPM.bpm.toString()) }
        buttonPlusFive.setOnClickListener { myBPM.bpm += 5;textViewBPM.setText(myBPM.bpm.toString()) }
        buttonMinusOne.setOnClickListener { myBPM.bpm -= 1;textViewBPM.setText(myBPM.bpm.toString()) }
        buttonMinusFive.setOnClickListener { myBPM.bpm -= 5;textViewBPM.setText(myBPM.bpm.toString()) }

        binding.imageViewPlayPause.setOnClickListener {

            //get bpm value from input into data class
            myBPM.bpm = textViewBPM.text.toString().toInt()

            //starte ticker mit value aus der Dataclass
            metronomeTimer.startTicker(myBPM.bpm, player)

        }

        //Navigation to Profiles
        binding.profilesButton.setOnClickListener{view: View ->
            this.findNavController().navigate(R.id.action_mainScreen_to_profileFragment)
        }




    }

    //wenn man von Robertos Profilseite zurückkommt
    override fun onResume() {
        super.onResume()
        textViewBPM.invalidate()
        textViewBPM.setText(myBPM.bpm.toString())
    }

}
