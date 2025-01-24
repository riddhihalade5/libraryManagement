package com.example.data

import com.example.data.entities.BookDT
import com.example.databases.BookTable
import com.example.di.LettuceRedisClient
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject
import kotlinx.serialization.encodeToString


class BooksByIdDT
@Inject
constructor
    (private val lettuceRedisClient: LettuceRedisClient) {
    suspend fun invokeDT(bookId: Int): BookDT? {

        val bookInCache = lettuceRedisClient.get(bookId.toString())
        val bookStringToDt = Json.decodeFromString<BookDT>(bookInCache.toString())

        if (bookInCache != null) {
            return bookStringToDt
        } else {

            val bookRecord = transaction {
                BookTable
                    .select(BookTable.id eq bookId)
                    .singleOrNull()
            }

            if (bookRecord != null) {
                val bookDT = BookDT(
                    id = bookId,
                    title = bookRecord[BookTable.title],
                    author = bookRecord[BookTable.author],
                    genre = bookRecord[BookTable.genre],
                    publishYear = bookRecord[BookTable.publishYear]

                )

                val bookDtToString = Json.encodeToString(bookDT)
                lettuceRedisClient.set(bookId.toString(), bookDtToString)

                return bookDT
            }
        }
        return null

    }
}



