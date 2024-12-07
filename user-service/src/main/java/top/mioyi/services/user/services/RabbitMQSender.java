package top.mioyi.services.user.services;

import top.mioyi.messages.CreateInfoMessage;

public interface RabbitMQSender {
    void sendMessage(CreateInfoMessage message);
}
