package com.aigardev.rolecenterapp.core.data.models

data class CharacterSheet(
    val id: String, // Un identificador único (podría ser un UUID)
    val name: String,
    val gameSystem: String, // Nombre del sistema de juego (ej. "D&D 5e")
    val characterClass: String, // Clase del personaje
    val race: String, // Raza
    val level: Int,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
    // Agrega más campos según lo necesites (trasfondo, habilidades, equipo, etc.)
)