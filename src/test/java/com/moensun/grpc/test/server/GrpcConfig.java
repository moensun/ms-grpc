package com.moensun.grpc.test.server;

import com.moensun.grpc.server.interceptor.GrpcInterceptorRegistry;
import com.moensun.grpc.server.interceptor.GrpcServerConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/13
 * Time: 12:38
 */
@Component
public class GrpcConfig extends GrpcServerConfigurerAdapter {
	@Override
	public void addInterceptors(GrpcInterceptorRegistry grpcInterceptorRegistry) {
		super.addInterceptors(grpcInterceptorRegistry);
	}
}
