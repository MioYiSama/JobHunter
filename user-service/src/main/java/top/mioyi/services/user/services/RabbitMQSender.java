package top.mioyi.services.user.services;

public interface RabbitMQSender {
    void sendMessage(String message);
}
