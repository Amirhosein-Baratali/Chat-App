package com.example.chatapp.data.remote

import com.example.chatapp.data.util.Resource
import com.example.chatapp.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://localhost:8080"
    }

    sealed class EndPoints(val url: String) {
        object ChatSocket : EndPoints("${BASE_URL}/chat-socket")
    }
}