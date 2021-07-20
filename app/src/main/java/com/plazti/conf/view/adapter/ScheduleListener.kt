package com.plazti.conf.view.adapter

import com.plazti.conf.model.Conference


interface ScheduleListener {
    fun onConferenfeClicked(conference: Conference, position: Int){

    }
}