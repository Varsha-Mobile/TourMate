package com.varsha.tourmate.view.ui.screen.beranda.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HariTanggalItem(modifier: Modifier = Modifier) {
    val currentDate = LocalDate.now()
    val formattedDate =
        currentDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d", Locale.getDefault()))

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = formattedDate,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = "0 schedule",
            style = TextStyle(
                color = Color.Gray
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun HariTanggalItemPreview() {
    HariTanggalItem()
}