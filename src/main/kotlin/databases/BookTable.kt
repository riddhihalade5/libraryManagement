package com.example.databases

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.dao.id.EntityID
import com.example.domain.entities.Genre
import org.jetbrains.exposed.dao.id.IdTable


object BookTable : IdTable<Int>("books"){

    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId()

    val title = varchar("title", 255)
    val author = varchar("author", 255)
    val publishYear = long("publish_year")
    val genre = enumerationByName("genre", 50, Genre::class)
    override val primaryKey = PrimaryKey(id)


}

