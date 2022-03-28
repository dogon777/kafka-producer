package com.dakbangla.controller;

import com.dakbangla.repository.MessageRepository;
import com.dakbangla.sender.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaRestController {
    
    @Autowired
    MessageProducer messageProducer;

    @Autowired
    private MessageRepository messageRepo;

    //Send message to kafka
    @PostMapping("/send")
    public String sendMessage(@RequestBody String message){
        messageProducer.sendMessage(message);
        return "" +"'+message +'" + " sent successfully!";
    }
    
    @GetMapping("/sendMessages")
    public String sendMessages() throws Exception {
    	String response = messageProducer.sendMessages();
    	return response;
    }

    //Read all messages
    @GetMapping("/getAll")
    public String getAllMessages() {
        return messageRepo.getAllMessages() ;
    }
}
