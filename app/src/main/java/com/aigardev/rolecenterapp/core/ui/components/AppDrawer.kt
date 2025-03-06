package com.aigardev.rolecenterapp.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState // Importa DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet // Importa ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem // Importa NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope // Importa rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aigardev.rolecenterapp.R
import kotlinx.coroutines.launch // Importa launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    drawerState: DrawerState, // Estado del Drawer
    onLogoutClick: () -> Unit, // Callback para cerrar sesión
) {
    val coroutineScope = rememberCoroutineScope()
    var showLogoutDialog by remember { mutableStateOf(false) } //Estado del AlertDialog

    ModalDrawerSheet { // Usamos ModalNavigationDrawer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("RoleCenterApp") // Título del Drawer (opcional)
            Spacer(modifier = Modifier.height(16.dp))

            // Agrega más NavigationDrawerItems para otras opciones del menú

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.logout)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    showLogoutDialog = true // Mostrar diálogo
                }
            )
            // Agrega más NavigationDrawerItems para otras opciones del menú
        }
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text(stringResource(id = R.string.logout_dialog_title)) },
            text = { Text(stringResource(id = R.string.logout_dialog_message)) },
            confirmButton = {
                TextButton(onClick = {
                    showLogoutDialog = false
                    onLogoutClick() // Llamar a onLogoutClick
                }) {
                    Text(stringResource(id = R.string.logout))
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text(stringResource(id = R.string.cancel))
                }
            }
        )
    }
}