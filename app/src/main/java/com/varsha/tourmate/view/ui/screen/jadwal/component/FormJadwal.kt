package com.varsha.tourmate.view.ui.screen.jadwal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun FormJadwal(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    var scheduleText by remember { mutableStateOf("") }
    var scheduleDateStart by remember { mutableStateOf("") }
    var scheduleDateEnd by remember { mutableStateOf("") }
    var scheduleTime by rememberSaveable { mutableStateOf("") }

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePickerStart by remember { mutableStateOf(false) }

    var showDatePickerEnd by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }

    var jadwaltitle by remember { mutableStateOf("") }


    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                        showTimePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showTimePicker = false }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            TimePicker(state = timePickerState)
        }
    }

    if (showDatePickerStart) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerStart = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        scheduleDateStart = formatter.format(selectedDate.time)
                        showDatePickerStart = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePickerStart = false }
                ) { Text("Cancel") }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if (showDatePickerEnd) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerEnd = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        scheduleDateStart = formatter.format(selectedDate.time)
                        showDatePickerEnd = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePickerEnd = false }
                ) { Text("Cancel") }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
    
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ){
        TextFieldItem(
            value = jadwaltitle,
            onValueChange = { jadwaltitle = it },
            label = "Masukkan Nama Plan",
        )

        ScheduleTimeTextField(
            value = scheduleDateStart,
            onValueChange = { scheduleDateStart = it },
            label = "Start Date",
            icon = Icons.Default.DateRange,
            onIconClick = {
                showDatePickerStart = true
            }
        )

        ScheduleTimeTextField(
            value = scheduleDateEnd,
            onValueChange = { scheduleDateEnd = it },
            label = "End Date",
            icon = Icons.Default.DateRange,
            onIconClick = {
                showDatePickerEnd = true
            }
        )

        ScheduleTimeTextField(
            value = scheduleTime,
            onValueChange = { scheduleTime = it },
            label = "Atur Jam",
            icon = Icons.Default.AccessTime,
            onIconClick = {
                showTimePicker = true
            }
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
private fun FormJadwalScreen() {
    FormJadwal()
}