@file:OptIn(
    ExperimentalMaterial3Api::class
)

package com.docband.docband.login.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.docband.docband.R
import com.docband.docband.ui.theme.montserratFamily
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.docband.docband.newUser.ui.UserState
import com.docband.docband.ui.theme.DocBandTheme
import java.time.Instant
import java.time.ZoneId

@Composable
fun NewUserR(navController: NavController, viewModel: NewUserModel) {

    DocBandTheme {

        //Atributos
        val name: String by viewModel.name.observeAsState(initial = "")
        val cedula: String by viewModel.cedula.observeAsState(initial = "")
        val gender: String by viewModel.gender.observeAsState(initial = "")
        val placeB: String by viewModel.placeB.observeAsState(initial = "")
        val religion: String by viewModel.religion.observeAsState(initial = "")
        val address: String by viewModel.address.observeAsState(initial = "")
        val usualAddress: String by viewModel.usualAddress.observeAsState(initial = "")
        val phoneNumber: String by viewModel.phoneNumber.observeAsState(initial = "")
        val fPhoneNumber: String by viewModel.fPhoneNumber.observeAsState(initial = "")
        val occupation: String by viewModel.occupation.observeAsState(initial = "")
        val etnia: String by viewModel.etnia.observeAsState(initial = "")
        val typeBlood: String by viewModel.typeBlood.observeAsState(initial = "")
        val food: String by viewModel.food.observeAsState(initial = "")
        val drunk: String by viewModel.drunk.observeAsState(initial = "")
        val smoke: String by viewModel.smoke.observeAsState(initial = "")
        val coffee: String by viewModel.coffee.observeAsState(initial = "")
        val emailUser: String by viewModel.emailUser.observeAsState(initial = "")
        val passwordNewUser: String by viewModel.passwordNewUser.observeAsState(initial = "")
        val rPasswordNewUser: String by viewModel.rPasswordNewUser.observeAsState(initial = "")

        val newUserEnable : Boolean by viewModel.newUserEnable.observeAsState(initial = false)

        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Image(
                    painter = painterResource(id = R.drawable.iconuser),
                    contentDescription = "Ho",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = "Usuario Nuevo",
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 30.sp
                )
            }//Column

            LazyColumn() {

                //Información
                item {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        InfomationContent(
                            viewModel,
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
                            typeBlood)
                    }
                }

                //Habitos

                item {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        HabitsContent(viewModel, food, drunk, smoke, coffee)
                    }
                }

                //Cuenta Usuario
                item {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Spacer(modifier = Modifier.padding(15.dp))

                        DividerContent("Usuario y Contraseña")

                        AccountContent(viewModel, emailUser, passwordNewUser, rPasswordNewUser)
                    }


                }

                // Boton Enviar
                item {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Spacer(modifier = Modifier.padding(15.dp))

                        ButtonRegister(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            MedCheck(),
                            navController,
                            viewModel,
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
                            typeBlood,
                            food,
                            drunk,
                            smoke,
                            coffee,
                            emailUser,
                            passwordNewUser,
                            rPasswordNewUser
                        )

                        Spacer(modifier = Modifier.padding(15.dp))
                    }


                }

            }

        }//Column

    }//DocBandTheme

}//NewUserR

@Composable
fun AccountContent(
    viewModel: NewUserModel,
    emailUser: String,
    passwordNewUser: String,
    rPasswordNewUser: String
) {


    EmailUser(emailUser) { viewModel.onLoginChangedAccount(it, passwordNewUser, rPasswordNewUser) }

    PasswordNewUser(passwordNewUser) {
        viewModel.onLoginChangedAccount(
            emailUser,
            it,
            rPasswordNewUser
        )
    }

    RPasswordNewUser(rPasswordNewUser) {
        viewModel.onLoginChangedAccount(
            emailUser,
            passwordNewUser,
            it
        )
    }

}

