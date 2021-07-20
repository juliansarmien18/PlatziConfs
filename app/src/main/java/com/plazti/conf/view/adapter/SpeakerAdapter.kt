package com.plazti.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.plazti.conf.R
import com.plazti.conf.model.Speaker

class SpeakerAdapter(val speakerListener : SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>(){
    var listSpeaker = ArrayList<Speaker>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))

    override fun getItemCount()= listSpeaker.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as Speaker

        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerName.text = speaker.workplace

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .into(holder.tvSpeakerImage)

        holder.itemView.setOnClickListener{
            speakerListener.onSpeakerClicked(speaker,position)
        }
    }
    fun updateData(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvSpeakerImage = itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.ISimage)
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.ISspeakerName)
        val tvActualJob = itemView.findViewById<TextView>(R.id.ISActualJob)
    }
}
