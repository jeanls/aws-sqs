package com.jean.awssqs.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AwsSQSProducer {

    private final AmazonSQS amazonSQS;

    private final Environment env;

    public void sendMessage(final String message) {
        final SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setMessageBody(message);
        sendMessageRequest.setMessageGroupId("qwerty");
        sendMessageRequest.setMessageDeduplicationId(UUID.randomUUID().toString());
        sendMessageRequest.setQueueUrl(env.getProperty("aws.sqsUrl"));


        amazonSQS.sendMessage(sendMessageRequest);
    }
}
