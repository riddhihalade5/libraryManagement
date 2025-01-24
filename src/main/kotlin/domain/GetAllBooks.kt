package com.example.domain

import com.example.data.BookStorage
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject

class GetAllBooks
@Inject
constructor(private val bookStorage: BookStorage)
{
    suspend fun invokeDom() : List<BookDom>{

        val y = bookStorage.invokeDT().map{
            it.toDomainLayer()
        }
        return y
    }
}