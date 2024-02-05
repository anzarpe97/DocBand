package com.docband.docband.login.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.docband.docband.R
import com.docband.docband.ui.theme.montserratFamily
import androidx.compose.material3.Button


@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_7")
@Composable
fun LoginScreen() {
    Column(modifier = Modifier.fillMaxHeight()) {

        Column {

            Login(Modifier.align(Alignment.Start))
        }
    }
}

@Composable
fun Login(modifier: Modifier) {

    Column(modifier = Modifier) {

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
                modifier = Modifier.fillMaxWidth()
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

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, top = 15.dp, end = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ForgotPassword()
                AreUNew()
            }
            Spacer(modifier = Modifier.padding(15.dp))
            ButtonLog(Modifier.align(Alignment.CenterHorizontally))

        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField() {

    var name1 by remember { mutableStateOf("") }

    TextField(
        value = name1,
        onValueChange = { name1 = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp),
        maxLines = 1,
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
        maxLines = 1,
        textStyle = TextStyle(fontSize = 20.sp),
        shape = RoundedCornerShape(12.dp),
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
    val myColor = Color(0xFFD50000)

    Text(
        text = inputText,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Black,
        textAlign = TextAlign.Left,
        fontSize = 15.sp,
        modifier = Modifier
            .padding(bottom = 5.dp)
            .width(280.dp)

    )
}

@Composable
fun AreUNew() {

    Text(
        text = "¿Eres Nuevo?",
        modifier = Modifier.clickable { },
        fontSize = 10.sp,
        fontWeight = FontWeight.Black
    )

}

@Composable
fun ForgotPassword() {

    Text(
        text = "¿Olvidaste tu Contraseña?",
        modifier = Modifier.clickable { },
        fontSize = 10.sp,
        fontWeight = FontWeight.Black
    )

}

@Composable
fun ButtonLog(modifier: Modifier) {

        Button(onClick = { /*TODO*/ }, modifier
            .width(250.dp)
            .height(48.dp)
            ) {

            Text(text = "Iniciar Sesión")

        }

}