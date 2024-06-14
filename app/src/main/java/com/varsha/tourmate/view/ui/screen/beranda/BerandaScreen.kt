package com.varsha.tourmate.view.ui.screen.beranda

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BerandaScreen(modifier: Modifier = Modifier) {
    Text(text = "INI BERANDA")
}

@Preview
@Composable
private fun BerandaScreenPreview() {
    BerandaScreen()
}