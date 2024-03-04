package com.docband.docband.login.ui

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.docband.docband.newUser.ui.AccountUser
import com.docband.docband.newUser.ui.DataUser
import com.docband.docband.newUser.ui.HabitsUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore


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

    private val _newUserEnable = MutableLiveData<Boolean>()
    val newUserEnable: LiveData<Boolean> = _newUserEnable



    //Data Class

    fun sendUserData(
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
        emailUser: String,
        passwordNewUser: String,
        rPasswordNewUser: String
    ) {
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        val db = Firebase.firestore

        val userNew = DataUser(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood
        )

        val habitsUser = HabitsUser(food, drunk, smoke, coffee)
        val accountUser = AccountUser(emailUser, passwordNewUser, cedula)

        val flagInformation: Boolean = validatedData(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood
        )

        val flagHabits : Boolean = validateHabits(food, drunk, smoke, coffee)
        val flagAccount : Boolean = validateAccount(emailUser, passwordNewUser,rPasswordNewUser)

        if (flagInformation) {
            if (flagHabits){
                if (flagAccount) {

                    db.collection("InformationUsers").document(cedula)
                        .set(userNew)
                        .addOnSuccessListener {
                            Log.d(
                                TAG,
                                "Registro Informacion Usuario Exitosa!"
                            )
                        }
                        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                    db.collection("HabitsUsers").document(cedula)
                        .set(habitsUser)
                        .addOnSuccessListener {
                            Log.d(
                                TAG,
                                "Registro Informacion Habitos Exitosa!"
                            )
                        }
                        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }


                    db.collection("AccountUsers").document(emailUser)
                        .set(accountUser)
                        .addOnSuccessListener { Log.d(TAG, "Registro Cuenta Usuarios Exitosa!") }
                        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
                }
            }

        } else {

            print("Hola guapo")

        }

    }

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

    fun onLoginChangedAccount(
        emailUser: String,
        passwordNewUser: String,
        rPasswordNewUser: String
    ) {
        _emailUser.value = emailUser
        _passwordNewUser.value = passwordNewUser
        _rPasswordNewUser.value = rPasswordNewUser

    }

    fun validatedData(
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
        typeBlood: String
    ): Boolean {

        val len = cedula.length
        Log.d("Docband ERROR: ", "Esta Mierda: $len")
        var allRight: Boolean = true

        if (name == "") {

            Log.d("Docband ERROR: ", "Campo Nombre Vacio")
            allRight = false

        }

        if (cedula == "") {

            Log.d("Docband ERROR: ", "Campo Cedula Vacio")
            allRight = false

        }

        if (len < 6) {

            Log.d("Docband ERROR: ", "Campo Cedula Invalido")
            allRight = false
        }

        if (len > 8) {

            Log.d("Docband ERROR: ", "Campo Cedula Invalido")
            allRight = false
        }

        if (gender == "") {

            Log.d("Docband ERROR: ", "Campo Genero Vacio")
            allRight = false

        }

        if (placeB == "") {

            Log.d("Docband ERROR: ", "Campo Lugar Nacimiento Vacio")
            allRight = false

        }

        if (religion == "") {

            Log.d("Docband ERROR: ", "Campo Religion Vacio")
            allRight = false

        }

        if (address == "") {

            Log.d("Docband ERROR: ", "Campo Direccion Vacio")
            allRight = false

        }

        if (usualAddress == "") {

            Log.d("Docband ERROR: ", "Campo Direccion Habitual Vacio")
            allRight = false

        }

        if (phoneNumber == "") {

            Log.d("Docband ERROR: ", "Campo Numero de telefono Vacio")
            allRight = false

        }

        if (fPhoneNumber == "") {

            Log.d("Docband ERROR: ", "Campo Familiar Numero de telefono Vacio")
            allRight = false
        }

        if (occupation == "") {

            Log.d("Docband ERROR: ", "Campo Trabajo Vacio")
            allRight = false

        }

        if (occupation == "") {

            Log.d("Docband ERROR: ", "Campo Trabajo Vacio")
            allRight = false

        }

        if (etnia == "") {

            Log.d("Docband ERROR: ", "Campo Etnia Vacio")
            allRight = false

        }

        if (typeBlood == "") {

            Log.d("Docband ERROR: ", "Campo Tipo de Sangre Vacio")
            allRight = false

        }

        return allRight

    }


    fun validateHabits (food: String,
                        drunk: String,
                        smoke: String,
                        coffee: String) : Boolean {

        var flag : Boolean = true

        if (food == "") {

            Log.d("Docband ERROR: ", "Campo Comida Vacio")
            flag = false

        }

        if (drunk == "") {

            Log.d("Docband ERROR: ", "Campo Bebidas Vacio")
            flag = false

        }

        if (smoke == "") {

            Log.d("Docband ERROR: ", "Campo Fumar Vacio")
            flag = false

        }

        if (coffee == "") {

            Log.d("Docband ERROR: ", "Campo Cafe Vacio")
            flag = false

        }

        return flag

    }

    fun validateAccount (email: String,
                        password: String,
                        rPassword: String) : Boolean {

        Log.d("Docband ERROR: ", password)
        Log.d("Docband ERROR: ", rPassword)

        var flag : Boolean = true

        if (email == "") {

            Log.d("Docband ERROR: ", "Campo Comida Vacio")
            flag = false

        }

        if (password != "" && rPassword != "") {

            if (password != rPassword) {

                Log.d("Docband ERROR: ", "Contraseñas Distintas")
                flag = false

            }
        }

        else{

                Log.d("Docband ERROR: ", "Campos Vacios Contraseñas")
                flag = false

        }

        return flag

    }


}