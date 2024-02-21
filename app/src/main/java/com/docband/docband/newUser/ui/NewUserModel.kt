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

    private val _drunk = MutableLiveData<String>()
    val drunk: LiveData<String> = _drunk

    private val _smoke = MutableLiveData<String>()
    val smoke: LiveData<String> = _smoke

    private val _coffee = MutableLiveData<String>()
    val coffee: LiveData<String> = _coffee

    private val _nameUser = MutableLiveData<String>()
    val nameUser: LiveData<String> = _nameUser

    private val _emailUser = MutableLiveData<String>()
    val emailUser: LiveData<String> = _emailUser

    private val _passwordNewUser = MutableLiveData<String>()
    val passwordNewUser: LiveData<String> = _passwordNewUser

    private val _rPasswordNewUser = MutableLiveData<String>()
    val rPasswordNewUser: LiveData<String> = _rPasswordNewUser



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
        food: String,
        drunk: String,
        smoke: String,
        coffee: String,
    ) {

            _food.value = food
            _drunk.value = drunk
            _smoke.value = smoke
            _coffee.value = coffee
    }

    fun onLoginChangedAccount(nameUser: String, emailUser: String, passwordNewUser: String, rPasswordNewUser: String)

    {
        _nameUser.value = nameUser
        _emailUser.value = emailUser
        _passwordNewUser.value = passwordNewUser
        _rPasswordNewUser.value = rPasswordNewUser

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
        drunk: String,
        smoke: String,
        coffee: String,
        nameUser: String,
        emailUser: String,
        passwordNewUser: String,
        rPasswordNewUser: String,
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
        Log.d("Registro", "drunk: $drunk")
        Log.d("Registro", "smoke: $smoke")
        Log.d("Registro", "coffee: $coffee")
        Log.d("Registro", "nameUser: $nameUser")
        Log.d("Registro", "emailUser: $emailUser")
        Log.d("Registro", "passwordNewUser: $passwordNewUser")
        Log.d("Registro", "rPasswordNewUser: $rPasswordNewUser")

    }

}