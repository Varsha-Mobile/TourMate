package com.varsha.tourmate.view.ui.screen.pengaturan.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.infiniteapp.data.DataStore
import com.infinitelearning.infiniteapp.data.SharedPreferencesManager
import com.varsha.tourmate.R
import com.varsha.tourmate.model.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun PengaturanItemScreen(
    navController: NavController,
   // onLogoutClick: ()-> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()


    val sharedPreferencesManager = remember {
        SharedPreferencesManager(context)
    }
    val dataStore = DataStore(context)
    PengaturanItemContent(onLogoutClick = {
        sharedPreferencesManager.clear()
        coroutineScope.launch {
            dataStore.clearStatus()
        }
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Beranda.route) {
                inclusive = true
            }
        }
    }, navController = navController)
}

@Composable
fun PengaturanItemContent(
    navController: NavController,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var isNotificationEnabled by remember { mutableStateOf(false) }
        var isDarkModeEnabled by remember { mutableStateOf(false) }

        PengaturanItem(
            title = "Notification",
            isChecked = isNotificationEnabled,
            onCheckedChange = { isNotificationEnabled = it }
        )

        PengaturanItem(
            title = "Dark mode",
            isChecked = isDarkModeEnabled,
            onCheckedChange = { isDarkModeEnabled = it }
        )

        PengaturanItemWithIcon(
            title = "Change password",
            icon = Icons.Default.KeyboardArrowRight,
            contentDescription = "Icon Arrow",
            onClick = {
                //
            }
        )

        PengaturanItemWithIcon(
            title = "Logout",
            icon = Icons.Default.Logout,
            contentDescription = "Icon Arrow",
            onClick =
            onLogoutClick
        )
    }
}

@Composable
fun PengaturanItem(
    title: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            style = TextStyle(
                color = Color(0xFF495555)
            )
        )
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFF9AA27D),
                checkedBorderColor = Color.Transparent,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFFA1AEAD),
                uncheckedBorderColor = Color.Transparent
            )
        )
    }
}

@Composable
fun PengaturanItemWithIcon(
    title: String,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title, fontSize = 18.sp,
            style = TextStyle(
                color = Color(0xFF495555)
            )
        )
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color(0xFF495555),
            modifier = Modifier
                .padding(end = 8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PengaturanItemPreview() {
    PengaturanItemScreen( navController = rememberNavController())
}