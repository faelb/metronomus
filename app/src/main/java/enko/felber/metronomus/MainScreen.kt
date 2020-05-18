package enko.felber.metronomus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import enko.felber.metronomus.databinding.FragmentMainScreenBinding

/**
 * A simple [Fragment] subclass.
 */
class MainScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentMainScreenBinding = DataBindingUtil.inflate(inflater,R.id.mainScreen,container,false)

        return binding.root
    }

}
