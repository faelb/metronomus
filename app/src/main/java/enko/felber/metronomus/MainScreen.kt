package enko.felber.metronomus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import enko.felber.metronomus.databinding.FragmentMainScreenBinding

/**
 * A simple [Fragment] subclass.
 */
class MainScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding:FragmentMainScreenBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen,container,false)

        //binding.imageViewPlayPause.setOnClickListener { it.findNavController().navigate(R.id.action_mainScreen_to_testFragment) }

        return binding.root
    }

}
