package com.example.api

import com.example.api.entities.BookApi
import com.example.api.mappers.toApiLayer
import com.example.api.mappers.toDomainLayer
import com.example.domain.AddBook
import javax.inject.Inject

class AddNewBookAPI
@Inject
constructor(private val addBook: AddBook){
    suspend fun invokeAPI(bookApi: BookApi): BookApi{

        val domBook = bookApi.toDomainLayer()
        val newB = addBook.invokeDom(domBook)

        val newBook = newB!!.toApiLayer()
        return newBook
    }
}