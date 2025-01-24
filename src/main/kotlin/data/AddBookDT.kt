package com.example.data

import com.example.data.entities.BookDT
import com.example.databases.BookTable
import com.example.di.LettuceRedisClient
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject


class AddBookDT @Inject
constructor(
    private val lettuceRedisClient: LettuceRedisClient
) {
    suspend fun invokeDT(book: BookDT): BookDT? {

        val addToPsql = transaction {
            val bookId = BookTable.insertAndGetId {
                it[title] = book.title
                it[author] = book.author
                it[publishYear] = book.publishYear
                it[genre] = book.genre
            }

            BookDT(
                id = bookId.value,
                title = book.title,
                author = book.author,
                publishYear = book.publishYear,
                genre = book.genre
            )
        }

        AddtoRedisCache(book)
        return addToPsql
    }


    suspend fun AddtoRedisCache(book: BookDT): Unit {
        val bookargs = mapOf(
            "title" to book.title,
            "author" to book.author,
            "publishYear" to book.publishYear,
            "genre" to book.genre
        )
        val result = lettuceRedisClient.set(
            book.id.toString(), bookargs.toString()
        )

    }

}