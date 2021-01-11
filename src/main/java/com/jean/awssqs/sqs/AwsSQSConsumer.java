package com.jean.awssqs.sqs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AwsSQSConsumer {

//    @Value("${aws.queueName}")
//    private final String queueName;

    @JmsListener(destination = "filateste.fifo")
    public void receiveMessage(final String message) {
        log.info("MESSAGE_RECEIVED", message);
    }
}
