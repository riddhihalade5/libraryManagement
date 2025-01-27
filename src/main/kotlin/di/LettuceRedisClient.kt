package com.example.di

import io.lettuce.core.RedisClient
import io.lettuce.core.api.coroutines
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class LettuceRedisClient
@Inject
constructor(client: RedisClient) {

    private val connection by lazy { client.connect() }
    private val commands get() = connection.coroutines()

    suspend fun get(key: String): String? {
        return commands.get(key)
    }

    suspend fun del(key: String) {
        commands.del(key)
    }

    suspend fun set(key: String, value: String) {
        commands.set(key, value)
    }

    suspend fun setex(key: String, seconds: Long, value: String) {
        commands.setex(key, seconds, value)
    }

    suspend fun keys(): List<String>{
        return commands.keys("*").toList()
    }
}