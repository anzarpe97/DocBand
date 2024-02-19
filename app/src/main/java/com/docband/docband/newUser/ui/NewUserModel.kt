package com.docband.docband.login.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewUserModel {

    //Datos Personales

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _cedula = MutableLiveData<String>()
    val cedula: LiveData<String> = _cedula

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> = _gender

    private val _dateU = MutableLiveData<String>()
    val dateU: LiveData<String> = _dateU

    private val _placeB = MutableLiveData<String>()
    val placeB: LiveData<String> = _placeB

    private val _religion = MutableLiveData<String>()
    val religion: LiveData<String> = _religion

    private val _adress = MutableLiveData<String>()
    val adress: LiveData<String> = _adress

    private val _usualAddress = MutableLiveData<String>()
    val usualAddress: LiveData<String> = _usualAddress

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _fPhoneNumber = MutableLiveData<String>()
    val fPhoneNumber: LiveData<String> = _fPhoneNumber

    private val _ethnicity = MutableLiveData<String>()
    val ethnicity: LiveData<String> = _ethnicity

    private val _occupation = MutableLiveData<String>()
    val occupation: LiveData<String> = _occupation

    private val _typeBlood = MutableLiveData<String>()
    val typeBlood: LiveData<String> = _typeBlood

    //Capturar Valores
    fun onLoginChanged(name: String, cedula: String, gender: String, placeB: String, religion : String) {

        _name.value = name
        _cedula.value = cedula
        _gender.value = gender
        _placeB.value = placeB
        _religion.value = religion

    }


    fun printValues(name: String, cedula: String, gender: String, placeB: String, religion : String) {

        Log.d("Registro", "Nombre: $name")
        Log.d("Registro", "cedula: $cedula")
        Log.d("Registro", "Genero: $gender")
        Log.d("Registro", "Lugar de Nacimiento: $placeB")
        Log.d("Registro", "Religion: $religion")


    }

}