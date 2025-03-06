package com.aigardev.rolecenterapp.core.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


object ReusableComponents {
    @Composable
    fun DashboardButton(
        icon: ImageVector,
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        buttonColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.aspectRatio(1f), // AHORA aspectRatio se aplica aquí, al Button
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = contentColor
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp, pressedElevation = 16.dp),
            contentPadding = PaddingValues(0.dp) // Importante para el control preciso del tamaño interno

        ) {
            Box( // Usamos un Box para controlar el layout interno
                modifier = Modifier.fillMaxSize(), // El Box ocupa todo el espacio del botón
                contentAlignment = Alignment.Center // Centramos el contenido del Box
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = text,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}