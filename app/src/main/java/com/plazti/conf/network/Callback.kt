package com.plazti.conf.network

import com.plazti.conf.model.Conference
import java.lang.Exception

interface Callback<T>{
    fun onSuccess(result:T?)

    fun onFailed(exception: Exception)
}