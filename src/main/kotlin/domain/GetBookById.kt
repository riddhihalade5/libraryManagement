package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject
import javax.inject.Named


class GetBookById
@Inject
constructor(
    @Named("psql") private val psqlRepo: BooksRepo,
    @Named("redis") private val redisRepo: BooksRepo
)
{
    suspend fun invokeDom(bookId: Int): BookDom? {
        val y = redisRepo.getBookById(bookId)
        if(y == null){
            val x = psqlRepo.getBookById(bookId)
            return x!!.toDomainLayer()
        }
        else{
        return y!!.toDomainLayer()
        }

    }
}

