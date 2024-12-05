package top.mioyi.services.info.services;

public interface RabbitMQListener {
    void handleMessage(String message);
}
