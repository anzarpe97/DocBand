package com.docband.docband.login.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.docband.docband.newUser.ui.AccountUser
import com.docband.docband.newUser.ui.DataUser
import com.docband.docband.newUser.ui.HabitsUser
import com.docband.docband.newUser.ui.UserState
import com.google.firebase.Firebase
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

    @SuppressLint("SuspiciousIndentation")
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

        val db = Firebase.firestore

        val userNew = DataUser(name, cedula, gender, placeB, religion, address, usualAddress, phoneNumber, fPhoneNumber, occupation, etnia, typeBlood)
        val habitsUser = HabitsUser(food, drunk, smoke, coffee)
        val accountUser = AccountUser(emailUser, passwordNewUser, cedula)


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

    fun validateAllFields (name: String,
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
                           email: String,
                           password: String,
                           rPassword: String) : UserState{

        var test : UserState = UserState( true , "")

        //Nombre
        if (test.flagUser){

            test = validateNameInput(name)

        }

        //Cedula
        if (test.flagUser){

            test = validateCedulaInput(cedula)

        }

        //Genero

        if (test.flagUser){

            test = validateComboBox(gender,"Genero" )

        }

        //Lugar De Nacimiento

        if (test.flagUser){

            test = validateEmptyTextField(placeB, "Lugar de Nacimiento")

        }

        // Religion

        if (test.flagUser){

            test = validateComboBox(religion,"Religión" )

        }

        if (test.flagUser){

            test = validateEmptyTextField(address, "Dirección")

        }

        if (test.flagUser){

            test = validateEmptyTextField(usualAddress, "Dirección Habitual")

        }


        if (test.flagUser){

            test = validateEmptyTextField(phoneNumber, "Número De Telefono")

        }

        if (test.flagUser){

            test = validateEmptyTextField(fPhoneNumber, "Numero Familiar")

        }


        if (test.flagUser){

            test = validateEmptyTextField(occupation, "Ocupación")

        }

        if (test.flagUser){

            test = validateComboBox(etnia,"Étnia" )

        }

        Log.d("Docband ERROR: ", "Paso 11")
        Log.d("Docband ERROR: ", "test : $test")

        if (test.flagUser){

            test = validateComboBox(typeBlood,"Tipo De Sangre" )

        }

        Log.d("Docband ERROR: ", "Paso 12")
        Log.d("Docband ERROR: ", "test : $test")

        if (test.flagUser){

            test = validateComboBox(food,"Alimentación" )

        }

        Log.d("Docband ERROR: ", "Paso 13")
        Log.d("Docband ERROR: ", "test : $test")

        if (test.flagUser){

            test = validateComboBox(drunk,"Bebidas" )

        }

        Log.d("Docband ERROR: ", "Paso 14")
        Log.d("Docband ERROR: ", "test : $test")

        if (test.flagUser){

            test = validateComboBox(smoke,"Tabáquico" )

        }

        if (test.flagUser){

            test = validateComboBox(coffee,"Café" )

        }

        if (test.flagUser){

            test = validateEmailInput (email)

        }

        if (test.flagUser){

            test = validatePasswordInput(password,rPassword)

        }

        return test
    }

    fun validatePasswordInput (password1: String, password2 : String) : UserState {

            if (password1 != password2){

                return UserState(false, "Las Contraseñas No Son Iguales")

            }

            if (password1.length < 6){

                return UserState(false, "La contraseña de debe contener mas de 6 Caracteres")

            }

            if (!password1.any{it.isUpperCase()}){

                return UserState(false, "La Contraseña Debe Contener un Caracter En Mayuscula")

             }


            if (!password1.any{it.isLowerCase()}){

                return UserState(false, "La Contraseña Debe Contener un Caracter En Minuscula")

             }

            if (!password1.any{it.isDigit()}){

            return UserState(false, "La Contraseña Debe Contener Un Numero")

            }

            if (!password1.any{!it.isLetter() && !it.isDigit()}){

                return UserState(false, "La Contraseña Debe Contener un Caracter Especial")

            }

        return UserState()
    }

    fun validateEmailInput (email : String) : UserState {


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            return UserState(false, "Email incorrecto")
        }

        return UserState()
    }

    fun validateNameInput (name : String) : UserState {

        var textNum :Boolean = onlyLetter(name)
        var flag = true
        val lName : Int = name.length
        var message = ""

        if (name == ""){

            message = "El Campo Nombre Nombre esta Vacio"

            flag = false

            return UserState(flag, message)

        }

        if (lName < 4){

            message = "Números de Caracteres mayor a 3"

            flag = false

            return UserState(flag, message)

        }

        if (!textNum){

            message = "El Nombre No Puede Contener Números"

            flag = false

            return UserState(flag, message)

        }


        return UserState(flag, message)
    }

    fun validateCedulaInput (cedula: String) : UserState{
        val lCedula = cedula.length
        var flag = true
        var message = ""

        if (cedula == ""){

            message = "El Campo cedula está Vacio"

            flag = false

        }

        if (lCedula < 7){

            message = "La Cedula Debe Ser Mayor a 1 Millón"

            flag = false

            return UserState(flag, message)

        }

        if (lCedula > 8){

            message = "La Cedula Debe Ser Menor a 50 Millones"

            flag = false

            return UserState(flag, message)

        }

        return UserState(flag, message)
    }

    fun validateComboBox (data: String, content : String) : UserState{

        var message = ""

        if (data == ""){

            message = "El Campo $content está Vacio"

            return UserState(false, message)

        }

        return UserState(true, "")
    }

    fun validateEmptyTextField (data: String, content : String) : UserState{

        var flag = true
        var message = ""

        if (data == ""){

            message = "El Campo $content está Vacio"

            flag = false

        }

        return UserState(flag, message)
    }

    fun onlyLetter(text: String): Boolean {

        val regex = Regex("[^a-zA-Z ]")


        return !regex.containsMatchIn(text)
    }

    fun rightDate (date: String): Boolean {
        val regex = Regex("""^\d{2}/\d{2}/\d{4}$""")
        if (!regex.matches(date)) return false

        val dia = date.substring(0, 2).toInt()
        val mes = date.substring(3, 5).toInt()
        val anio = date.substring(6, 10).toInt()

        return dia in 1..31 && mes in 1..12 && anio > 0
    }

    fun rightEmail (email: String): Boolean {

        val regex = Regex("""^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\.(?:[a-zA-Z]{2,6})""")

        return regex.matches(email)
    }

}