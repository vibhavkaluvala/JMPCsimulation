package com.jpmc.midascore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.jpmc.midascore.foundation.Transaction;

@Component
public class TransactionListener {

    @Value("${kafka.topic.name}")  // Assumes the topic name is stored in application.yml under this key
    private String topicName;

    @KafkaListener(topics = "#{__listener.topicName}", groupId = "midas_core_group")
    public void listen(Transaction transaction) {
        // Debugging: Place a breakpoint here to observe the transaction data
        System.out.println("Received transaction: " + transaction);
    }
}