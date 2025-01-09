package com.example.gui2_diogo_sylvamet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gui2_diogo_sylvamet.components.TopBar

@Composable
fun InfoMartelage (
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

            Spacer(Modifier.height(10.dp))

            var choice by remember { mutableStateOf(0) }

            Column (
                Modifier.width(390.dp).align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "RESINEUX",
                    fontWeight = FontWeight(700)
                )

                Row {
                    Button(
                        onClick = { choice = 1 },
                        modifier = Modifier.width(120.dp),
                        colors = if (choice == 1) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) else
                                    ButtonDefaults.buttonColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Épicéa\n247.8",
                            color = if (choice == 1) Color.White else
                                    Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            Column (
                Modifier.width(390.dp).align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "FEUILLUS",
                    fontWeight = FontWeight(700)
                )

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { choice = 2 },
                        modifier = Modifier.width(120.dp),
                        colors = if (choice == 2) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) else
                                    ButtonDefaults.buttonColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Hêtre\n0.3",
                            color = if (choice == 2) Color.White else
                                    Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Button(
                        onClick = { choice = 3 },
                        modifier = Modifier.width(120.dp),
                        colors = if (choice == 3) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) else
                                    ButtonDefaults.buttonColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Cerisier\n1.4",
                            color = if (choice == 3) Color.White else
                                    Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Button(
                        onClick = { choice = 4 },
                        modifier = Modifier.width(120.dp),
                        colors = if (choice == 4) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) else
                                    ButtonDefaults.buttonColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Bouleau\n1.9",
                            color = if (choice == 4) Color.White else
                                    Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            Column (
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {  }
                ) {
                    Text(
                        "TOTAL     251.4",
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }

            if (choice != 0) {
                Spacer(Modifier.height(30.dp))
                HorizontalDivider(
                    modifier = Modifier.width(290.dp).align(Alignment.CenterHorizontally),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                Spacer(Modifier.height(30.dp))

                Column (
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Row (
                        Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            Icons.Rounded.Info,
                            "Info",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(Modifier.width(10.dp))
                        Text("INFOS DU MARTELAGE", color = MaterialTheme.colorScheme.primary)
                    }

                    var martelage by remember { mutableStateOf(0) }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        for (i in 1..3) {
                            Button (
                                onClick = { martelage = i },
                                colors = if (martelage != i) ButtonDefaults.buttonColors(containerColor = Color.White)
                                else ButtonDefaults.buttonColors(containerColor = Color.Red),
                                border = if (martelage != i) BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                                else BorderStroke(2.dp, Color.Red),
                                modifier = Modifier.width(120.dp).height(80.dp)
                            ) {
                                if (martelage != i) {
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(i.toString(),
                                            fontWeight = FontWeight(700),
                                            color = Color.Black,
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp
                                        )
                                        Text(
                                            text = "34",
                                            style = TextStyle(background = MaterialTheme.colorScheme.primary),
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp
                                        )
                                    }
                                } else {
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            Icons.Rounded.Delete,
                                            "delete",
                                            tint = Color.White
                                        )
                                        Text(
                                            "Supprimer?",
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        for (i in 4..6) {
                            Button (
                                onClick = { martelage = i },
                                colors = if (martelage != i) ButtonDefaults.buttonColors(containerColor = Color.White)
                                else ButtonDefaults.buttonColors(containerColor = Color.Red),
                                border = if (martelage != i) BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                                else BorderStroke(2.dp, Color.Red),
                                modifier = Modifier.width(120.dp).height(80.dp)
                            ) {
                                if (martelage != i) {
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(i.toString(),
                                            fontWeight = FontWeight(700),
                                            color = Color.Black,
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp
                                        )
                                        Text(
                                            text = "34",
                                            style = TextStyle(background = MaterialTheme.colorScheme.primary),
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp
                                        )
                                    }
                                } else {
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            Icons.Rounded.Delete,
                                            "delete",
                                            tint = Color.White
                                        )
                                        Text(
                                            "Supprimer?",
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}