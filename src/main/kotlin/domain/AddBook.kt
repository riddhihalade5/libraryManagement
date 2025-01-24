package com.example.domain

import com.example.data.AddBookDT
import com.example.domain.entities.BookDom
import com.example.domain.mappers.toDataLayer
import com.example.domain.mappers.toDomainLayer
import javax.inject.Inject


class AddBook
@Inject
constructor(private val addBookDT: AddBookDT)
{

    suspend fun invokeDom(newB : BookDom) : BookDom? {

        val newDTbook = newB.toDataLayer()
        val newbook = addBookDT.invokeDT(newDTbook)

        val newDomBook = newbook!!.toDomainLayer()
        return newDomBook


    }
}