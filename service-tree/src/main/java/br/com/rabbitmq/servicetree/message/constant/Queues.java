package br.com.rabbitmq.servicetree.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Queues {

    public static final String QUEUE_SERVICE_TREE_FANOUT = "service.tree.queue.fanout";
    public static final String QUEUE_SERVICE_TREE_DIRECT = "service.tree.queue.direct";
    public static final String QUEUE_SERVICE_TREE_TOPIC = "service.tree.queue.topic";

}
