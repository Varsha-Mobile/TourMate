package com.varsha.tourmate.view.ui.screen.lokasi

import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.varsha.tourmate.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

@Composable
fun PilihLokasi(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState()
    var locationLabel by remember { mutableStateOf(TextFieldValue()) }
    var markerPosition by remember { mutableStateOf<LatLng?>(null) }
    var properties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
    var uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

    LaunchedEffect(markerPosition) {
        markerPosition?.let {
            val address = getAddressFromLatLng(context, it)
            locationLabel = TextFieldValue(address)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            GoogleMap(
                cameraPositionState = cameraPositionState,
                properties = properties,
                uiSettings = uiSettings,
                onMapClick = { latLng ->
                    markerPosition = latLng
                }
            ) {
                markerPosition?.let { position ->
                    Marker(state = MarkerState(position = position))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.gmaps),
                    contentDescription = "Foto Gmaps",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(32.dp)
                )
            },
            value = locationLabel,
            onValueChange = { locationLabel = it },
            label = { Text("Label") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            trailingIcon = {
                IconButton(onClick = { /* Handle search action */ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        androidx.compose.material3.Button(
            onClick = { /* Handle confirm location action */ },
            colors = ButtonDefaults.buttonColors(Color(0xFF5B6242)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 80.dp)

        ) {
            Text(
                "Confirm Location",
                style = TextStyle(
                    color = Color.White
                )
            )
        }
    }
}

private suspend fun getAddressFromLatLng(context: Context, latLng: LatLng): String {
    return withContext(Dispatchers.IO) {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
        (if (addresses?.isNotEmpty() == true) {
            addresses[0]?.getAddressLine(0)
        } else {
            "Unknown location"
        }).toString()
    }
}

@Preview
@Composable
private fun PilihLokasiPreview() {
    PilihLokasi()
}
