package com.docband.docband.login.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.docband.docband.ui.theme.DocBandTheme

@Composable
fun NewUserR(navController: NavController) {

    DocBandTheme {

        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Image(
                    painter = painterResource(id = R.drawable.iconuser),
                    contentDescription = "Ho",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = "Usuario Nuevo",
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }//Column

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(60.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                textsRegister(inputText = "Nombre de Usuario")

                Spacer(modifier = Modifier.padding(5.dp))

                NameUser()

                Spacer(modifier = Modifier.padding(5.dp))

                textsRegister(inputText = "Correo")

                Spacer(modifier = Modifier.padding(5.dp))

                EmailUser()

                Spacer(modifier = Modifier.padding(5.dp))

                textsRegister(inputText = "Contraseña")

                Spacer(modifier = Modifier.padding(5.dp))

                PasswordNewUser()

                Spacer(modifier = Modifier.padding(5.dp))

                textsRegister(inputText = "Repetir Contraseña")

                Spacer(modifier = Modifier.padding(5.dp))

                RPasswordNewUser()

                Spacer(modifier = Modifier.padding(5.dp))

                ButtonRegister(Modifier.align(Alignment.CenterHorizontally), MedCheck(), navController)

            }

        }//Column

    }//DocBandTheme

}//NewUserR


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameUser() {

    var name1 by remember { mutableStateOf("") }

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

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailUser() {

    var name1 by remember { mutableStateOf("") }

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

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordNewUser() {

    var name by remember { mutableStateOf("") }

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

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RPasswordNewUser() {

    var name by remember { mutableStateOf("") }

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

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedCheck() : Boolean {

    val checked = remember { mutableStateOf(false) }

    Row (modifier = Modifier.clickable { checked.value = !checked.value}){

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

            }

            else{

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






