package com.varsha.tourmate.view.ui.screen.beranda.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.tourmate.R
import com.varsha.tourmate.model.navigation.Screen
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    navController: NavController
) {
    val currentDate = LocalDate.now()
    var selectedMonth by remember { mutableStateOf(currentDate.month) }
    var expanded by remember { mutableStateOf(false) }
    var startDay by remember {
        // Initialize startDay to make the current day visible on the left
        mutableStateOf(maxOf(1, currentDate.dayOfMonth - 3))
    }

    val daysInMonth = YearMonth.of(currentDate.year, selectedMonth).lengthOfMonth()
    val maxVisibleDays = 7

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .background(Color(0xFFD3E3B5))
    ) {
        TopAppBar(
            backgroundColor = Color(0xFFD3E3B5),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            modifier = Modifier.background(Color(0xFFD3E3B5)),
            elevation = 0.dp  // Remove shadow
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedMonth.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + currentDate.year,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    Month.values().forEach { month ->
                        DropdownMenuItem(onClick = {
                            selectedMonth = month
                            expanded = false
                            // Reset startDay when month is changed
                            startDay = 1
                        }) {
                            Text(text = month.getDisplayName(TextStyle.FULL, Locale.getDefault()))
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .clickable { navController.navigate(Screen.Profil.route) },
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Date row with navigation buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    if (startDay > 1) {
                        startDay -= 1
                    }
                },
                enabled = startDay > 1
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    tint = Color.Black
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(minOf(maxVisibleDays, daysInMonth - startDay + 1)) { index ->
                    val day = startDay + index
                    val isToday = day == currentDate.dayOfMonth && selectedMonth == currentDate.month
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = if (isToday) Color(0xFF546161) else Color.Transparent,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day.toString(),
                            color = if (isToday) Color.White else Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            IconButton(
                onClick = {
                    if (startDay + maxVisibleDays - 1 < daysInMonth) {
                        startDay += 1
                    }
                },
                enabled = startDay + maxVisibleDays - 1 < daysInMonth
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color.Black
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun TopBarPreview() {
    TopBar(rememberNavController())
}

