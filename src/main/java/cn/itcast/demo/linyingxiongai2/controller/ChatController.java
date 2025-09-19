package cn.itcast.demo.linyingxiongai2.controller;


import cn.itcast.demo.linyingxiongai2.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

/**
 * 前端地址 http://localhost:5173/
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    private final ChatMemory chatMemory;

    private final ChatHistoryRepository chatHistoryRepository;

    //http://localhost:8080/ai/chat?prompt=你是谁
    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt,String chatId) {

        chatHistoryRepository.save("chat",chatId);

        return chatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)) //会话ID设置
                .stream()
                .content();
    }
}

