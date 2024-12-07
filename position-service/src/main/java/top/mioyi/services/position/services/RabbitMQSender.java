package top.mioyi.services.position.services;

import top.mioyi.entities.Position;

public interface RabbitMQSender {
    void sendMessage(Position positionDTO);
}
