package com.example.gui2_diogo_sylvamet

import android.annotation.SuppressLint
import android.icu.text.IDNA.Info
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gui2_diogo_sylvamet.components.NavBar
import com.example.gui2_diogo_sylvamet.ui.theme.GUI2_Diogo_SylvaMetTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GUI2_Diogo_SylvaMetTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { NavBar(navController) },
                    floatingActionButton = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()

                        if (navBackStackEntry?.destination?.route == "cubages") {
                            FloatingActionButton (
                                onClick = {
                                    navController.navigate("addCubage")
                                },
                                containerColor = MaterialTheme.colorScheme.primary
                            ) {
                                Text(
                                    text = "+",
                                    color = Color.White,
                                    fontSize = 22.sp
                                )
                            }
                        } else if (navBackStackEntry?.destination?.route == "infoMartelage") {
                            Column (
                                horizontalAlignment = Alignment.End
                            ) {
                                var expanded by remember { mutableStateOf(false) }

                                if (expanded) {
                                    FloatingActionButton(
                                        onClick = { },
                                        containerColor = Color.Red
                                    ) {
                                        Icon(Icons.Rounded.Delete, "delete", tint = Color.White)
                                    }

                                    Spacer(Modifier.height(10.dp))

                                    FloatingActionButton(
                                        onClick = { },
                                        containerColor = MaterialTheme.colorScheme.secondary
                                    ) {
                                        Icon(Icons.Rounded.Edit, "edit", tint = Color.White)
                                    }

                                    Spacer(Modifier.height(10.dp))
                                }

                                FloatingActionButton (
                                    onClick = {
                                        expanded = !expanded
                                    },
                                    containerColor = MaterialTheme.colorScheme.primary
                                ) {
                                    if (expanded) {
                                        Icon(Icons.Rounded.Close, "settings", tint = Color.White)
                                    } else {
                                        Icon(Icons.Rounded.Settings, "settings", tint = Color.White)
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "cubages") {
                        composable("cubages") { Cubages("Cubages", "cubages", navController, innerPadding) }
                        composable("home") { Home("Accueil", "home", navController) }
                        composable("addCubage") { NewCubage("Nouveau cubage", "newCubage", navController) }
                        composable("infoMartelage") { InfoMartelage("Martelage 2365f-8213j-as3123", "infoMartelage", navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}