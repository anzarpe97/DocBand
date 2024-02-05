package com.docband.docband.login.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.docband.docband.R

@Preview(showBackground = true, showSystemUi = true)
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
        Spacer(modifier = Modifier.padding(5.dp))

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "DocBand")
            Spacer(modifier = Modifier.padding(10.dp))
            UserField()
        }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField() {

    var name by remember { mutableStateOf("") }

    TextField(
        value = name,
        onValueChange = { name = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        placeholder = { Text(text = "Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(12.dp)


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

