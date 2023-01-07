package br.com.rabbitmq.servicetwo.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RoutingKey {

    public static final String KEY_TWO = "KEYTWO";

    public static final String ALL_QUEUE = "service.*";

}
