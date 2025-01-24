package com.example.domain.mappers

import com.example.data.entities.BookDT
import com.example.domain.entities.BookDom

fun BookDom.toDataLayer() : BookDT{
    return BookDT(
        id = this.id,
        author = this.author,
        title = this.title,
        genre = this.genre,
        publishYear = this.publishYear
    )
}

fun BookDT.toDomainLayer() : BookDom {
    return BookDom(
        id = this.id,
        author = this.author,
        title = this.title,
        genre = this.genre,
        publishYear = this.publishYear
    )
}

