package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDataLayer
import javax.inject.Inject
import javax.inject.Named


class AddBook
@Inject
constructor(
    @Named("psql") private val psqlRepo: BooksRepo,
    @Named("redis") private val redisRepo : BooksRepo )

{
    suspend fun invokeDom(newB : BookDom) {

        val newDTbook = newB.toDataLayer()
        psqlRepo.addBook(newDTbook)
        redisRepo.addBook(newDTbook)



    }
}