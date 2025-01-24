package com.example.data.Repo
import com.example.data.entities.BookDT
import com.example.di.LettuceRedisClient
import javax.inject.Inject

class BooksRepoRedisImpl
    @Inject
    constructor(private val lettuceRedisClient: LettuceRedisClient)
    : BooksRepo {
    override suspend fun addBook(book: BookDT): BookDT {
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