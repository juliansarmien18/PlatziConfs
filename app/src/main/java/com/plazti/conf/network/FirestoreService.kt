package com.plazti.conf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.plazti.conf.model.Conference
import com.plazti.conf.model.Speaker

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService  {
    //realizamos la conexion a firestore
    val firebaseFirestore = FirebaseFirestore.getInstance()
    // obtenemos los datos para tenerlos de modo offline
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    //inicializador que se ejecuta apenas arranca la app
    init{
        //los datos permaneceran auque no haya conexion a internet
        firebaseFirestore.firestoreSettings = settings
    }
    fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}