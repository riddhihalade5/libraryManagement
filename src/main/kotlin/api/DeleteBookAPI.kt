package com.example.api

import com.example.domain.DeleteBookById
import javax.inject.Inject

class DeleteBookAPI
@Inject
constructor(private val deleteBookById: DeleteBookById){
    suspend fun invokeAPI(id: String){

        deleteBookById.invoke(id.toInt())
    }
}