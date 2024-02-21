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

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

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

    private val _etnia = MutableLiveData<String>()
    val etnia: LiveData<String> = _etnia

    private val _typeBlood = MutableLiveData<String>()
    val typeBlood: LiveData<String> = _typeBlood

    private val _food = MutableLiveData<String>()
    val food: LiveData<String> = _food

    //Capturar Valores
    fun onLoginChanged(
        name: String,
        cedula: String,
        gender: String,
        placeB: String,
        religion: String,
        address: String,
        usualAddress: String,
        phoneNumber: String,
        fPhoneNumber: String,
        occupation: String,
        etnia: String,
        typeBlood: String,

    ) {

        _name.value = name
        _cedula.value = cedula
        _gender.value = gender
        _placeB.value = placeB
        _religion.value = religion
        _address.value = address
        _usualAddress.value = usualAddress
        _phoneNumber.value = phoneNumber
        _fPhoneNumber.value = fPhoneNumber
        _occupation.value = occupation
        _etnia.value = etnia
        _typeBlood.value = typeBlood

    }

    fun onLoginChangedHabits(
        food: String
    ) {

           _food.value = food
    }

    fun printValues(
        name: String,
        cedula: String,
        gender: String,
        placeB: String,
        religion: String,
        address: String,
        usualAddress: String,
        phoneNumber: String,
        fPhoneNumber: String,
        occupation: String,
        etnia: String,
        typeBlood: String,
        food: String,
    ) {

        Log.d("Registro", "Nombre: $name")
        Log.d("Registro", "cedula: $cedula")
        Log.d("Registro", "Genero: $gender")
        Log.d("Registro", "Lugar de Nacimiento: $placeB")
        Log.d("Registro", "Religion: $religion")
        Log.d("Registro", "Address: $address")
        Log.d("Registro", "usualAddress: $usualAddress")
        Log.d("Registro", "phoneNumber: $phoneNumber")
        Log.d("Registro", "fPhoneNumber: $fPhoneNumber")
        Log.d("Registro", "occupation: $occupation")
        Log.d("Registro", "etnia: $etnia")
        Log.d("Registro", "typeBlood: $typeBlood")
        Log.d("Registro", "food: $food")


    }

}