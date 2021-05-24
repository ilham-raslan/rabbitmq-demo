package com.ilham.github.rabbitmq.producer.runner;

import com.ilham.github.rabbitmq.model.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnExpression("${producer-run:false}")
public class RabbitMQProducerRunner implements CommandLineRunner {
  @Autowired private RabbitTemplate rabbitTemplate;

  @Override
  public void run(String... args) throws Exception {
    log.info("Running producer for RabbitMQ");

    SimpleMessage simpleMessage = new SimpleMessage();
    simpleMessage.setName("FirstMessage");
    simpleMessage.setDescription("SimpleDescription");

    this.rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
  }
}
