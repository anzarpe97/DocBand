@file:OptIn(ExperimentalMaterial3Api::class)

package com.docband.docband.newUser.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.selects.select

 @Preview(showBackground = true, )
@Composable
fun EditableExposedDropdownMenuSample() {

    // MenuOptions
    val options = listOf("General", "Birthday", "Anniversary", "Meeting", "Call", "Shopping")
    var expanded by remember { mutableStateOf(false) }
    var selectOptionText by remember { mutableStateOf(options[0]) }

    Box(modifier = Modifier.fillMaxSize()){



    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = false,
            value = selectOptionText,
            onValueChange = {},
            label = { Text(text = "Category")},
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
        )//OutlinedTextField

        ExposedDropdownMenu(

            expanded = expanded,
            onDismissRequest = {expanded = false }) {

            options.forEach{selectOption ->

                DropdownMenuItem(
                    text = {Text(text = selectOption)},
                    onClick = {
                        selectOptionText = selectOption
                        expanded = false},
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding )
            }

        }//ExposedDropdownMenu
    }//ExposedDropdownMenuBox
}//EditableExposedDropdownMenuSample