package com.varsha.tourmate.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.infiniteapp.presentation.screen.login.LoginScreen
import com.varsha.tourmate.model.navigation.NavigationItem
import com.varsha.tourmate.model.navigation.Screen
import com.varsha.tourmate.view.ui.screen.beranda.BerandaScreen
import com.varsha.tourmate.view.ui.screen.jadwal.JadwalScreen
import com.varsha.tourmate.view.ui.screen.notifikasi.NotifikasiScreen
import com.varsha.tourmate.view.ui.screen.pengaturan.PengaturanScreen
import com.varsha.tourmate.view.ui.screen.profil.EditProfileScreen
import com.varsha.tourmate.view.ui.screen.profil.ProfilScreen

@Composable
fun TourMateApp(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomAppBar {
                if (currentRoute != null
                    && !currentRoute.contains(Screen.Login.route)
                ) {
                    BottomBar(navController = navController)
                }
                //BottomBar(navController)
            }
        }

    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login .route,
            modifier = Modifier
                .padding(contentPadding)
        ) {
            
            composable(Screen.Login.route){
                LoginScreen(navController = navController)
            }
            
            composable(Screen.Beranda.route) {
                BerandaScreen()
            }

            composable(Screen.Jadwal.route) {
                JadwalScreen()
            }

            composable(Screen.Profil.route) {
                ProfilScreen( navController = navController)
            }
            
            composable(Screen.EditProfil.route){
                EditProfileScreen(navController = navController)
            }

            composable(Screen.Notifikasi.route){
                NotifikasiScreen(navController = navController)
            }

            composable(Screen.Pengaturan.route){
                PengaturanScreen(navController = navController)
            }

        }

    }
}

@Composable
fun BottomBar(
    navController : NavHostController
) {
    NavigationBar(
        modifier = Modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Beranda",
                icon = Icons.Outlined.Home,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = "Jadwal",
                icon = Icons.Outlined.AccessTime,
                screen = Screen.Jadwal
            ),
            NavigationItem(
                title = "Profil",
                icon = Icons.Outlined.AccountCircle,
                screen = Screen.Profil
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                }
            )
        }

    }
}

@Preview
@Composable
private fun TourMateAppPreview() {
    TourMateApp()
}