package com.moensun.grpc.test.client;

import com.moensun.grpc.annotations.EnableGrpcClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 21:06
 */
@SpringBootApplication
@EnableGrpcClient
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(false).run(args);
    }
}
