package com.example.databases

import com.example.di.LettuceRedisClient
import dagger.Provides
import dagger.Module
import io.lettuce.core.*
import javax.inject.Singleton

@Module
public class RedisDBConfig {
    @Provides
    @Singleton
    fun provideLettuceRedisClient(): LettuceRedisClient {
        val client = RedisClient.create("redis://localhost:6379")
        return LettuceRedisClient(client)
    }

}