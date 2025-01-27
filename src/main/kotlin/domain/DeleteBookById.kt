package com.example.domain

import com.example.data.Repo.BooksRepo
import javax.inject.Inject


class DeleteBookById
@Inject
constructor(private val booksRepo: BooksRepo)
{
    suspend fun invoke(iD : Int) {
        booksRepo.deleteBookById(iD)

    }
}