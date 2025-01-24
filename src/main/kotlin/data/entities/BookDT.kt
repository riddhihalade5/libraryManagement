package com.example.data.entities
import com.example.domain.entities.Genre
import kotlinx.serialization.Serializable

@Serializable
data class BookDT(

    val id: Int,
    val title: String,
    val author: String,
    val genre: Genre,
    val publishYear: Long

)
