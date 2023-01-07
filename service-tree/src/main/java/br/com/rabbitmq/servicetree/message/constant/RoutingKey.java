package br.com.rabbitmq.servicetree.message.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RoutingKey {

    public static final String KEY_TREE = "KEYTREE";

    public static final String ALL_QUEUE = "service.*";

}
