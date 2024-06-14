package com.varsha.tourmate.view.ui.screen.notifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.tourmate.view.ui.screen.notifikasi.component.NotifikasiItemScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                    .background(Color(0xFFD3D3B7)),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew, // Replace with your back icon
                                contentDescription = "Icon Kembali",
                                tint = Color.Black
                            )
                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                        ){
                            Text(
                                text = "Notifikasi",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF3D4949)
                            )
                        }

                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFD3D3B7)
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            NotifikasiItemScreen(navController = navController)
            Divider(color = Color(0xFFB1BA93), thickness = 1.dp)
            NotifikasiItemScreen(navController = navController)
            Divider(color = Color(0xFFB1BA93), thickness = 1.dp)
        }
    }
}

@Preview
@Composable
private fun NotifikasiScreeenPreview() {
    NotifikasiScreen(navController = rememberNavController())
}