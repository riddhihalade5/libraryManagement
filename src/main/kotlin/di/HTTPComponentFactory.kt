package com.example.di

class HTTPComponentFactory(private val rootComponent: RootComponent) {
    val httpComponent: HTTPComponent = DaggerHTTPComponent.builder()
        .rootComponent(rootComponent)
        .build()
}