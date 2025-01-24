package com.example.api.mappers

import com.example.api.entities.BookApi
import com.example.domain.entities.BookDom


    fun BookApi.toDomainLayer() : BookDom {
        return BookDom(
            id = this.id,
            author = this.author,
            title = this.title,
            genre = this.genre,
            publishYear = this.publishYear
        )
    }

    fun BookDom.toApiLayer() : BookApi {
        return BookApi(
            id = this.id,
            author = this.author,
            title = this.title,
            genre = this.genre,
            publishYear = this.publishYear
        )
    }
