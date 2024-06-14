package com.varsha.tourmate.view.ui.screen.lokasi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Maps(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val cameraPositionState = rememberCameraPositionState {}
        var properties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
        var uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

        GoogleMap(
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings
        )
    }
}

@Preview
@Composable
private fun MapsPreview() {
    Maps()
}