package com.docband.docband.InfoView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.docband.docband.ui.theme.DocBandTheme
import com.docband.docband.ui.theme.montserratFamily

@Composable
fun InfoView(NavControler: NavHostController) {

    DocBandTheme {
        Column {

            ToolBar(NavControler)

            InfoContent()


        }


    }

}


@Composable
fun ToolBar(NavControler: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = { NavControler.popBackStack() }) {

            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Boton Regresar",
                tint = Color.White
            )

        }

        Text(
            text = "DocBand",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}


@Composable
fun InfoContent() {

    LazyColumn(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        item {
            Column (modifier = Modifier.fillMaxWidth().height(20.dp)){}
            Card(modifier = Modifier.fillMaxWidth()) {

                InfoCard()

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Card(modifier = Modifier.fillMaxWidth()) {

                HabitsContent()

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Card(modifier = Modifier.fillMaxWidth()) {

                VaccinesContent()

            }
            Column (modifier = Modifier.fillMaxWidth().height(20.dp)){}
        }

    }

}

@Composable
fun InfoCard(){

    Column(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Column(
            Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
            text = "Información Personal",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            fontFamily = montserratFamily)
        }
        Spacer(modifier = Modifier.padding(10.dp))

        LazyRow(){
            item {
                Column {
                    //Nombre
                    TextAndInfo(nameLabel = "Nombre y Apellido", infoLabel = "Cristiano Ronaldo")
                    //Edad
                    TextAndInfo(nameLabel = "Edad", infoLabel = "39")
                    //Sexo
                    TextAndInfo(nameLabel = "Genero", infoLabel = "Masculino")
                    //Cedula
                    TextAndInfo(nameLabel = "Cedula", infoLabel = "V-26456380")
                    //Fecha de Nacimiento
                    TextAndInfo(nameLabel = "Fecha Nacimiento", infoLabel = "5/02/1985")
                    //Fecha de Nacimiento
                    TextAndInfo(nameLabel = "Lugar Nacimiento", infoLabel = "Hospital Dr. Nélio Mendonça")
                    //Domicilio
                    TextAndInfo(nameLabel = "Domicilio", infoLabel = "Barrio Corazon De Jesus")
                    //Domicilio Habitual
                    TextAndInfo(nameLabel = "Domicilio Habitual", infoLabel = "El Bajo")
                    //Numero De Telefono
                    TextAndInfo(nameLabel = "Numero De Telefono", infoLabel = "04246325918")
                    //Religión
                    TextAndInfo(nameLabel = "Religión", infoLabel = "Cristiano")
                }
            }
        }
    }
}

@Composable
fun HabitsContent(){

    Column(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {

        Column(
            Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Habitos",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                fontFamily = montserratFamily,
            )
        }
    Spacer(modifier = Modifier.padding(10.dp))
    //Nombre
    TextAndInfo(nameLabel = "Tabáquico", infoLabel = "No")
    //Edad
    TextAndInfo(nameLabel = "Alcohol", infoLabel = "No")
    //Sexo
    TextAndInfo(nameLabel = "Café", infoLabel = "A veces")
    //Cedula
    TextAndInfo(nameLabel = "Alimentación", infoLabel = "Balanceada")
    //Fecha de Nacimiento
    TextAndInfo(nameLabel = "Medicamentos", infoLabel = "Emulsion Scott")
    }
}

@Composable
fun VaccinesContent(){

    Column(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {

        Column(
            Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Vacunas",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                fontFamily = montserratFamily,
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        //Nombre
        TextAndInfo(nameLabel = "Tabáquico", infoLabel = "No")
        //Edad
        TextAndInfo(nameLabel = "Alcohol", infoLabel = "No")
        //Sexo
        TextAndInfo(nameLabel = "Café", infoLabel = "Ocacionalmente")
        //Cedula
        TextAndInfo(nameLabel = "Alimentación", infoLabel = "Balanceada")
        //Fecha de Nacimiento
        TextAndInfo(nameLabel = "Medicamentos", infoLabel = "Emulsion Scott")
    }
}

@Composable
fun TextAndInfo(nameLabel: String, infoLabel: String) {
    Row(modifier = Modifier.padding(start = 5.dp)) {

        Text(text = "$nameLabel: ", fontWeight = FontWeight.Bold, fontFamily = montserratFamily)
        Text(text = "$infoLabel", fontWeight = FontWeight.SemiBold, fontFamily = montserratFamily)
        Spacer(modifier = Modifier.padding(15.dp))


    }
}

@Composable
fun TextAlone (textI : String) {

    Text(text = "$textI", fontWeight = FontWeight.Bold, fontFamily = montserratFamily)

}
