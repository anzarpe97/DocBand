package com.docband.docband.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel () {

    private val _emailUser = MutableLiveData<String> ()
    val emailUser : LiveData<String> = _emailUser


}