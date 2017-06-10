package com.moensun.grpc.server.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 20:00
 */
@ConfigurationProperties(
        prefix = GrpcServerProperties.GRPC_SERVER_PREFIX,
        ignoreInvalidFields = true,ignoreNestedProperties = true
)
public class GrpcServerProperties {
    public static final String GRPC_SERVER_PREFIX = "ms.grpc.server";
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
