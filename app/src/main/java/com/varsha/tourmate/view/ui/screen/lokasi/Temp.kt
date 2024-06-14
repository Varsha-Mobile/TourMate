package com.varsha.tourmate.view.ui.screen.lokasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TempScreen(modifier: Modifier = Modifier) {
    var startLocation = "AWAL"
    var endLocation = "AKHIR"

    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = startLocation,
            onValueChange = { startLocation = it },
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
        BasicTextField(
            value = endLocation,
            onValueChange = { endLocation = it },
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TempScreenPreview() {
    TempScreen()
}