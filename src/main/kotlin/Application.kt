package com.example

import com.example.di.HTTPComponentFactory
import com.example.di.RootComponent
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {

    val rootComponent = DaggerRootComponent.create()
    val httpComponent  = HTTPComponentFactory(rootComponent).httpComponent
    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){
        install(ContentNegotiation) {
            json()
        }
        routing {
            bookRoute(httpComponent)
        }

    }.start(wait = true)
}


