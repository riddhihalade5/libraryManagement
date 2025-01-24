package com.example.domain.entities
import kotlinx.serialization.Serializable

@Serializable
data class BookDom (
    val id: Int,
    val title: String,
    val author: String,
    val genre: Genre,
    val publishYear: Long
)