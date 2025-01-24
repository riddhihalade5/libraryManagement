package com.example.di

import com.example.HTTP.*
import dagger.Component
import javax.inject.Singleton

@HttpScope
@Component(
  dependencies = [RootComponent::class]
)
interface HTTPComponent {
  val getBookByIdHTTP: GetBookByIdHTTP
  val addNewBookHTTP: AddNewBookHTTP
  val getBookAllBooksHTTP: GetAllBooksHTTP
  val deleteBookHTTP: DeleteBookHTTP
}