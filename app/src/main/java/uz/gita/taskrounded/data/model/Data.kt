package uz.gita.taskrounded.data.model

data class Data(
    val id: Int,
    val name: String,
    val status: String,
    val origin: Origin,
    val image: String,
)