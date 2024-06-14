package com.varsha.tourmate.view.ui.screen.lokasi

import android.location.Geocoder
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import java.util.*

@Composable
fun PilihJarakLokasiScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState()
    var startLocation by remember { mutableStateOf(TextFieldValue("Lokasi Anda")) }
    var endLocation by remember { mutableStateOf(TextFieldValue("California, United States")) }
    var distance by remember { mutableStateOf(0) }
    var startMarkerPosition by remember { mutableStateOf<LatLng?>(null) }
    var endMarkerPosition by remember { mutableStateOf<LatLng?>(null) }
    var properties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
    var uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }
    var isStartLocationSet by remember { mutableStateOf(false) }

    LaunchedEffect(startMarkerPosition, endMarkerPosition) {
        if (startMarkerPosition != null && endMarkerPosition != null) {
            distance = calculateDistance(startMarkerPosition!!, endMarkerPosition!!)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            BasicTextField(
                value = startLocation,
                onValueChange = { startLocation = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.small)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
            BasicTextField(
                value = endLocation,
                onValueChange = { endLocation = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.small)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            Maps(
                onMapClick = { latLng ->
                    if (!isStartLocationSet) {
                        startMarkerPosition = latLng
                        isStartLocationSet = true
                        val startLocationAddress = geocodeLocation(context, latLng)
                        startLocation = if (startLocationAddress != null) TextFieldValue(startLocationAddress) else TextFieldValue("Unknown location")
                    } else {
                        endMarkerPosition = latLng
                        val endLocationAddress = geocodeLocation(context, latLng)
                        endLocation = if (endLocationAddress != null) TextFieldValue(endLocationAddress) else TextFieldValue("Unknown location")
                    }
                },
                startMarkerPosition = startMarkerPosition,
                endMarkerPosition = endMarkerPosition
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Distance: $distance km",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { /* Handle route calculation action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Route")
        }
    }
}

private fun calculateDistance(start: LatLng, end: LatLng): Int {
    val resultArray = FloatArray(1)
    android.location.Location.distanceBetween(
        start.latitude, start.longitude,
        end.latitude, end.longitude,
        resultArray
    )
    return (resultArray[0] / 1000).toInt() // Convert to kilometers
}

private fun geocodeLocation(context: android.content.Context, latLng: LatLng): String? {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
    return if (addresses != null && addresses.isNotEmpty()) {
        addresses[0]?.getAddressLine(0)
    } else {
        "Unknown location"
    }
}

@Composable
fun Maps(
    onMapClick: (LatLng) -> Unit,
    startMarkerPosition: LatLng? = null,
    endMarkerPosition: LatLng? = null,
    modifier: Modifier = Modifier
) {
    val cameraPositionState = rememberCameraPositionState()
    var properties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
    var uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

    Box(modifier = modifier.fillMaxSize()) {
        GoogleMap(
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
            onMapClick = onMapClick
        ) {
            startMarkerPosition?.let { position ->
                Marker(state = MarkerState(position = position), title = "Start Location")
            }
            endMarkerPosition?.let { position ->
                Marker(state = MarkerState(position = position), title = "End Location")
            }
        }
    }
}

@Preview
@Composable
private fun PilihJarakLokasiScreenPreview() {
    PilihJarakLokasiScreen()
}
