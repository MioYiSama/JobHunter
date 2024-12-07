package top.mioyi.services.search.services;

import top.mioyi.entities.Position;

public interface RabbitMQListener {
    void handleMessage(Position position);
}
