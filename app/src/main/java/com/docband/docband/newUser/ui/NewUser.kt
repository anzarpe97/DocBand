@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

package com.docband.docband.login.ui

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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import com.docband.docband.ui.theme.DocBandTheme
import java.time.Instant
import java.time.ZoneId

@Composable
fun NewUserR(navController: NavController) {

    DocBandTheme {

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

                //Informacion
                item {

                    Column ( modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){

                        InfomationContent()
                    }

                }

                //Habitos

                item {

                    Column ( modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){

                        HabitsContent()
                    }

                }

                //Cuenta Usuario
                item {

                    Column ( modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){

                        Spacer(modifier = Modifier.padding(15.dp))

                        DividerContent("Usuario y Contraseña")

                        AccountContent()
                    }



                }

                // Boton Enviar
                item {

                    Column ( modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 60.dp, end = 60.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){

                        Spacer(modifier = Modifier.padding(15.dp))

                        ButtonRegister(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            MedCheck(),
                            navController)

                        Spacer(modifier = Modifier.padding(15.dp))
                    }



                }

            }

        }//Column

    }//DocBandTheme

}//NewUserR

@Composable
fun AccountContent() {

    NameUser()

    EmailUser()

    PasswordNewUser()

    RPasswordNewUser()

}

@Composable
fun InfomationContent() {

    Spacer(modifier = Modifier.padding(10.dp))

    DividerContent(nameDivider = "Informacion Personal")

    IUserName()
    NumCedula()
    Gender()
    DateUser()
    PlaceBrith()
    Religion()
    Address()
    UsualAddress()
    PhoneNumber()
    FPhoneNumber()
    Occupation()
    Etnia()
    TypeBlood()

}

@Composable
fun HabitsContent(){
    Spacer(modifier = Modifier.padding(15.dp))
    DividerContent(nameDivider = "Habitos")
    Food()
    Drunk()
    Smoke()
    Coffe()
}

//DIVIDER
@Composable
fun DividerContent(nameDivider : String) {

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
fun IUserName() {

    var iUserName by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Nombre y Apellido")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = iUserName,
        onValueChange = { iUserName = it },
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
fun NumCedula() {

    var cedula by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Cedula")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = cedula,
        onValueChange = { cedula = it },
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
fun PlaceBrith (){

    var placeBirth by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Lugar de Nacimiento")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = placeBirth,
        onValueChange = { placeBirth = it },
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
fun Address (){

    var adress by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Dirección")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = adress,
        onValueChange = { adress = it },
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
fun UsualAddress(){

    var usualAdress by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Dirección Habitual")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = usualAdress,
        onValueChange = { usualAdress = it },
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
fun PhoneNumber (){

    var phoneNumber by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Número de Télefono")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = phoneNumber,
        onValueChange = { phoneNumber = it },
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
fun FPhoneNumber (){

    var fPhoneNumber by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Número Familiar")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = fPhoneNumber,
        onValueChange = { fPhoneNumber = it },
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
fun Occupation(){

    var occupation by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Ocupación")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = occupation,
        onValueChange = { occupation = it },
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
fun Gender() {
    val context = LocalContext.current
    val gener = arrayOf("Masculino", "Femenino", "Otro")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(gener[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Genero")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                gener.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.padding(5.dp))

}

@Composable
fun Religion() {
    val context = LocalContext.current
    val religion = arrayOf("", "Cristiana", "Catolica", "Testigos de Jehova", "Ninguna")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(religion[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Religión")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                religion.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Etnia() {
    val context = LocalContext.current
    val etnia = arrayOf("", "Si", "No")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(etnia[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Etnia")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                etnia.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
}
@Composable
fun TypeBlood() {
    val context = LocalContext.current
    val typeBlood = arrayOf("", "A+", "A-","B+","B-","AB+","AB-", "AB-", "O+", "O-")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeBlood[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Tipo de Sangre")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                typeBlood.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Habits

@Composable
fun Food() {
    val context = LocalContext.current
    val typeBlood = arrayOf("", "Balanceada", "No Balanceada")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeBlood[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Tipo de Alimentación")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                typeBlood.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Smoke() {
    val context = LocalContext.current
    val typeBlood = arrayOf("", "Frecuente","Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeBlood[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Tabáquico")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                typeBlood.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Drunk() {
    val context = LocalContext.current
    val typeBlood = arrayOf("", "Frecuente","Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeBlood[0]) }
    val focusManager = LocalFocusManager.current

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Alcohol")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()})

            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                typeBlood.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Coffe() {

    val context = LocalContext.current
    val typeBlood = arrayOf("", "Frecuente","Muy Frecuente", "Ocacional", "Muy Poco", "No")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeBlood[0]) }

    Spacer(modifier = Modifier.padding(5.dp))

    textsRegister(inputText = "Café")

    Spacer(modifier = Modifier.padding(5.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                typeBlood.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false

                        }
                    )
                }
            }
        }
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - User Name
@Composable
fun NameUser() {

    var name1 by remember { mutableStateOf("") }

    textsRegister(inputText = "Nombre de Usuario")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = name1,
        onValueChange = { name1 = it },
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
fun EmailUser() {

    var name1 by remember { mutableStateOf("") }

    textsRegister(inputText = "Correo Electronico")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = name1,
        onValueChange = { name1 = it },
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
fun PasswordNewUser() {

    var name by remember { mutableStateOf("") }

    textsRegister(inputText = "Contraseña")

    Spacer(modifier = Modifier.padding(5.dp))

    TextField(
        value = name,
        onValueChange = { name = it },
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
fun RPasswordNewUser() {

    var name by remember { mutableStateOf("") }

    textsRegister(inputText = "Repetir Contraseña")



    TextField(
        value = name,
        onValueChange = { name = it },
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
fun ButtonRegister(modifier: Modifier, med: Boolean, navController: NavController) {

    val context = LocalContext.current

    Spacer(modifier = Modifier.padding(15.dp))
    Button(
        onClick = {

            if (med) {
                Toast.makeText(context, "Registro Exitoso (medico)", Toast.LENGTH_SHORT).show()
                navController.popBackStack()

            } else {

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

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Combobox
