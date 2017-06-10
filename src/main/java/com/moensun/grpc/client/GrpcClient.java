package com.moensun.grpc.client;

import com.moensun.grpc.client.properties.GrpcClientProperties;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:54
 */
@Configuration
public class GrpcClient {

    @Bean
    public ManagedChannel createChannel(){
        return ManagedChannelBuilder
                .forAddress("127.0.0.1",50051)
                .usePlaintext(true)
                .build();
    }
}
