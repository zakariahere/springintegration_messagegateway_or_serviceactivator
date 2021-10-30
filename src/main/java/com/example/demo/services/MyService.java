package com.example.demo.services;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class MyService implements Service {

    /**
     * @param pName name to print in s. console
     */
    @Override
    public void sayHello(final String pName) {
        log.info("Welcome to spring integration with zakaria/ " + pName);
    }
}