@Composable
fun InfomationContent(
    viewModel: NewUserModel,
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
    Spacer(modifier = Modifier.padding(10.dp))

    DividerContent(nameDivider = "Informacion Personal")

    IUserName(name) {
        viewModel.onLoginChanged(
            it,
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
            typeBlood,
        )
    }

    NumCedula(cedula) {
        viewModel.onLoginChanged(
            name,
            it,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    Gender(gender) {
        viewModel.onLoginChanged(
            name,
            cedula,
            it,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    DateUser()

    PlaceBrith(placeB) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            it,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    Religion(religion) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            it,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    Address(address) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            religion,
            it,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    UsualAddress(usualAddress) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            it,
            phoneNumber,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    PhoneNumber(phoneNumber) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            it,
            fPhoneNumber,
            occupation,
            etnia,
            typeBlood,
        )
    }
    FPhoneNumber(fPhoneNumber) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            it,
            occupation,
            etnia,
            typeBlood
        )
    }
    Occupation(occupation) {
        viewModel.onLoginChanged(
            name,
            cedula,
            gender,
            placeB,
            religion,
            address,
            usualAddress,
            phoneNumber,
            fPhoneNumber,
            it,
            etnia,
            typeBlood
        )
    }
    Etnia(etnia) {
        viewModel.onLoginChanged(
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
            it,
            typeBlood
        )
    }
    TypeBlood(typeBlood) {
        viewModel.onLoginChanged(
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
            it
        )
    }


}

@Composable
fun HabitsContent(
    viewModel: NewUserModel,
    food: String,
    drunk: String,
    smoke: String,
    coffee: String,


    ) {

    Spacer(modifier = Modifier.padding(15.dp))

    DividerContent(nameDivider = "Habitos")
    Food(food) {
        viewModel.onLoginChangedHabits(
            it, drunk, smoke, coffee
        )
    }

    Drunk(drunk) { viewModel.onLoginChangedHabits(food, it, smoke, coffee) }
    Smoke(smoke) { viewModel.onLoginChangedHabits(food, drunk, it, coffee) }
    Coffee(coffee) { viewModel.onLoginChangedHabits(food, drunk, smoke, it) }
}

//DIVIDER
@Composable
fun DividerContent(nameDivider: String) {

    TextTitle(textTile = nameDivider)

    Spacer(modifier = Modifier.padding(5.dp))

    Divider(
        color = MaterialTheme.colorScheme.primary,
        thickness = 1.dp,
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

//TEXT
@Composable
fun textsRegister(inputText: String) {

    Text(
        text = inputText,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Left,

        fontSize = 17.sp,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(bottom = 5.dp)


    )
}

@Composable
fun TextTitle(textTile: String) {

    Text(
        text = textTile,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    )

}

// INPUTS

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Information User

@Composable
fun IUserName(nameV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Nombre y Apellido")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = nameV,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun NumCedula(cedulaV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Cedula")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = cedulaV,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun DateUser() {

    val dateUser = rememberDatePickerState()

    var showDialog by remember {
        mutableStateOf(false)
    }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Fecha Nacimiento")

    Spacer(modifier = Modifier.padding(5.dp))

    Button(onClick = { showDialog = true }) {

        Text(text = "Seleccionar Fecha")

    }
    if (showDialog) {

        DatePickerDialog(onDismissRequest = { showDialog = false }, confirmButton = {

            OutlinedButton(onClick = { showDialog = false }) {
                Text(text = "Cancelar")
            }

            Button(onClick = { showDialog = false }) {

                Text(text = "Seleccionar")

            }

        }) {

            DatePicker(state = dateUser)

        }

    }
    val date = dateUser.selectedDateMillis

    date?.let {

        val localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()

        val p: String =
            localDate.dayOfMonth.toString() + localDate.monthValue.toString() + localDate.year.toString()

        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Fecha de Nacimiento: ${localDate.dayOfMonth}/${localDate.monthValue}/${localDate.year}",
            fontFamily = montserratFamily,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Normal
        )

    }

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun PlaceBrith(placeB: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Lugar de Nacimiento")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = placeB,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun Address(address: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Dirección")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = address,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))


}

