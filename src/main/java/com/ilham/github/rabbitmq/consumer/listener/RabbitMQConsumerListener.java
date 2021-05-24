package com.ilham.github.rabbitmq.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@Slf4j
public class RabbitMQConsumerListener implements MessageListener {
  @Override
  public void onMessage(Message message) {
      log.info("Message: " + new String(message.getBody()));
  }
}
