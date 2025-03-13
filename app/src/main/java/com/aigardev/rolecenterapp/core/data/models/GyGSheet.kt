package com.aigardev.rolecenterapp.core.data.models

data class GyGSheet(
    val id: Int,
    val name: String,
    val profession: String,
    val race: String,
    var level: Int? = null,
    var strength: Int,
    var agility: Int,
    var intelligence: Int,
    var charisma: Int,
    var lifePoints: Int,
    var combat: Int,
    var atk: Int,
    var def: Int,
    var knowledge: Int,
    var larceny: Int,
    var magic: Int,
    var social: Int,
    var inventory: String? = null,
    var notes: String?  = null,
    val game: String = "Goblins & Grutas",
    val party: String? = null
)