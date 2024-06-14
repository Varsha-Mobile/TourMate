package com.varsha.tourmate.view.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BackIconItem(
    onBackClicked: () -> Unit, // Add this parameter for the click action
    modifier: Modifier = Modifier
) {
        IconButton(
            onClick = onBackClicked,
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF3D4949)
            )
        }
}

@Preview
@Composable
private fun BackIconItemPrefiew() {
    BackIconItem(onBackClicked={})
}

@Composable
fun ButtonItem1(
    //navController: NavController,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp, color = Color(0xFF3D4949), shape = RoundedCornerShape(50)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            //backgroundColor = Color(0xFFE57373),
            contentColor = Color(0xFF3D4949)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            //modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview()
@Composable
fun ButtonItemScreen() {
    // val navController = rememberNavController()
    ButtonItem1(
        text = "Cancel",
        onClick = {}
    )
}

@Composable
fun ButtonItem2(
    //navController: NavController,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp, color = Color(0xFF3D4949), shape = RoundedCornerShape(50)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3D4949),
            //backgroundColor = Color(0xFFE57373),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview()
@Composable
fun ButtonItem2Screen() {
    // val navController = rememberNavController()
    ButtonItem2(
        text = "Save",
        onClick = {},
    )
}
