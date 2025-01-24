package com.example.api

import com.example.api.entities.BookApi
import com.example.domain.GetAllBooks
import com.example.domain.entities.BookDom
import javax.inject.Inject

class GetAllBooksAPI
@Inject
constructor(private val getAllBooks: GetAllBooks){
    suspend fun invoke() : List<BookDom> {

        return getAllBooks.invokeDom()

    }
}