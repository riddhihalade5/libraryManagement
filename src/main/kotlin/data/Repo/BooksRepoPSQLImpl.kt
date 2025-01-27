package com.example.data.Repo

import com.example.data.entities.BookDT
import com.example.databases.BookTable
import jakarta.inject.Inject
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class BooksRepoPSQLImpl
    @Inject
    constructor(): BooksRepo
{

    override suspend fun addBook(book: BookDT) {
        transaction {
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
    }

    override suspend fun getBookById(id: Int): BookDT {
        return transaction {
            val bookRecord = BookTable
                .select(BookTable.id eq id)
                .singleOrNull()

            requireNotNull(bookRecord) { "Book id $id not found" }

            BookDT(
                id = id,
                title = bookRecord[BookTable.title],
                author = bookRecord[BookTable.author],
                genre = bookRecord[BookTable.genre],
                publishYear = bookRecord[BookTable.publishYear]
            )
        }


    }

        override suspend fun getAllBooks(): List<BookDT> {
            return transaction {
                BookTable.selectAll().map {
                    BookDT(
                        id = it[BookTable.id].value,
                        title = it[BookTable.title],
                        author = it[BookTable.author],
                        publishYear = it[BookTable.publishYear],
                        genre = it[BookTable.genre]
                    )

                }
            }
        }

    override suspend fun deleteBookById(id: Int) {
        transaction {
                BookTable.deleteWhere { BookTable.id.eq(id) }
            }
        }
    }