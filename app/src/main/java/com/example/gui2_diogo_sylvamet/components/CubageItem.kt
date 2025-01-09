package com.example.gui2_diogo_sylvamet.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.gui2_diogo_sylvamet.R

@Composable
fun CubageItem (
    type: Int,
    name: String,
    number: Int,
    date: String,
    accesInfo: () -> Unit
) {
    val image = if (type == 1) painterResource(R.drawable.type_1) else painterResource(R.drawable.type_2)

    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(15.dp))
            .clickable { accesInfo() }
    ) {
        Row (
            modifier = Modifier
                .padding(10.dp, 15.dp)
                .height(50.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "Type image",
                modifier = Modifier
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 15.dp)
            ) {
                Text(
                    name,
                    fontWeight = FontWeight(700)
                )
                Text(
                    "N° $number",
                    fontSize = 3.em
                )
            }

            Column (
                modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    date,
                    fontSize = 3.5.em
                )
            }
        }
    }
}

@Preview
@Composable
fun CubageItemPreview() {
    CubageItem(1, "Blabla", 123, "12.03.2024", { })
}