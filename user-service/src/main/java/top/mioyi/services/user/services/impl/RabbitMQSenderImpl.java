package top.mioyi.services.user.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import top.mioyi.services.user.services.RabbitMQSender;
import top.mioyi.utils.RabbitMQConstants;

@Service
@AllArgsConstructor
public class RabbitMQSenderImpl implements RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(
                RabbitMQConstants.INFO_EXCHANGE_NAME,
                RabbitMQConstants.ROUTING_KEY,
                message
        );
    }
}
