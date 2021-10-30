package com.example.demo.services;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class MyService implements Service {

    /**
     * @param pName name to print in s. console
     * @return
     */
    @Override
    public String sayHello(final String pName) {
        return "Welcome to spring integration with zakaria/ " + pName;
    }
}
