package com.moensun.grpc.test.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 15:02
 */
@SpringBootApplication(scanBasePackages = {"com.moensun.grpc.server","com.moensun.grpc.service"})
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
