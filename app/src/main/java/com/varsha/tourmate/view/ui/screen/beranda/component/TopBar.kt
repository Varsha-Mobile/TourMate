package com.varsha.tourmate.view.ui.screen.beranda.component

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
import com.varsha.tourmate.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    androidx.compose.material.TopAppBar(
        backgroundColor = Color(0xFFD3E3B5),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "July 2024",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = null,
            modifier = Modifier.size(36.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar()
}