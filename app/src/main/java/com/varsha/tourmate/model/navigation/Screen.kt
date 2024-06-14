package com.varsha.tourmate.model.navigation

sealed class Screen ( val route: String) {

    // MENU UTAMA
    data object Beranda : Screen("beranda")
    data object Jadwal : Screen("jadwal")
    data object Profil : Screen("profil")

    // SUB MENU

    // AUTENTIKASI

    //TambahJadwal
    data object TambahJadwal : Screen("tambah_jadwal")
}