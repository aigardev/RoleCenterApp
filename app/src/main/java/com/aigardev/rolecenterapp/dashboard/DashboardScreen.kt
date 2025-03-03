package com.aigardev.rolecenterapp.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.aigardev.rolecenterapp.core.ui.components.AppBarWithMenu
import com.aigardev.rolecenterapp.core.ui.components.ReusableComponents.DashboardButton
import com.aigardev.rolecenterapp.R
import com.aigardev.rolecenterapp.core.navigation.Screen
import com.aigardev.rolecenterapp.core.ui.components.AppDrawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed) // Estado del Drawer

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                drawerState = drawerState,
                onLogoutClick = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                            inclusive = true
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                }
            )
        },
        gesturesEnabled = drawerState.isOpen // Desactivar gestos cuando está cerrado

    ) {
        Scaffold(
            topBar = {
                AppBarWithMenu(
                    title = stringResource(id = R.string.app_name),
                    drawerState = drawerState, // Pasa el DrawerState
                    showMenuIcon = true
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DashboardButton(
                        icon = Icons.Filled.Add,
                        text = "Crear Ficha",
                        onClick = { navController.navigate(Screen.CreateSheet.route) },
                        modifier = Modifier.weight(1f)
                    )
                    DashboardButton(
                        icon = Icons.AutoMirrored.Filled.List,
                        text = "Listar Fichas",
                        onClick = { navController.navigate(Screen.ListSheets.route) },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DashboardButton(
                        icon = Icons.Filled.Add,
                        text = "Crear Partida",
                        onClick = { navController.navigate(Screen.CreateGame.route) },
                        modifier = Modifier.weight(1f)
                    )
                    DashboardButton(
                        icon = Icons.AutoMirrored.Filled.List,
                        text = "Listar Partidas",
                        onClick = { navController.navigate(Screen.ListGames.route) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(
        navController = TODO()
    ) // Vista previa de DashboardScreen
}
