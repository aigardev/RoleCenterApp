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
import com.aigardev.rolecenterapp.core.ui.components.ReusableComponents.DashboardButton

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Añade padding general a la pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Espacio entre los botones
    ) {
//        Text("Dashboard Principal", style = MaterialTheme.typography.headlineMedium) // Título del Dashboard
//        Spacer(modifier = Modifier.height(32.dp)) // Espacio vertical grande

        Row( //Organizamos con Rows y Columns, para simular el grid
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            DashboardButton(
                icon = Icons.Filled.Add,
                text = "Crear Ficha",
                onClick = { /* TODO: Navegar a Crear Ficha */ },
                modifier = Modifier.weight(1f)
            )
            DashboardButton(
                icon = Icons.AutoMirrored.Filled.List,
                text = "Listar Fichas",
                onClick = { /* TODO: Navegar a Listar Fichas */ },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio ENTRE filas

        Row( //Organizamos con Rows y Columns, para simular el grid
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            DashboardButton(
                icon = Icons.Filled.Add,
                text = "Crear Partida",
                onClick = { /* TODO: Navegar a Crear Partida */ },
                modifier = Modifier.weight(1f)
            )
            DashboardButton(
                icon = Icons.AutoMirrored.Filled.List,
                text = "Listar Partidas",
                onClick = { /* TODO: Navegar a Listar Partidas */ },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

//@Composable
//fun DashboardButton(
//    icon: ImageVector, // Para el icono del botón
//    text: String,      // Para el texto debajo del icono
//    onClick: () -> Unit // Para la acción cuando se pulse el botón
//) {
//    Button(onClick = onClick) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Icon(imageVector = icon, contentDescription = text) // Icono arriba
//            Text(text = text) // Texto debajo del icono
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen() // Vista previa de DashboardScreen
}
