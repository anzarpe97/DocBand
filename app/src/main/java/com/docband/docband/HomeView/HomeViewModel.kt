package com.docband.docband.HomeView

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HomeViewModel {
    private val _nameUserHome = MutableLiveData<String>()
    val nameUserHome: LiveData<String> = _nameUserHome

    fun homeChanged (userCedula: String) {
        _nameUserHome.value = userCedula

    }

    fun printCedula (){
        Log.d( "prueba cedula", "${_nameUserHome.value}")
    }

    fun getDataClass (info:HomeData){
        _nameUserHome.value = info.cedula
    }
}