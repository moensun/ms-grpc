package com.moensun.grpc.server.interceptor;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/13
 * Time: 11:20
 */
public interface GrpcServerConfigurer {
	void addInterceptors(GrpcInterceptorRegistry grpcInterceptorRegistry);
}
