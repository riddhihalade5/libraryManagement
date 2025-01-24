package com.example.api.entities

import com.example.domain.entities.Genre
import kotlinx.serialization.Serializable

@Serializable
data class BookApi(

    val id: Int,
    val title: String,
    val author: String,
    val genre: Genre,
    val publishYear: Long

)


