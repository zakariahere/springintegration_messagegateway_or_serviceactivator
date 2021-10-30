package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    @Qualifier("channel")
    MessageChannel myDirectChannel;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    ApplicationRunner sendToChannel() {
        return args -> {
            Stream.iterate(0, integer -> integer++).limit(100)
                    .forEach(integer -> {
                        Message<String> stringMessage = MessageBuilder.withPayload("Hi guys, thats going through the channel").setHeader("X-CROS", "CrossValue").build();
                        myDirectChannel.send(stringMessage);
                    });
        };
    }
}
