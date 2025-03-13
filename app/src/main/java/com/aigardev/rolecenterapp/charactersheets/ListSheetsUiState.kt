package com.aigardev.rolecenterapp.charactersheets

import com.aigardev.rolecenterapp.core.data.models.GyGSheet

// Define los estados de la UI
sealed class ListSheetsUiState {
    object Loading : ListSheetsUiState()
    data class Success(val sheets: List<GyGSheet>) : ListSheetsUiState()
    data class Error(val message: String) : ListSheetsUiState()
}