@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.docband.docband.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.docband.docband.ui.theme.montserratFamily
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import com.docband.docband.R
import com.docband.docband.ui.theme.DocBandTheme



@Composable
fun LoginScreen(navRegistro : () -> Unit, navHome : () -> Unit, viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Column(modifier = Modifier.fillMaxHeight()) {

        Column {


            Login(Modifier.align(Alignment.Start), navRegistro, navHome)


        }
    }
}

@Composable
fun Login(modifier: Modifier, navRegistro : () -> Unit, navHome : () -> Unit, labelId : String = "Email") {

    DocBandTheme {

        Column(modifier = Modifier.background(Color.White)) {

            HeaderImage()

            Column(
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "DocBand",
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTextInput("Usuario")
                    UserField()
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTextInput("Contraseña")
                    PasswordField()
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 15.dp, end = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ForgotPassword()
                    AreUNew(navRegistro)
                }
                Spacer(modifier = Modifier.padding(15.dp))

                ButtonLog(Modifier.align(Alignment.CenterHorizontally), navHome)

            }

        }
    }

}


@Composable
fun UserField() {

    var emailUser  by remember { mutableStateOf ("") }

    TextField(
        value = emailUser,
        onValueChange = { emailUser = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        maxLines = 1,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "User",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF7F7F7),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        )
    )

}

@Composable
fun PasswordField() {

    var name by remember { mutableStateOf("") }

    TextField(
        value = name,
        onValueChange = { name = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "User",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        maxLines = 1,
        textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF7F7F7),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
    )

}

@Composable
fun HeaderImage() {

    Image(
        painter = painterResource(id = R.drawable.doctor),
        contentDescription = "Doctora Logo",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MyTextInput(inputText: String) {

    Text(
        text = inputText,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Black,
        textAlign = TextAlign.Left,
        fontSize = 15.sp,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(bottom = 5.dp)
            .width(280.dp)

    )
}

@Composable
fun AreUNew(navRegistro : () -> Unit) {

    Text(
        text = "¿Eres Nuevo?",
        modifier = Modifier.clickable {navRegistro() },
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

}

@Composable
fun ForgotPassword() {

    Text(
        text = "¿Olvidaste tu Contraseña?",
        modifier = Modifier.clickable {},
        fontSize = 13   .sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

}

@Composable
fun ButtonLog(modifier: Modifier, navHome : () -> Unit) {

    Button(
        onClick = {navHome()}, modifier
            .width(250.dp)
            .height(48.dp)
    ) {

        Text(text = "Iniciar Sesión", color = MaterialTheme.colorScheme.inverseOnSurface)


    }

}


