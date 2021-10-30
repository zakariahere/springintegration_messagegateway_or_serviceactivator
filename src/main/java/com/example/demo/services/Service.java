package com.example.demo.services;

import org.springframework.integration.annotation.Gateway;

public interface Service {

    /**
     * Abstraction
     */
    @Gateway(requestChannel = "channel")
    String sayHello(final String pName);
}
