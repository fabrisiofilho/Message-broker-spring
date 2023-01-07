package br.com.rabbitmq.serviceone.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Queues {

    public static final String QUEUE_SERVICE_ONE_FANOUT = "service.one.queue.fanout";
    public static final String QUEUE_SERVICE_ONE_DIRECT = "service.one.queue.direct";
    public static final String QUEUE_SERVICE_ONE_TOPIC = "service.one.queue.topic";

}
