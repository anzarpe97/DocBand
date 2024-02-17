package com.docband.docband.login.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel :ViewModel () {

    private val auth : FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun singInWithEmailAndPassword (email: String, password : String, home:  () -> Unit)
    = viewModelScope.launch{

        try{

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
                if (task.isSuccessful){

                    Log.d("DocBand", "Inicio de sesión exitoso")
                    home
                }

                else{

                    Log.d("DocBand", "${task.result.toString()}")

                }
            }

        }

        catch (ex:Exception){

            Log.d("DocBand", "${ex.message}")

        }

    }
}