package com.moensun.grpc.configuration;

import com.moensun.grpc.properties.GrpcServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 17:25
 */
@Configuration
@EnableConfigurationProperties(value = {
        GrpcServerProperties.class
})
public class PropertiesConfiguration
{
}
