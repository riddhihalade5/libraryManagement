package com.example.data.Repo

import com.example.data.entities.BookDT
import com.example.databases.BookTable
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

class BooksRepoPSQLImpl : BooksRepo {
    override suspend fun addBook(bookDT: BookDT): BookDT {
        TODO()

    }

    override suspend fun getBookById(id: Int): BookDT {
        TODO()
    }

    override suspend fun getAllBooks(): List<BookDT> {
        TODO()
    }

    override suspend fun deleteBookById(id: Int) {
        TODO()
    }
}