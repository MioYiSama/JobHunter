package top.mioyi.services.info.services;

import top.mioyi.messages.CreateInfoMessage;

public interface RabbitMQListener {
    void handleMessage(CreateInfoMessage message);
}
