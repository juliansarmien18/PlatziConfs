package com.plazti.conf.viewmodel

import com.plazti.conf.model.Conference
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plazti.conf.network.Callback
import com.plazti.conf.network.FirestoreService
import java.lang.Exception

class ScheduleViewmodel: ViewModel() {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    private fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Conference>>{
            override fun onSuccess(result: List<Conference>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}