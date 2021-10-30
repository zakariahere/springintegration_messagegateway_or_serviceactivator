package com.example.demo;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class SIConfiguration {


    @Autowired
    private Service myOwnService;

    /**
     * Describing a very simple channel
     *
     * @return
     */
    @Bean
    public MessageChannel channel() {
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "channel")
    public void handle(Message pMessage) {
        myOwnService.sayHello(pMessage.getPayload().toString());
        myOwnService.sayHello(pMessage.getHeaders().get("X-CROS").toString());

    }

}
