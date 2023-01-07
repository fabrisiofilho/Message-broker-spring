package br.com.rabbitmq.serviceone.controller;

import br.com.rabbitmq.serviceone.message.RabbitMQSender;
import br.com.rabbitmq.serviceone.message.RabbitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class ServiceOneController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping("/publishFanout")
    public String publishFanoutGet(){
        rabbitMQSender.sendExchangeFanoutMessage(RabbitMessage.builder()
                .service("service-one")
                .payload("Testando fanout")
                .description("fanout")
                .build());
        return "Enviado";
    }

    @GetMapping("/publishDirectTwo")
    public String publishDirectTwoGet(){
        rabbitMQSender.sendExchangeDirectMessageByServiceTwo(RabbitMessage.builder()
                .service("service-one")
                .payload("Testando direct para o service two")
                .description("direct")
                .build());
        return "Enviado";
    }

    @GetMapping("/publishDirectTree")
    public String publishDirectTreeGet(){
        rabbitMQSender.sendExchangeDirectMessageByServiceTree(RabbitMessage.builder()
                .service("service-one")
                .payload("Testando direct para o service tree")
                .description("direct")
                .build());
        return "Enviado";
    }

    @GetMapping("/publishTopic")
    public String publishTopicGet(){
        rabbitMQSender.sendExchangeTopicMessageByServiceTreeAndServiceTwo(RabbitMessage.builder()
                .service("service-one")
                .payload("Testando topic")
                .description("topic")
                .build());
        return "Enviado";
    }

}
