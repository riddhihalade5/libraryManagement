package com.example.domain

import com.example.data.Repo.BooksRepo
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject
import javax.inject.Named

class GetAllBooks
@Inject
constructor(
    @Named("psql") private val psqlRepo: BooksRepo,
    @Named("redis") private val redisRepo: BooksRepo
    )
{
    suspend fun invokeDom() : List<BookDom>{

        val y = redisRepo.getAllBooks().map{
            it.toDomainLayer()
        }

        if(y == null){
            val x = psqlRepo.getAllBooks().map {
                it.toDomainLayer()
            }

            return x
        }
        else{
            return y
        }
    }
}