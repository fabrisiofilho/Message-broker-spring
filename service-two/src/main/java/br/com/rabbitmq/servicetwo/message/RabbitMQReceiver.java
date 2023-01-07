package br.com.rabbitmq.servicetwo.message;

import br.com.rabbitmq.servicetwo.message.constant.Queues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQReceiver {

    @RabbitListener(queues = Queues.QUEUE_SERVICE_TWO_FANOUT)
    public void receivedMessageFanout(RabbitMessage rabbitMessage) {
        logginInfo(rabbitMessage);
    }

    @RabbitListener(queues = Queues.QUEUE_SERVICE_TWO_DIRECT)
    public void receivedMessageDirect(RabbitMessage rabbitMessage) {
        logginInfo(rabbitMessage);
    }

    @RabbitListener(queues = Queues.QUEUE_SERVICE_TWO_TOPIC)
    public void receivedMessagTopic(RabbitMessage rabbitMessage) {
        logginInfo(rabbitMessage);
    }

    private void logginInfo(RabbitMessage rabbitMessage) {
        log.info("Service Two - Recieved Message From RabbitMQ: By "
                + rabbitMessage.getService() + " Exchange type: "
                + rabbitMessage.getDescription() + " { CODE: "+ rabbitMessage.getCode() + " }");
    }

}
