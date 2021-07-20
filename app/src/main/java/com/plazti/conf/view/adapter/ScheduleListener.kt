package com.plazti.conf.view.adapter

import com.plazti.conf.model.Conference
import com.plazti.conf.model.Speaker


interface ScheduleListener {
    fun onconferenceClicked(conference: Conference, position: Int){

    }
}