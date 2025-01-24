package com.example.di

import com.example.HTTP.AddNewBookHTTP
import com.example.HTTP.DeleteBookHTTP
import com.example.HTTP.GetBookAllBooksHTTP
import com.example.HTTP.GetBookByIdHTTP
import dagger.Component
import javax.inject.Singleton

@HttpScope
@Component(
     dependencies = [RootComponent::class]
)

interface HTTPComponent{


    val getBookByIdHTTP : GetBookByIdHTTP
    val addNewBookHTTP : AddNewBookHTTP
    val getBookAllBooksHTTP : GetBookAllBooksHTTP
    val deleteBookHTTP : DeleteBookHTTP

}