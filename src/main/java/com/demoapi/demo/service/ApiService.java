package com.demoapi.demo.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public void processGetRequest(Exchange exchange){
        exchange.getOut().setBody("Hellow ELK");
    }
}
