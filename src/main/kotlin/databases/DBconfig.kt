package com.example.databases

import dagger.Module
import dagger.Provides
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject
import javax.inject.Singleton

@Module
public class DBconfig
{
    @Provides
    @Singleton
    fun Application.configureDatabase() {
        Database.connect(
            url = "jdbc:postgresql://localhost:54321/postgres",
            driver = "org.postgresql.Driver",
            user = System.getenv("username"),
            password = System.getenv("password")
        )

        transaction {
            SchemaUtils.create(BookTable)
        }
    }

}


