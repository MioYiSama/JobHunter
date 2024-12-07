package top.mioyi.services.info.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.mioyi.entities.EmployerInfo;
import top.mioyi.entities.UserInfo;
import top.mioyi.messages.CreateInfoMessage;
import top.mioyi.services.info.mappers.InfoMapper;
import top.mioyi.services.info.services.RabbitMQListener;
import top.mioyi.utils.RabbitMQConstants;
import top.mioyi.utils.Snowflake;

@Component
@AllArgsConstructor
public class RabbitMQListenerImpl implements RabbitMQListener {
    private final InfoMapper infoMapper;

    @Override
    @RabbitListener(queues = RabbitMQConstants.INFO_QUEUE_NAME)
    public void handleMessage(CreateInfoMessage message) {
        switch (message.getRole()) {
            case USER:
                infoMapper.insertUserInfo(UserInfo.builder().id(Snowflake.INSTANCE.nextId()).userId(message.getUserId()).build());
                break;
            case EMPLOYER:
                infoMapper.insertEmployerInfo(EmployerInfo.builder().id(Snowflake.INSTANCE.nextId()).employerId(message.getUserId()).build());
                break;
        }
    }
}
