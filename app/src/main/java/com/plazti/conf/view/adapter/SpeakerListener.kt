package com.plazti.conf.view.adapter

import com.plazti.conf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker : Speaker, position: Int){

    }
}