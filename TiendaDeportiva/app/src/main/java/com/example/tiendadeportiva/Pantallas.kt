package com.example.tiendadeportiva

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tiendadeportiva.model.Categoria
import com.example.tiendadeportiva.model.Producto

// ---------- Datos de ejemplo ----------

val categoriaFutbol = Categoria(1, "Fútbol", "Balones, botines y camisetas")
val categoriaRunning = Categoria(2, "Running", "Zapatillas y ropa para correr")
val categoriaCiclismo = Categoria(3, "Ciclismo", "Cascos, bicicletas y accesorios")

val listaCategorias = listOf(categoriaFutbol, categoriaRunning, categoriaCiclismo)

val listaProductos = listOf(
    Producto(1, "Balón Pro", "Nike", 45.0, 12, categoriaFutbol),
    Producto(2, "Zapatillas Run X", "Adidas", 89.9, 8, categoriaRunning),
    Producto(3, "Casco Ciclista", "Giro", 60.0, 5, categoriaCiclismo)
)

// ---------- Pantalla 1: Categorías ----------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCategorias(onVerProductos: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Categorías") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(listaCategorias) { categoria ->
                    CategoriaCard(categoria)
                }
            }
            Button(
                onClick = onVerProductos,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Text("Ver productos")
            }
        }
    }
}

@Composable
fun CategoriaCard(categoria: Categoria) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = categoria.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = categoria.descripcion)
        }
    }
}

// ---------- Pantalla 2: Productos ----------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaProductos(onVolver: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productos") },
                navigationIcon = {
                    IconButton(onClick = onVolver) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaProductos) { producto ->
                ProductoCard(producto)
            }
        }
    }
}

@Composable
fun ProductoCard(producto: Producto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Marca: ${producto.marca}")
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Precio: ${producto.precio}")
                Text(text = "Stock: ${producto.stock}")
            }
        }
    }
}