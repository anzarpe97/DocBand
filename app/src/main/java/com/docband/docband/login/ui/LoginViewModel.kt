package com.docband.docband.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch


class LoginViewModel :ViewModel () {

    //Firebase
    private val auth: FirebaseAuth = Firebase.auth
    private val loading = MutableLiveData(false)

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnabled

    fun onLoginSelected() {

    }

    fun onLoginChanged(email: String, password: String) {

        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)

    }

    fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidPassword(password: String): Boolean = password.length > 6

    fun singInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {

            try {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{task ->

                    if(task.isSuccessful){

                        Log.d ("DocBand", "Login Exitoso")

                    }

                    else{

                        Log.d ("DocBand", "Error: ${task.result}")

                    }

                }

            }

            catch (ex : Exception){

                Log.d ("DocBand", "Error: ${ex.message}")

            }

        }

}