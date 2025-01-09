package com.example.gui2_diogo_sylvamet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gui2_diogo_sylvamet.components.Search
import com.example.gui2_diogo_sylvamet.components.TopBar

@Composable
fun Home (
    title: String,
    page: String,
    navController: NavHostController
) {
    Box (
        Modifier.fillMaxSize()
    ) {
        Column {
            TopBar(
                title,
                page,
                search = { },
                navController = navController
            );
        }
    }
}