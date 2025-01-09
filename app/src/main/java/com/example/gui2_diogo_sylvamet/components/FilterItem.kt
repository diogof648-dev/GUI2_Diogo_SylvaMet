package com.example.gui2_diogo_sylvamet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun FilterItem (
    id: Int,
    name: String,
    itemChange: () -> Unit,
    itemStatus: Array<Int>
) {

    val buttonColor = if (itemStatus[0] == id) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)

    Button (
        onClick = itemChange,
        colors = buttonColor,
        modifier = Modifier.clip(RoundedCornerShape(20.dp))
    ) {
        var type =
            if (itemStatus[0] == id && itemStatus[1] == 1) "↑"
            else if (itemStatus[0] == id && itemStatus[1] == 2) "↓"
            else ""

        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (type != "") {
                Text(
                    type,
                    fontSize = 5.em
                )
            }

            Text(
                name,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                color = Color.White
            )
        }

    }
}

@Preview
@Composable
fun PreviewFilterItem () {
    var itemFilter by remember { mutableStateOf(arrayOf(1, 1)) }
    FilterItem(1,"Test", {}, itemFilter)
}