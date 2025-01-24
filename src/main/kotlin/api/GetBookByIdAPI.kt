package com.example.api
import com.example.domain.GetBookById
import com.example.domain.entities.BookDom
import javax.inject.Inject


class GetBookByIdAPI
@Inject
constructor(private val getBookById: GetBookById){
    suspend fun invokeAPI(bookId : Int) : BookDom?{

        return getBookById.invokeDom(bookId)

    }

}