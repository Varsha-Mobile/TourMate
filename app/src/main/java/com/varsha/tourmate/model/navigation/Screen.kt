package com.varsha.tourmate.model.navigation

sealed class Screen ( val route: String) {

    // MENU UTAMA
    data object Beranda : Screen("beranda")
    data object Jadwal : Screen("jadwal")
    data object Profil : Screen("profil")

    // SUB MENU

    // AUTENTIKASI
    //login
    data object Login : Screen("login")


    //edit profil
    data object EditProfil : Screen("edit_profil")

    //notifikasi
    data object Notifikasi : Screen("notifikasi")

    //settingss
    data object Pengaturan : Screen("screen")
}