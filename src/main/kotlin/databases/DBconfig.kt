package com.example.databases

import com.example.data.Repo.BooksRepoPSQLImpl
import dagger.Module
import dagger.Provides
import org.jetbrains.exposed.sql.*
import javax.inject.Singleton

@Module
class DBconfig {
  @Provides
  @Singleton
  fun provideDb(): Database {
    return Database.connect(
      url = "jdbc:postgresql://localhost:54321/postgres",
      driver = "org.postgresql.Driver",
      user = System.getenv("username"),
      password = System.getenv("password")
    )
  }

  @Provides
  @Singleton
  fun provideBookRepoImpl(): BooksRepoPSQLImpl
  {
    return BooksRepoPSQLImpl()
  }}


