package com.moensun.grpc.client.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:52
 */
@Configuration
@ComponentScan(
        basePackages = {"com.moensun.grpc.client"}
)
public class ClientScanConfiguration {
}
