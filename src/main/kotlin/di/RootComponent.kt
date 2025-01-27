package com.example.di

import com.example.databases.DBconfig
import com.example.databases.RedisDBConfig
import dagger.Component
import io.lettuce.core.RedisClient
import org.jetbrains.exposed.sql.Database
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      RedisDBConfig::class,
      DBconfig::class
    ]
)
interface RootComponent{
    val redisClient: RedisClient
    val lettuceRedisClient: LettuceRedisClient
    val database: Database
}