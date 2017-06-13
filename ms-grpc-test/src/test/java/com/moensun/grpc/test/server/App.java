package com.moensun.grpc.test.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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
        new SpringApplicationBuilder(App.class).web(false).run(args);
/*        SpringApplication application = new SpringApplication(App.class);
		application.setWebEnvironment(false);
		application.run(args);*/
    }
}
