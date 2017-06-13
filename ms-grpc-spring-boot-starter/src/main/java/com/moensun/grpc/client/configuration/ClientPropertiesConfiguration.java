package com.moensun.grpc.client.configuration;

import com.moensun.grpc.client.properties.GrpcClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:46
 */
@Configuration
@EnableConfigurationProperties(value = {
        GrpcClientProperties.class
})
public class ClientPropertiesConfiguration {
}
