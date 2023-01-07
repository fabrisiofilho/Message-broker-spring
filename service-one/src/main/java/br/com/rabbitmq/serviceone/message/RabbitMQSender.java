package br.com.rabbitmq.serviceone.message;

import br.com.rabbitmq.serviceone.message.constant.Exchange;
import br.com.rabbitmq.serviceone.message.constant.RoutingKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendExchangeFanoutMessage(RabbitMessage rabbitMessage) {
        send(Exchange.FANOUT_EXCHANGE, "", rabbitMessage);
        log.info("Send message to RabbitMQ Fanout Exchange");
    }

    public void sendExchangeDirectMessageByServiceTwo(RabbitMessage rabbitMessage) {
        send(Exchange.DIRECT_EXCHANGE, RoutingKey.KEY_TWO, rabbitMessage);
        log.info("Send message to RabbitMQ Direct Exchange - Service Two");
    }

    public void sendExchangeDirectMessageByServiceTree(RabbitMessage rabbitMessage) {
        send(Exchange.DIRECT_EXCHANGE, RoutingKey.KEY_TREE, rabbitMessage);
        log.info("Send message to RabbitMQ Direct Exchange - Service Tree");
    }

    public void sendExchangeTopicMessageByServiceTreeAndServiceTwo(RabbitMessage rabbitMessage) {
        send(Exchange.TOPIC_EXCHANGE, RoutingKey.ALL_QUEUE, rabbitMessage);
        log.info("Send message to RabbitMQ Direct Exchange - Service Tree");
    }

    private void send(String exchange, String routingKey, RabbitMessage rabbitMessage) {
        rabbitTemplate.convertAndSend(exchange, routingKey, rabbitMessage);
    }

}
