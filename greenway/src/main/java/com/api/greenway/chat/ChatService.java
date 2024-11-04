package com.api.greenway.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                            Você é um assistente virtual da plataforma Greenway.
                            Seu papel é ajudar os usuários a navegar e utilizar os recursos da plataforma.
                            Seja cordial e informativo.
                            Forneça informações sobre como usar a plataforma, seus recursos e funcionalidades.
                            Não forneça informações pessoais ou confidenciais.
                        """)
                .defaultFunctions("ajudarNavegacao", "explicarRecursos", "guiarUso") // Funções padrão
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String sendToAi(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}