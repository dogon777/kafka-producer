package com.dakbangla.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    
    private List<String> messages = new ArrayList<>();
    
    public void addMessage(String message){
        messages.add(message);
    }
    
    public String getAllMessages(){
        return messages.toString();
    }
}
