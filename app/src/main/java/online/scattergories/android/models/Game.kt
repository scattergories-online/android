package online.scattergories.android.models

data class Game(val id: String)

data class PartialGame(
    val id: String,
    val language: String,
    val categories: List<PartialCategory>,
    val currentMembers: Int,
    val maxMembers: Int,
    val createdBy: PartialUser,
)