package com.example.data.Repo

import com.example.data.entities.BookDT

interface BooksRepo {
    suspend fun addBook(bookDT: BookDT)
    suspend fun getBookById(id: Int) : BookDT
    suspend fun getAllBooks() : List<BookDT>
    suspend fun deleteBookById(id: Int)
}