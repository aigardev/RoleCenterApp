package com.aigardev.rolecenterapp.charactersheets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aigardev.rolecenterapp.core.data.models.GyGSheet
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListSheetsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<ListSheetsUiState>(ListSheetsUiState.Loading)
    val uiState: StateFlow<ListSheetsUiState> = _uiState.asStateFlow()

    init {
        // Simulación de carga de datos (reemplaza con tu lógica real)
        viewModelScope.launch {
            delay(1000) // Simula una carga de 2 segundos
            // _uiState.value = ListSheetsUiState.Success(emptyList()) // Inicialmente, la lista está vacía
            _uiState.value = ListSheetsUiState.Success( // Lista de prueba
                listOf(
                    /*
                    CharacterSheet(
                        id = "1",
                        name = "Gandalf",
                        gameSystem = "D&D 5e",
                        characterClass = "Wizard",
                        race = "Maia",
                        level = 20,
                        strength = 10,
                        dexterity = 14,
                        constitution = 18,
                        intelligence = 22,
                        wisdom = 20,
                        charisma = 16
                    ),*/
                    /*
                    CharacterSheet(
                        id = "2",
                        name = "Aragorn",
                        gameSystem = "D&D 5e",
                        characterClass = "Ranger",
                        race = "Dúnedain",
                        level = 18,
                        strength = 18,
                        dexterity = 16,
                        constitution = 20,
                        intelligence = 14,
                        wisdom = 16,
                        charisma = 18
                    ),*/
                    GyGSheet(
                        id = 100,
                        name = "Kvothe 1",
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
                    ),
                    GyGSheet(
                        id = 100,
                        name = "Kvothe 2",
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
                        party = "La Senda Olvidada"
                    ),
                    GyGSheet(
                        id = 100,
                        name = "Kvothe 3",
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
                        party = "El Pacto de los Dioses"
                    ),
                    GyGSheet(
                        id = 100,
                        name = "Kvothe 4",
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
            )
        }
    }
}