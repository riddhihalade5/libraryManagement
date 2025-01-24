package com.example.HTTP

import com.example.api.AddNewBookAPI
import com.example.api.entities.BookApi
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class AddNewBookHTTP
@Inject
constructor(private val addNewBookAPI: AddNewBookAPI){
    suspend fun invokeHTTP(call: RoutingCall){
        val newbook = call.receive<BookApi>()
        addNewBookAPI.invokeAPI(newbook)
        call.respondText(text = "New book added" ,status = HttpStatusCode.Created)
    }
}