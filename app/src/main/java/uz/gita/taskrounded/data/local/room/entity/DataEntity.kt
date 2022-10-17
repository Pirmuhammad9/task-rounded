package uz.gita.taskrounded.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val status: String,
    val origin: String,
    val image: String,
    val current: Int,
    val prev: Int?,
    val next: Int?
)