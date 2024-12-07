package top.mioyi.services.search.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.mioyi.entities.Position;
import top.mioyi.services.search.entity.PositionDocument;
import top.mioyi.services.search.repos.PositionRepository;
import top.mioyi.services.search.services.RabbitMQListener;
import top.mioyi.utils.RabbitMQConstants;

@Component
@AllArgsConstructor
public class RabbitMQListenerImpl implements RabbitMQListener {
    private final PositionRepository positionRepository;

    @RabbitListener(queues = RabbitMQConstants.SEARCH_QUEUE_NAME)
    @Override
    public void handleMessage(Position position) {
        positionRepository.save(new PositionDocument(position));
    }
}
