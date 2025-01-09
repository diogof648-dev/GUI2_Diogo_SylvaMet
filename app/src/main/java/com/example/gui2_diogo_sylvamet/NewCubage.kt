package com.example.gui2_diogo_sylvamet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gui2_diogo_sylvamet.components.TopBar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NewCubage (
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

            Spacer(
                Modifier.height(10.dp)
            )

            Column(
                Modifier.align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row {
                    Column {
                        var text by remember { mutableStateOf("") }

                        Text(
                            text = "Date de cubage *"
                        )

                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = { Text("MM/DD/YYYY") },
                            modifier = Modifier.width(190.dp),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.LightGray,
                                focusedContainerColor = Color.White
                            ),
                            shape = RoundedCornerShape(5.dp)
                        )
                    }

                    Spacer(
                        Modifier.width(10.dp)
                    )

                    Column {
                        var text by remember { mutableStateOf("") }

                        Text(
                            text = "Numéro *"
                        )

                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = { Text("288432") },
                            modifier = Modifier.width(190.dp),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.LightGray,
                                focusedContainerColor = Color.White
                            ),
                            shape = RoundedCornerShape(5.dp)
                        )
                    }
                }

                Column {
                    var text by remember { mutableStateOf("") }

                    Text(
                        text = "Coupe *"
                    )
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text("Erddg23") },
                        modifier = Modifier.width(390.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.LightGray,
                            focusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
                }

                Column {
                    var text by remember { mutableStateOf("") }

                    Text(
                        text = "Description *"
                    )
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text("Description...") },
                        modifier = Modifier.width(390.dp).height(200.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.LightGray,
                            focusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
                }

                Row {
                    var buttonsState by remember { mutableStateOf(arrayOf(1, 1)) }

                    Column {
                        val buttonColor = if (buttonsState[0].toString() == "1") ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        else ButtonDefaults.buttonColors(containerColor = Color.White)
                        Button(
                            onClick = {
                                buttonsState = arrayOf(1, 1)
                            },
                            colors = buttonColor,
                            border = BorderStroke(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.width(190.dp)
                        ) {
                            val textColor = if (buttonsState[0].toString() == "1") Color.White
                            else MaterialTheme.colorScheme.primary
                            Text(
                                text = "SUR ÉCORCE",
                                color = textColor
                            )
                        }
                    }

                    Spacer(
                        Modifier.width(10.dp)
                    )

                    Column {
                        val buttonColor = if (buttonsState[0].toString() == "2") ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        else ButtonDefaults.buttonColors(containerColor = Color.White)
                        Button(
                            onClick = {
                                buttonsState = arrayOf(2, 1)
                            },
                            colors = buttonColor,
                            border = BorderStroke(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.width(190.dp)
                        ) {
                            val textColor = if (buttonsState[0].toString() == "2") Color.White
                            else MaterialTheme.colorScheme.primary
                            Text(
                                text = "ÉCORCÉE",
                                color = textColor
                            )
                        }
                    }
                }

                Row {
                    Button(
                        onClick = { },
                        modifier = Modifier.width(390.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(100, 200, 100))
                    ) {
                        Text(
                            text = "Ajouter",
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 10.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}