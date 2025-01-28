package com.example.data.Repo
import com.example.data.entities.BookDT
import com.example.di.LettuceRedisClient
import kotlinx.serialization.json.Json
import javax.inject.Inject



class BooksRepoRedisImpl
    @Inject
    constructor(private val lettuceRedisClient: LettuceRedisClient)
    : BooksRepo {

    override suspend fun addBook(book: BookDT){
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


    override suspend fun getBookById(id: Int): BookDT {
        val bookInCache = lettuceRedisClient.get(id.toString())
        val bookStringToDt = Json.decodeFromString<BookDT>(bookInCache.toString())

        if (bookInCache != null) {
            return bookStringToDt
        }

        return bookStringToDt

    }

    override suspend fun getAllBooks(): List<BookDT> {
        val keys = lettuceRedisClient.keys()
        val allBooks = mutableListOf<BookDT>()

        for (key in keys){
            val bookInCache = lettuceRedisClient.get(key)

            val book = bookInCache?.let{
                Json.decodeFromString<BookDT>(it)
            }

            allBooks.add(book!!)
        }
        return allBooks
    }

    override suspend fun deleteBookById(id: Int) {
        lettuceRedisClient.del(id.toString())
    }
}