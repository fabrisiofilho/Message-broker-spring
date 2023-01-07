package br.com.rabbitmq.serviceone.message;

import br.com.rabbitmq.serviceone.message.constant.Exchange;
import br.com.rabbitmq.serviceone.message.constant.Queues;
import br.com.rabbitmq.serviceone.message.constant.RoutingKey;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin123");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        return connectionFactory;
    }

    @Bean
    public Queue queueFanout() {
        return new Queue(Queues.QUEUE_SERVICE_ONE_FANOUT, false);
    }

    @Bean
    public Queue queueTopic() {
        return new Queue(Queues.QUEUE_SERVICE_ONE_TOPIC, false);
    }

    @Bean
    public Queue queueDirect() {
        return new Queue(Queues.QUEUE_SERVICE_ONE_DIRECT, false);
    }
    
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(Exchange.FANOUT_EXCHANGE);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(Exchange.DIRECT_EXCHANGE);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(Exchange.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingFanout(@Qualifier("queueFanout") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindingTopic(@Qualifier("queueTopic") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RoutingKey.ALL_QUEUE);
    }

    @Bean
    public Binding bindingDirect(@Qualifier("queueDirect") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RoutingKey.KEY_ONE);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplateBean(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}