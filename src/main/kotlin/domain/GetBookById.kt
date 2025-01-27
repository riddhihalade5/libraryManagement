package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject


class GetBookById
@Inject
constructor(
    private val booksRepo: BooksRepo
)
{
    suspend fun invokeDom(bookId: Int): BookDom? {
        val y = booksRepo.getBookById(bookId)
        return y!!.toDomainLayer()

    }
}

