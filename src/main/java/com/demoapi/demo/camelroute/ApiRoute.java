package com.demoapi.demo.camelroute;


import com.demoapi.demo.service.ApiService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("apiRoute")
public class ApiRoute extends RouteBuilder {

    @Autowired
    ApiService apiService;

    @Override
    public void configure() throws Exception {

        //CamelContext context = new DefaultCamelContext();

/*        restConfiguration().component("servlet")
                .host("localhost").port(8080)
                .bindingMode(RestBindingMode.auto);*/

        restConfiguration().host("localhost:8080");
        from("rest:get:greeting").transform().constant("Hello World");


        rest("/api/greeting")
                .get()
                .route()
                .log("GET endpoint working")
                .to("bean:apiService?method=processGetRequest(${exchange})")
                .end();




    }
}

