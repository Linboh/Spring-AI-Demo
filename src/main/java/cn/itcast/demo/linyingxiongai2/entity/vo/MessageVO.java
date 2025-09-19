package cn.itcast.demo.linyingxiongai2.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Message;

@NoArgsConstructor
@Data
public class MessageVO {
    private String role;
    private String content;

    public MessageVO(Message message) {
        this.role = switch (message.getMessageType()) {
            case USER -> "user"; //表示消息来自用户（提问者）。
            case ASSISTANT -> "assistant"; //表示消息来自助手（AI回复）
            case SYSTEM -> "system"; //表示系统消息，用于给模型设定上下文或规则。
            default -> "";
        };
        this.content = message.getText();
    }
}