package com.aigardev.rolecenterapp.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState // Importa DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aigardev.rolecenterapp.R
import kotlinx.coroutines.launch // Importa launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    drawerState: DrawerState, // Estado del Drawer
    onLogoutClick: () -> Unit, // Callback para cerrar sesión
    onNavigateToDashboard: () -> Unit, // Callback para navegar
    onNavigateToCreateSheet: () -> Unit, // Callback para navegar
    onNavigateToListSheets: () -> Unit, // Callback para navegar
    onNavigateToCreateGame: () -> Unit, // Callback para navegar
    onNavigateToListGames: () -> Unit, // Callback para navegar
    onNavigateToProfile: () -> Unit, // Callback para navegar
    onNavigateToSettings: () -> Unit // Callback para navegar
) {
    val coroutineScope = rememberCoroutineScope()
    var showLogoutDialog by remember { mutableStateOf(false) } //Estado del AlertDialog

    ModalDrawerSheet { // Usamos ModalNavigationDrawer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("RoleCenterApp") // Título del Drawer (opcional) Se modificara por una imagen posiblemente
            Spacer(modifier = Modifier.height(16.dp))

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.home)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToDashboard() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = stringResource(id = R.string.home)) } // Icono
            )

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.create_sheet)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToCreateSheet()// Usar el callback
                },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(id = R.string.create_sheet)) } // Icono

            )

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.list_sheets)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToListSheets() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = stringResource(id = R.string.list_sheets)) } // Icono

            )

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.create_game)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToCreateGame() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(id = R.string.create_game)) } // Icono

            )

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.list_games)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToListGames() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = stringResource(id = R.string.list_games)) } // Icono

            )

            Spacer(modifier = Modifier.height(16.dp))

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.profile)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToProfile() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.Default.Person, contentDescription = stringResource(id = R.string.profile)) } // Icono
            )

            NavigationDrawerItem(
                label = { Text(stringResource(id = R.string.settings)) },
                selected = false,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    onNavigateToSettings() // Usar el callback
                },
                icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = stringResource(id = R.string.settings)) } // Icono
            )

            Spacer(modifier = Modifier.height(16.dp))

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