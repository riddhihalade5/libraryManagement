package com.example.domain

import com.example.data.DeleteBookDT
import javax.inject.Inject


class DeleteBookById
@Inject
constructor(private val deleteBookDT: DeleteBookDT)
{
    suspend fun invoke(iD : Int) {
        deleteBookDT.invokeDT(iD)

    }
}