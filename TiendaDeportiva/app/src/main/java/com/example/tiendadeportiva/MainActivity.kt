package com.example.tiendadeportiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiendadeportiva.ui.theme.TiendaDeportivaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaDeportivaTheme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "categorias") {
        composable("categorias") {
            PantallaCategorias(onVerProductos = { navController.navigate("productos") })
        }
        composable("productos") {
            PantallaProductos(onVolver = { navController.popBackStack() })
        }
    }
}