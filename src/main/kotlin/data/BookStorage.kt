package com.example.data

import com.example.data.entities.BookDT
import com.example.databases.BookTable
import com.example.di.LettuceRedisClient
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class BookStorage
@Inject
constructor(){

    suspend fun invokeDT() :  List<BookDT>{
        return transaction {
            BookTable.selectAll().map {
                BookDT(
                    id = it[BookTable.id].value,
                    title = it[BookTable.title],
                    author = it[BookTable.author],
                    publishYear = it[BookTable.publishYear],
                    genre = it[BookTable.genre]
                )
//                val bookJson = Json.encodeToString(bookDT)
//                lettuceRedisClient.set("book:${bookDT.id}", bookJson)
            }
        }
    }
}