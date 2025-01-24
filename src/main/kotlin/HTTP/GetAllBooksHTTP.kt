package com.example.HTTP

import com.example.api.GetAllBooksAPI
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class GetAllBooksHTTP
@Inject
constructor(private val getAllBooksAPI: GetAllBooksAPI){
    suspend fun invokeHTTP(call: RoutingCall) {

        call.respond(HttpStatusCode.OK, getAllBooksAPI.invoke())
    }
}