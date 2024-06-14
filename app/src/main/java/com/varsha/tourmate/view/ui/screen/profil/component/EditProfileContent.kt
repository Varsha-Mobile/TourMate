package com.varsha.tourmate.view.ui.screen.profil.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.tourmate.view.ui.screen.component.ButtonItem1
import com.varsha.tourmate.view.ui.screen.component.ButtonItem2
import com.varsha.tourmate.view.ui.screen.component.ScheduleTimeTextField
import com.varsha.tourmate.view.ui.screen.component.TextFieldItem
import com.varsha.tourmate.view.ui.screen.component.TimePickerDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileContent(
    name: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ){
        TextFieldItem(
            value = name,
            onValueChange = { firstname = it },
            label = "Masukkan Nama Depan",
        )

        TextFieldItem(
            value = lastname,
            onValueChange = { lastname = it },
            label = "Masukkan Nama Belakang",
        )

        TextFieldItem(
            value = email,
            onValueChange = { email = it },
            label = "Masukkan Email",
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonItem1(
                text = "Cancel",
                onClick = {},
                navController = rememberNavController(),
            )
            Spacer(modifier = Modifier.width(8.dp))
            ButtonItem2(
                text = "Save",
                onClick = {},
                navController = rememberNavController(),
            )
        }
    }

}

@Preview
@Composable
private fun EditProfileComponentPreview() {
    EditProfileContent(name = "a",navController = rememberNavController())
}