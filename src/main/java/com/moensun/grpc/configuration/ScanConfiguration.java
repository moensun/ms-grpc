package com.moensun.grpc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:30
 */
@Configuration
@ComponentScan(
        basePackages = {"com.moensun.grpc"}
)
public class ScanConfiguration {
}
