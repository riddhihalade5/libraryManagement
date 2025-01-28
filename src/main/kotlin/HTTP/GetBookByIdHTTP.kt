package com.example.HTTP

import com.example.api.GetBookByIdAPI
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class GetBookByIdHTTP
@Inject
constructor(private val getBookByIdAPI: GetBookByIdAPI){
    suspend fun invokeHTTP(call: RoutingCall){
        println("Call: $call")
        val id = call.parameters["id"]?.toIntOrNull()
        if(id != null){

            val bookById = getBookByIdAPI.invokeAPI(id)

            if(bookById != null){
                call.respond(bookById)
            }
            else{
                call.respond(
                    "This id doesnot exists"
                )
            }}
    }
}