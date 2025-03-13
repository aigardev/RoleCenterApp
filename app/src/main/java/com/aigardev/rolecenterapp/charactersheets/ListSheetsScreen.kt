package com.aigardev.rolecenterapp.charactersheets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aigardev.rolecenterapp.R
import com.aigardev.rolecenterapp.core.data.models.GyGSheet
import com.aigardev.rolecenterapp.core.ui.components.EmptyScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListSheetsScreen(
    viewModel: ListSheetsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold() {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (uiState) {
                is ListSheetsUiState.Loading -> {
                    LoadingScreen()
                }

                is ListSheetsUiState.Success -> {
                    val sheets = (uiState as ListSheetsUiState.Success).sheets
                    if (sheets.isEmpty()) {
                        EmptyScreen(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            text = stringResource(id = R.string.empty_list_sheets)
                        )
                    } else {
                        CharacterSheetList(sheets)
                    }
                }

                is ListSheetsUiState.Error -> {
                    ErrorScreen((uiState as ListSheetsUiState.Error).message)
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Error: $message", style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
    }
}

@Composable
fun CharacterSheetList(sheets: List<GyGSheet>) {
    LazyColumn {
        items(sheets) { sheet ->
            //CharacterSheetItem(sheet)
            GyGSheetItem(sheet)
        }
    }
}
/*
@Composable
fun CharacterSheetItem(sheet: CharacterSheet) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation =  CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = sheet.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = stringResource(R.string.game_system_text, sheet.gameSystem), style = MaterialTheme.typography.bodyMedium)
            Text(text = stringResource(R.string.class_race_level_text, sheet.characterClass, sheet.race, sheet.level), style = MaterialTheme.typography.bodyMedium)
            /*
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = stringResource(R.string.strength_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.strength.toString(), style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = stringResource(R.string.dexterity_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.dexterity.toString(), style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = stringResource(R.string.constitution_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.constitution.toString(), style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = stringResource(R.string.intelligence_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.intelligence.toString(), style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = stringResource(R.string.wisdom_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.wisdom.toString(), style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = stringResource(R.string.charisma_abbr), style = MaterialTheme.typography.bodySmall)
                    Text(text = sheet.charisma.toString(), style = MaterialTheme.typography.bodyLarge)
                }
            }*/
        }
    }
}*/

@Composable
fun GyGSheetItem(sheet: GyGSheet) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation =  CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = sheet.name, style = MaterialTheme.typography.titleLarge)
                }
                Column {
                    Text(text = stringResource(R.string.level, sheet.level.toString()), style = MaterialTheme.typography.titleLarge)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = stringResource(R.string.race, sheet.race), style = MaterialTheme.typography.bodyMedium)
                }
                Column {
                    Text(text = stringResource(R.string.profession, sheet.profession), style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = stringResource(R.string.game, sheet.game), style = MaterialTheme.typography.bodySmall)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    //Text(text = stringResource(R.string.party, sheet.party ?: ""), style = MaterialTheme.typography.bodySmall)
                    sheet.party?.let { party -> // 'party' dentro de este bloque es un String, no un String?
                        Text(
                            text = stringResource(R.string.party, party),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                }
            }
        }
    }
}

/*
@Preview
@Composable
fun CharacterSheetItemPreview() {
    CharacterSheetItem(
        CharacterSheet(
                id = "1",
                name = "LiquidJokey",
                gameSystem = "Goblins & Grutas",
                characterClass = "Mago",
                race = "Humano",
                level = 20,
                strength = 10,
                dexterity = 14,
                constitution = 18,
                intelligence = 22,
                wisdom = 20,
                charisma = 16
        )
    )
}*/

@Preview
@Composable
fun GyGSheetItemPreview() {
    GyGSheetItem(
        GyGSheet(
            id = 100,
            name = "Kvothe",
            profession = "Bardo",
            race = "Humano",
            level = 1,
            strength = 2,
            agility = 3,
            intelligence = 5,
            charisma = 6,
            lifePoints = 6,
            combat = 2,
            atk = 2,
            def = 2,
            knowledge = 5,
            larceny = 4,
            magic = 3,
            social = 6,
            game = "Goblins & Grutas",
        )
    )
}