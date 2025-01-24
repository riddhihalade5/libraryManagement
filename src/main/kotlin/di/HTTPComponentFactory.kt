package com.example.di

class HTTPComponentFactory(rootComponent: RootComponent) {
    val httpComponent: HTTPComponent = DaggerHTTPComponent.builder()
        .rootComponent(rootComponent)
        .build()
}