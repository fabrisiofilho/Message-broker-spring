package br.com.rabbitmq.servicetwo.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Queues {

    public static final String QUEUE_SERVICE_TWO_FANOUT = "service.two.queue.fanout";
    public static final String QUEUE_SERVICE_TWO_DIRECT = "service.two.queue.direct";
    public static final String QUEUE_SERVICE_TWO_TOPIC = "service.two.queue.topic";


}
