package com.example.di

import com.example.databases.DBconfig
import com.example.databases.RedisDBConfig
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RedisDBConfig::class]
)

interface RootComponent{
    val lettuceRedisClient: LettuceRedisClient
    val dBconfig: DBconfig
}