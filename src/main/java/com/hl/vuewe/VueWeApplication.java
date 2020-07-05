package com.hl.vuewe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hl.vuewe.mapper")
public class VueWeApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueWeApplication.class, args);
    }

}
