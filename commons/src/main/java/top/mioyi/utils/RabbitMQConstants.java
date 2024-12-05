package top.mioyi.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RabbitMQConstants {
    public final String INFO_QUEUE_NAME = "infoQueue";
    public final String INFO_EXCHANGE_NAME = "infoExchange";

    public final String SEARCH_QUEUE_NAME = "searchQueue";
    public final String SEARCH_EXCHANGE_NAME = "searchExchange";

    public final String ROUTING_KEY = "routingKey";
}
