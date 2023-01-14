package com.logicore.kafka.services;

import com.logicore.kafka.bindings.KafkaListenerBinding;
import com.logicore.kafka.model.IncomingMessage;
import com.logicore.kafka.transform.Transform;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(KafkaListenerBinding.class)
public class TransformationService {

    @Autowired
    Transform transformFunction;
    @StreamListener("input-channel-1")
    public void process(KTable<String, IncomingMessage> input) {

        input.filter((k, v) -> v.getCustomerType().equalsIgnoreCase("gold")).
                toStream().
                foreach((k, v) -> log.info(String.format("Key = %s and Value = %s", k, v)));

    }
}
