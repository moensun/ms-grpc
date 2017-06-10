package com.moensun.grpc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 12:38
 */
@ConfigurationProperties(
		prefix = GrpcClientProperties.GRPC_CLIENT_PREFIX,
		ignoreInvalidFields = true,ignoreNestedProperties = true
)
public class GrpcClientProperties {
	public static final String GRPC_CLIENT_PREFIX = "ms.grpc.client";
	private Integer port;
	private String host;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
