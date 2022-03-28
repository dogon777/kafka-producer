package com.dakbangla.sender;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.dakbangla.domain.PracticalAdvice;

@Component
public class MessageProducer {
    private Logger log = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Value("${myapp.kafka.topic}")
    private String topicName;
    
    @Value("${myapp.kafka.messages-per-request}")
    private int messagesPerRequest;
    
    // private final KafkaTemplate<String, Object> template;
    // private final String topicName;
    // private final int messagesPerRequest;
    private CountDownLatch latch;
    
    public MessageProducer() {
            // final KafkaTemplate<String, Object> template,
            // @Value("${myapp.kafka.topic}") final String topicName,
            // @Value("${myapp.kafka.messages-per-request}") final int messagesPerRequest) {
    	log.info("===> Entering Message Producer constructor");
        // this.template = template;
        // this.topicName = topicName;
        // this.messagesPerRequest = messagesPerRequest;
    }
    
    public String sendMessages() throws Exception {
    	log.info("===> Entering MessageProducer.sendMessages()");
        latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i),
                        new PracticalAdvice("A Practical Advice", i))
                );
        latch.await(60, TimeUnit.SECONDS);
        log.info("All messages sent");
        return "Messages sent";
    }

    public void sendMessage(String message){
        log.info("MESSAGE SENT FROM PRODUCER END -->" +message);
        ListenableFuture<SendResult<String, Object>> future = this.template.send(topicName,"abc", new PracticalAdvice("Test of Practical Advice Message", 1));
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("Sent message=[" + message + 
                  "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" 
                  + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
