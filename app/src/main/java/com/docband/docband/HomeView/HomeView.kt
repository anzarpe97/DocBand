package com.docband.docband.HomeView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.docband.docband.R
import com.docband.docband.ui.theme.DocBandTheme
import com.docband.docband.ui.theme.montserratFamily

@Preview(showBackground = true)
@Composable
fun HomeView(){
    DocBandTheme {

        Column (modifier = Modifier.fillMaxSize()) {

            BoxHeader(Modifier.fillMaxWidth(), "Usuario")

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
                verticalArrangement = Arrangement.Center){

                InfoButton(Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(40.dp))
                MyQR(Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(40.dp))
                MedicalHistory(Modifier.fillMaxWidth())
            }

        }
    }


}

@Composable
fun BoxHeader(modifier: Modifier, userName : String) {

    Column (
        modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .height(150.dp), horizontalAlignment = Alignment.CenterHorizontally){

        Image(
            painter = painterResource(id = R.drawable.iconuser),
            contentDescription = "Ho",
            modifier = Modifier
                .size(85.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Bienvenido, $userName", fontFamily = montserratFamily, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = Color.White)

    }

}

@Composable
fun InfoButton(modifier: Modifier) {

    Button(onClick = { /*TODO*/ }, modifier.height(80.dp)) {

        Text(text = "Mi Información", fontSize = 20.sp, fontFamily = montserratFamily)

    }

}

@Composable
fun MyQR(modifier: Modifier) {

    Button(onClick = { /*TODO*/ }, modifier.height(80.dp)) {

        Text(text = "Mi QR", fontSize = 20.sp, fontFamily = montserratFamily)

    }

}

@Composable
fun MedicalHistory(modifier: Modifier) {

    Button(onClick = { /*TODO*/ }, modifier.height(80.dp)) {

        Text(text = "Historial Medico", fontSize = 20.sp, fontFamily = montserratFamily)

    }

}































