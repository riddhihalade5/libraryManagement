package com.example.domain

import com.example.data.BooksByIdDT
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject


class GetBookById
@Inject
constructor(
    private val booksByIdDT: BooksByIdDT
)
{
    suspend fun invokeDom(bookId: Int): BookDom? {
        val y = booksByIdDT.invokeDT(bookId)
        return y!!.toDomainLayer()

    }
}

