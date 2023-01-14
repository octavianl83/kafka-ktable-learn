package com.logicore.kafka.bindings;

import com.logicore.kafka.model.IncomingMessage;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface KafkaListenerBinding {

    @Input("input-channel-1")
    KTable<String, String> inputStream1();

}
