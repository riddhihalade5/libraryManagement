package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDataLayer
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject


class AddBook
@Inject
constructor(private val booksRepo: BooksRepo)
{

    suspend fun invokeDom(newB : BookDom) {

        val newDTbook = newB.toDataLayer()
        booksRepo.addBook(newDTbook)



    }
}