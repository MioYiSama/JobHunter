package top.mioyi.services.position.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import top.mioyi.entities.Position;
import top.mioyi.services.position.services.RabbitMQSender;
import top.mioyi.utils.RabbitMQConstants;

@Service
@AllArgsConstructor
public class RabbitMQSenderImpl implements RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Position position) {
        rabbitTemplate.convertAndSend(
                RabbitMQConstants.SEARCH_QUEUE_NAME,
                RabbitMQConstants.ROUTING_KEY,
                position
        );
    }
}
