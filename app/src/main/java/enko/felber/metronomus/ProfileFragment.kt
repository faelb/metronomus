package enko.felber.metronomus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import enko.felber.metronomus.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment(), ProfileAdapter.OnProfilItemClickListener {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)


        /*
        binding.genre1.setOnClickListener{view: View ->
            this.findNavController().navigate(R.id.action_profileFragment_to_mainScreen)
        }

         */

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rvProfile: RecyclerView = binding.profileRecyclerview
        var adapter: ProfileAdapter = ProfileAdapter(Profile.getProfileList() as ArrayList<Profile>, this)
        rvProfile.adapter = adapter
        rvProfile.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemClick(item: Profile, position: Int) {
        Toast.makeText(context, item.pName, Toast.LENGTH_SHORT).show()
    }
}
