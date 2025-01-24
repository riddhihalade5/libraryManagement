package com.example.HTTP

import com.example.api.DeleteBookAPI
import com.example.domain.DeleteBookById
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class DeleteBookHTTP
@Inject
constructor(private val deleteBookAPI: DeleteBookAPI){
    suspend fun invokeHTTP(call: RoutingCall){
        val id = call.parameters["id"]
        if(id != null){
            deleteBookAPI.invokeAPI(id)
            call.respondText(text = "Book removed successfully", status = HttpStatusCode.NoContent)
        }
        else{
            call.respondText(text = "Book not Found Invalid Id", status = HttpStatusCode.NotFound)
        }
    }
}