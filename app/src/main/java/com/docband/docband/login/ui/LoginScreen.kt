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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.docband.docband.R
import com.docband.docband.ui.theme.DocBandTheme

@Composable
fun LoginScreen(navRegistro : () -> Unit, navHome : () -> Unit, viewModel: LoginViewModel) {
    Column(modifier = Modifier.fillMaxHeight()) {

        Column {


            Login(Modifier.align(Alignment.Start), navRegistro, navHome,viewModel)


        }
    }
}

@Composable
fun Login(
    modifier: Modifier,
    navRegistro: () -> Unit,
    navHome: () -> Unit,
    viewModel: LoginViewModel
) {

    DocBandTheme {

        //ViewModel
        val email : String by viewModel.email.observeAsState(initial = "")
        val password : String by viewModel.password.observeAsState(initial = "")
        val loginEnable : Boolean by viewModel.loginEnable.observeAsState(initial = false)


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
                    MyTextInput("Usuario o Email")
                    UserField(email) {viewModel.onLoginChanged(it, password)}
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTextInput("Contraseña")
                    PasswordField(password) {viewModel.onLoginChanged(email, it)}
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

                ButtonLog(Modifier.align(Alignment.CenterHorizontally), navHome, loginEnable, viewModel, email, password)

            }

        }
    }

}


@Composable
fun UserField(email: String, onTextFieldChange: (String) -> Unit ) {


    TextField(
        value = email,
        onValueChange = { onTextFieldChange (it) },
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
fun PasswordField(password: String, onTextFieldChange: (String) -> Unit) {

    TextField(
        value = password,
        onValueChange = {onTextFieldChange(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
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
fun ButtonLog(
    modifier: Modifier,
    navHome: () -> Unit,
    loginEnable: Boolean,
    viewModel: LoginViewModel,
    email: String,
    password: String
) {

    Button(
        onClick = {
            viewModel.singInWithEmailAndPassword(email,password,navHome)
                  }, modifier
            .width(250.dp)
            .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF05A1D4),
                disabledContainerColor = Color(0xFFA3DAEC)
            ),enabled = loginEnable) {
        Text(text = "Iniciar Sesión", color = MaterialTheme.colorScheme.inverseOnSurface)
    }

}


