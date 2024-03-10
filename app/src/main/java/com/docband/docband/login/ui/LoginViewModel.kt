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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel : ViewModel () {

    //Firebase
    private val auth :FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnabled

    fun singIn (email: String, password: String, home: () -> Unit) {

        val db = Firebase.firestore

        val loginAccount = db.collection("AccountUsers").document(email)
        loginAccount.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val user = document.toObject<UserAccount>()
                    val userEmail = user?.email
                    val userPassword = user?.password
                    val userCedula = user?.cedula

                    if (password==userPassword){
                        Log.d( "password", "el password es el mismo")
                        home()
                    }
                    else{
                        Log.d( "password", "el password no es el mismo")
                    }

                    Log.d( "DocumentSnapshot data: $userEmail", "$userEmail")

                } else {
                    Log.d( "No such document", "No se pudo iniciar")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("get failed with ","error",  exception)
            }

    }
    fun singInWithEmailAndPassword(email: String, password: String, home: ()-> Unit)
    = viewModelScope.launch{

        try {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->

                    if(task.isSuccessful){

                        Log.d("DocBand", "Inicio Exsitoso")
                        home()

                     }

                    else{

                        Log.d("juanchacin", "Error: ${task.result.toString()}")

                    }
            }

        }

        catch (ex:Exception){

            Log.d("DocBand","Error: ${ex.message}")

        }
    }//Login

    fun onLoginChanged(email: String, password: String) {

        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)

    }



    fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidPassword(password: String): Boolean = password.length > 6


}