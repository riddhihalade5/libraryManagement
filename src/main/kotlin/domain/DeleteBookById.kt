package com.example.domain

import com.example.data.Repo.BooksRepo
import javax.inject.Inject
import javax.inject.Named


class DeleteBookById
@Inject
constructor(
    @Named("psql") private val psqlRepo: BooksRepo,
    @Named("redis") private val redisRepo: BooksRepo)
{
    suspend fun invoke(iD : Int) {
        psqlRepo.deleteBookById(iD)
        redisRepo.deleteBookById(iD)

    }
}