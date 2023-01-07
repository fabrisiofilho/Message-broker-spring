package br.com.rabbitmq.servicetree.message;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = RabbitMessage.class)
public class RabbitMessage implements Serializable {

    private UUID code;
    private String service;
    private String description;
    private String payload;

    public RabbitMessage() {
        this.code = UUID.randomUUID();
    }

    public RabbitMessage(UUID code, String service, String description, String payload) {
        this.code = UUID.randomUUID();
        this.service = service;
        this.description = description;
        this.payload = payload;
    }


}
