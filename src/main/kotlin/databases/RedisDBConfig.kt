package com.example.databases

import com.example.data.Repo.BooksRepo
import com.example.data.Repo.BooksRepoRedisImpl
import com.example.di.LettuceRedisClient
import dagger.Provides
import dagger.Module
import io.lettuce.core.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class RedisDBConfig {
    @Provides
    @Singleton
    fun provideLettuceRedisClient(): LettuceRedisClient {
        val client = RedisClient.create("redis://localhost:6379")
        return LettuceRedisClient(client)
    }

    @Provides
    @Singleton
    fun provideRedisClient(): RedisClient{
         val clientRedis = RedisClient.create("redis://localhost:6379")
        return clientRedis
    }

    @Provides
    @Singleton
    @Named("redis")
    fun provideRedisImplRepo(): BooksRepo{
        return BooksRepoRedisImpl()
    }
}