package com.example.gui2_diogo_sylvamet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Search(
    quitSearch: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    var text by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f))
            .clickable { quitSearch() }
            .padding(0.dp, 80.dp, 0.dp, 0.dp),
        Alignment.TopCenter
    ) {
        OutlinedTextField(
            value = text,
            placeholder = {
                Text(
                    "Rechercher..."
                )
            },
            onValueChange = { text = it },
            modifier = Modifier
                .background(Color.White)
                .focusRequester(focusRequester)
        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}
