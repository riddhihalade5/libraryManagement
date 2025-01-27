package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject

class GetAllBooks
@Inject
constructor(private val booksRepo: BooksRepo)
{
    suspend fun invokeDom() : List<BookDom>{

        val y = booksRepo.getAllBooks().map{
            it.toDomainLayer()
        }
        return y
    }
}