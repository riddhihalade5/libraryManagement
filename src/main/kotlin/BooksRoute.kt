package com.example


import com.example.di.HTTPComponent
import io.ktor.server.routing.*


fun Route.bookRoute( httpComponent: HTTPComponent){

    get("/getAllBooks") {
        httpComponent.getBookAllBooksHTTP.invokeHTTP(call)
    }

    get("/book/{id}") {
        httpComponent.getBookByIdHTTP.invokeHTTP(call)
    }

    post("/addNewBook") {

        httpComponent.addNewBookHTTP.invokeHTTP(call)
    }

    delete("/deleteBook/{id}") {
        httpComponent.deleteBookHTTP.invokeHTTP(call)
    }
}


