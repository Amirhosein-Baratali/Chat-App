package com.example.chatapp.data.remote

import com.example.chatapp.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://localhost:8080"
    }

    sealed class EndPoints(val url: String) {
        object GetAllMessages : EndPoints("${BASE_URL}/messages")
    }
}