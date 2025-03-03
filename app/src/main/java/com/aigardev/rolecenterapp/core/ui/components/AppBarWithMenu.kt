package com.aigardev.rolecenterapp.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aigardev.rolecenterapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarWithMenu(
    title: String,
    drawerState: DrawerState, // Recibe el DrawerState
    modifier: Modifier = Modifier,
    showMenuIcon: Boolean = true,
) {
    val coroutineScope = rememberCoroutineScope() // Necesario para abrir el Drawer

    TopAppBar(
        title = { Text(title) },
        modifier = modifier,
        navigationIcon = {
            if (showMenuIcon) {
                IconButton(onClick = {
                    coroutineScope.launch { // Usamos una corrutina para abrir el drawer
                        drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}

@Preview
@Composable
fun AppBarWithMenuPreview() {
    MaterialTheme {
        AppBarWithMenu(
            title = "Mi App",
            drawerState = rememberDrawerState(DrawerValue.Closed),
            showMenuIcon = true
        )
    }
}