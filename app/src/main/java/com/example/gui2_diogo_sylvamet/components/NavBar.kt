package com.example.gui2_diogo_sylvamet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NavBar(
    navController: NavController
) {
    BottomAppBar (
        containerColor = MaterialTheme.colorScheme.secondary,
    ) {
        Row (
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                onClick = {
                    navController.navigate("home")
                }
            ) {
                Icon(Icons.Rounded.Home, "Home", Modifier.size(32.dp))
            }

            IconButton(
                onClick = {
                    navController.navigate("cubages")
                }
            ) {
                Icon(Icons.Rounded.Place, "Cubages", Modifier.size(32.dp))
            }

            IconButton(
                onClick = {
                    navController.navigate("infoMartelage")
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.List, "Info Martelage", Modifier.size(32.dp))
            }
        }
    }
}