package enko.felber.metronomus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.profile_card.view.*
import enko.felber.metronomus.Profile

import org.w3c.dom.Text

class ProfileAdapter(private val profileList: ArrayList<Profile>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_card, parent, false)
        return ProfileViewholder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewholder, position: Int) {
        val profileItem = profileList[position]

        holder.name.text = profileItem.pName
        holder.bpm.text = profileItem.pBpm.toString()
    }

    override fun getItemCount(): Int {
        return profileList.count()
    }

    class ProfileViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.name_cardview
        val bpm: TextView = itemView.bpm_cardview
    }
}