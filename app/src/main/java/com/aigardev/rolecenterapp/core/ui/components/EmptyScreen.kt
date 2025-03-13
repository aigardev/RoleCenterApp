package com.aigardev.rolecenterapp.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.aigardev.rolecenterapp.R

@Composable
fun EmptyScreen(
    imageVector: ImageVector? = null, // Icono (ImageVector) - Opcional
    imageDrawable: Int? = null, // Icono (Drawable Resource ID) - Opcional
    text: String, // Texto descriptivo
    modifier: Modifier = Modifier, // Modificador para personalizar desde fuera
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imageVector != null) {
            Image(
                imageVector = imageVector,
                contentDescription = null, // El contentDescription se establece en el texto
                modifier = Modifier.size(120.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
        } else if (imageDrawable != null) {
            Image(
                painter = painterResource(id = imageDrawable),
                contentDescription = null, // El contentDescription se establece en el texto
                modifier = Modifier.size(120.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary) // Aplica un filtro de color
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge, // Usa la tipografía del tema
            textAlign = TextAlign.Center, // Centra el texto
            modifier = Modifier.padding(horizontal = 32.dp) // Añade padding horizontal
        )
    }
}

// Vista previa para ver cómo se ve
@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    MaterialTheme {
        EmptyScreen(
            imageVector = Icons.Default.List, // Icono de ejemplo
            text = stringResource(id = R.string.empty_screen_text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreviewDrawable() {
    MaterialTheme {
        EmptyScreen(
            imageDrawable = R.drawable.ic_launcher_foreground, // Drawable de ejemplo
            text = stringResource(id = R.string.empty_screen_text)
        )
    }
}