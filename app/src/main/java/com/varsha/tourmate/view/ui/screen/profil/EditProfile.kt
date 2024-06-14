package com.varsha.tourmate.view.ui.screen.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.infiniteapp.data.DataStore
import com.infinitelearning.infiniteapp.data.SharedPreferencesManager
import com.varsha.tourmate.R
import com.varsha.tourmate.view.ui.screen.component.BackIconItem
import com.varsha.tourmate.view.ui.screen.profil.component.EditProfileContent
import com.varsha.tourmate.view.ui.screen.profil.component.ProfileContent


@Composable
fun EditProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val sharedPreferencesManager = remember {
        SharedPreferencesManager(context)
    }
//    val dataStore = DataStore(context)

    val nama = sharedPreferencesManager.name ?: ""
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFC1CB9C), RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp))
                    .padding(16.dp),
               // contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Edit Profil",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF222222),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ) {contentPadding->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    painter = painterResource(id = R.drawable.profil),
                    contentDescription = "Profil Photo",
                    modifier = Modifier
                        .size(104.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(32.dp))
                EditProfileContent(name = nama, navController = navController)
            }
        }
    }
}

@Preview
@Composable
private fun EditProfileScreenPreview() {
    EditProfileScreen(navController = rememberNavController())
}