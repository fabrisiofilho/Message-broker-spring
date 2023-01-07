package br.com.rabbitmq.serviceone.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Exchange {

    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String TOPIC_EXCHANGE = "topic.exchange";

}