@Composable
fun UsualAddress(usualAddress: String, onTextFieldChange: (String) -> Unit) {


    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Dirección Habitual")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = usualAddress,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun PhoneNumber(phoneNumber: String, onTextFieldChange: (String) -> Unit) {


    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Número de Télefono")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = phoneNumber,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun FPhoneNumber(fPhoneNumber: String, onTextFieldChange: (String) -> Unit) {


    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Número Familiar")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = fPhoneNumber,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun Occupation(occupation: String, onTextFieldChange: (String) -> Unit) {


    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Ocupación")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = occupation,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun Gender(generV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Genero")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf( "", "Masculino", "Femenino", "Otro")
    var expanded by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = gender,
            onValueChange = {},
            label = { Text("Selecciona Un Genero:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        gender = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun Religion(religionB: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Religión")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf( " ", "Cristiana", "Catolica", "Testigo De Jehova", " Atea", "Otros")
    var expanded by remember { mutableStateOf(false) }
    var religion by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = religion,
            onValueChange = {},
            label = { Text("Selecciona Una Religión:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        religion = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
}

@Composable
fun Etnia(etniaV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Etnia")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf( " ", "Si", "No")
    var expanded by remember { mutableStateOf(false) }
    var etnia by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = etnia,
            onValueChange = {},
            label = { Text("Selecciona Una Etnia:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        etnia = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
}

@Composable
fun TypeBlood(typeBloodV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Tipo De Sangre")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf("", "A+", "A-", "B+", "B-", "AB+", "AB-", "AB-", "O+", "O-")
    var expanded by remember { mutableStateOf(false) }
    var tBlood by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = tBlood,
            onValueChange = {},
            label = { Text("Selecciona Tipo De Sangre:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        tBlood = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(5.dp))

}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Habits

@Composable
fun Food(foodV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Alimentación")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf("", "Balanceada", "No Balanceada")
    var expanded by remember { mutableStateOf(false) }
    var food by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = food,
            onValueChange = {},
            label = { Text("Seleccione Alimentación:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        food = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(5.dp))
}



@Composable
fun Smoke(smokeV: String, onTextFieldChange: (String) -> Unit) {
    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Tabáquico")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf("", "Frecuente", "Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var smoke by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = smoke,
            onValueChange = {},
            label = { Text("Seleccione Frecuencía:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        smoke = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(5.dp))
}

@Composable
fun Drunk(drunkV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Alcohol")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf("", "Frecuente", "Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var drunk by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = drunk,
            onValueChange = {},
            label = { Text("Seleccione Frecuencía:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        drunk = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }
}

@Composable
fun Coffee(coffeeV: String, onTextFieldChange: (String) -> Unit) {

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Cafeina")

    Spacer(modifier = Modifier.padding(5.dp))

    val options = listOf("", "Frecuente", "Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var coffee by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = coffee,
            onValueChange = {},
            label = {Text("Seleccione Frecuencía:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        coffee = item
                        expanded = false
                        onTextFieldChange(item)
                    },
                )
            }
        }
    }
}

@Composable
fun EmailUser(emailUser: String, onTextFieldChange: (String) -> Unit) {


    textsRegister(inputText = "Correo Electronico")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = emailUser,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

    Spacer(modifier = Modifier.padding(5.dp))

}


@Composable
fun PasswordNewUser(passwordNewUser: String, onTextFieldChange: (String) -> Unit) {


    textsRegister(inputText = "Contraseña")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = passwordNewUser,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
    )

    Spacer(modifier = Modifier.padding(5.dp))

}


@Composable
fun RPasswordNewUser(rPasswordNewUser: String, onTextFieldChange: (String) -> Unit) {


    textsRegister(inputText = "Repetir Contraseña")



    TextField(
        value = rPasswordNewUser,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),

        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
    )

    Spacer(modifier = Modifier.padding(5.dp))

}


@Composable
fun MedCheck(): Boolean {

    val checked = remember { mutableStateOf(false) }

    Row(modifier = Modifier.clickable { checked.value = !checked.value }) {

        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it },

            )

        Text(
            text = "¿Eres Medico?",
            modifier = Modifier.padding(top = 13.dp),
            fontFamily = montserratFamily,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.padding(20.dp))
    }

    return checked.value

}

@Composable
fun ButtonRegister(
    modifier: Modifier,
    med: Boolean,
    navController: NavController,
    viewModel: NewUserModel,
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
    rPasswordNewUser: String) {

    val context = LocalContext.current
    var a : Boolean = false

    Spacer(modifier = Modifier.padding(15.dp))
    Button(
        onClick = {

                var allRight : UserState = viewModel.validateAllFields(
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
                    typeBlood,
                    food,
                    drunk,
                    smoke,
                    coffee,
                    emailUser,
                    passwordNewUser,
                    rPasswordNewUser)

                if (!allRight.flagUser) {

                    Toast.makeText(context, allRight.nameError, Toast.LENGTH_SHORT).show()

                }

                else{

                    viewModel.sendUserData(
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
                        typeBlood,
                        food,
                        drunk,
                        smoke,
                        coffee,
                        emailUser,
                        passwordNewUser,
                        rPasswordNewUser)

                    Toast.makeText(context, "Registro Exitoso (Paciente)", Toast.LENGTH_SHORT).show()

                    navController.popBackStack()


                }
        }, modifier
            .width(250.dp)
            .height(48.dp)

    ) {

        Text(text = "Registrar", color = MaterialTheme.colorScheme.inverseOnSurface)

    }

}