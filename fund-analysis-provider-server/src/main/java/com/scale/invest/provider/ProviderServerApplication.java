package com.scale.invest.provider;

import com.xctech.log.annotation.EnableJsonLogback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableJsonLogback
@EnableFeignClients
@EnableEurekaClient
public class ProviderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderServerApplication.class, args);
    }
}
