package com.example.gui2_diogo_sylvamet

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.example.gui2_diogo_sylvamet.components.CubageItem
import com.example.gui2_diogo_sylvamet.components.FilterItem
import com.example.gui2_diogo_sylvamet.components.Search
import com.example.gui2_diogo_sylvamet.components.TopBar

@Composable
fun Cubages (
    title: String,
    page: String,
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    var isSearching by remember { mutableStateOf(false) }
    val cubages = arrayOf(
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(2, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(2, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
        arrayOf(1, "ERDDG244", 9999, "12/03/2024"),
    )
    var itemFilter by remember { mutableStateOf(arrayOf(-1, 1)) }
    var filters = arrayOf(
        arrayOf(1, "Nom"),
        arrayOf(2, "Date"),
        arrayOf(3, "Numéro"),
        arrayOf(4, "Type")
    )

    Box (
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column {
            TopBar(
                title,
                page,
                search = {
                    isSearching = true
                },
                navController
            )

            Box(
                Modifier.fillMaxWidth()
            ) {
                Row (
                    Modifier
                        .horizontalScroll(rememberScrollState())
                        .height(IntrinsicSize.Min)
                        .padding(vertical = 5.dp)
                ) {
                    Spacer(Modifier.padding(start = 5.dp))
                    Button (
                        onClick = {
                            itemFilter = arrayOf(-1, 1)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(IntrinsicSize.Min)
                        ) {
                            Text(
                                "X",
                                modifier = Modifier.padding(vertical = 5.dp),
                                color = Color.White
                            )
                        }

                    }

                    Spacer(Modifier.padding(end = 5.dp))
                    VerticalDivider(modifier = Modifier.fillMaxHeight(), thickness = 1.dp, color = Color.Black.copy(0.3f))
                    Spacer(Modifier.padding(start = 5.dp))

                    for (filter in filters) {
                        FilterItem(
                            filter[0].toString().toInt(),
                            filter[1].toString(),
                            {
                                itemFilter = if (itemFilter[1] == 1)
                                    arrayOf(filter[0].toString().toInt(), 2)
                                else
                                    arrayOf(filter[0].toString().toInt(), 1)
                            },
                            itemFilter
                        )
                        Spacer(Modifier.padding(end = 5.dp))
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)

            Box(
                modifier = Modifier.padding(5.dp)
            ) {
                Column (
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    cubages.forEach {
                        CubageItem(
                            it[0].toString().toInt(),
                            it[1].toString(),
                            it[2].toString().toInt(),
                            it[3].toString()
                        )
                        Spacer(
                            Modifier.padding(bottom = 5.dp)
                        )
                    }
                }
            }
        }
    }

    if (isSearching) {
        Search(
            quitSearch = {
                isSearching = false
            }
        )
    }
}