package top.mioyi.services.info.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.mioyi.entities.EmployerInfo;
import top.mioyi.entities.UserInfo;
import top.mioyi.services.info.mappers.InfoMapper;
import top.mioyi.services.info.services.RabbitMQListener;
import top.mioyi.types.Role;
import top.mioyi.utils.RabbitMQConstants;
import top.mioyi.utils.Snowflake;

@Component
@AllArgsConstructor
public class RabbitMQListenerImpl implements RabbitMQListener {
    private final InfoMapper infoMapper;

    @Override
    @RabbitListener(queues = RabbitMQConstants.INFO_QUEUE_NAME)
    public void handleMessage(String message) {
        val data = message.split(";");
        val role = Role.valueOf(data[0]);
        val id = Long.parseLong(data[1]);

        switch (role) {
            case USER:
                infoMapper.insertUserInfo(UserInfo.builder().id(Snowflake.INSTANCE.nextId()).userId(id).build());
                break;
            case EMPLOYER:
                infoMapper.insertEmployerInfo(EmployerInfo.builder().id(Snowflake.INSTANCE.nextId()).employerId(id).build());
                break;
        }
    }
}
