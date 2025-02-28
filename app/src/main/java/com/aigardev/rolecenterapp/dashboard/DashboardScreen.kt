package com.aigardev.rolecenterapp.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa el espacio disponible
            .padding(16.dp), // Añade un padding general
        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los elementos
        verticalArrangement = Arrangement.Center // Centra verticalmente los elementos
    ) {
        Text("Dashboard Principal", style = MaterialTheme.typography.headlineMedium) // Título del Dashboard
        Spacer(modifier = Modifier.height(32.dp)) // Espacio vertical grande
        /*
        Button(onClick = { /* TODO: Navegar a Crear Ficha */ }, modifier = Modifier.fillMaxWidth()) { // Botón "Crear Ficha"
            Text("Crear Ficha")
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio vertical

        Button(onClick = { /* TODO: Navegar a Listar Fichas */ }, modifier = Modifier.fillMaxWidth()) { // Botón "Listar Fichas"
            Text("Listar Fichas")
        }
        Spacer(modifier = Modifier.height(16.dp)) // Espacio vertical

        Button(onClick = { /* TODO: Navegar a Crear Partida */ }, modifier = Modifier.fillMaxWidth()) { // Botón "Crear Partida"
            Text("Crear Partida")
        }
        Spacer(modifier = Modifier.height(16.dp)) // Espacio vertical

        Button(onClick = { /* TODO: Navegar a Listar Partidas */ }, modifier = Modifier.fillMaxWidth()) { // Botón "Listar Partidas"
            Text("Listar Partidas")
        }
        */
        DashboardButton(
            icon = Icons.Filled.Add,
            text = "Crear Ficha",
            onClick = { /* TODO: Navegar a Crear Ficha */ }
        )
        DashboardButton(
            icon = Icons.AutoMirrored.Filled.List,
            text = "Listar Fichas",
            onClick = { /* TODO: Navegar a Listar Fichas */ }
        )
        DashboardButton(
            icon = Icons.Filled.Add,
            text = "Crear Partida",
            onClick = { /* TODO: Navegar a Crear Partida */ }
        )
        DashboardButton(
            icon = Icons.AutoMirrored.Filled.List,
            text = "Listar Partidas",
            onClick = { /* TODO: Navegar a Listar Partidas */ }
        )
    }
}

@Composable
fun DashboardButton(
    icon: ImageVector, // Para el icono del botón
    text: String,      // Para el texto debajo del icono
    onClick: () -> Unit // Para la acción cuando se pulse el botón
) {
    Button(onClick = onClick) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = icon, contentDescription = text) // Icono arriba
            Text(text = text) // Texto debajo del icono
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen() // Vista previa de DashboardScreen
}
