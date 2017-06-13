package com.moensun.grpc.server.interceptor;

import io.grpc.ServerInterceptor;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/13
 * Time: 11:34
 */
public class GrpcInterceptorRegistration {
	private ServerInterceptor serverInterceptor;

	public GrpcInterceptorRegistration(ServerInterceptor serverInterceptor) {
		this.serverInterceptor = serverInterceptor;
	}

	public ServerInterceptor getServerInterceptor() {
		return serverInterceptor;
	}

	public void setServerInterceptor(ServerInterceptor serverInterceptor) {
		this.serverInterceptor = serverInterceptor;
	}
}
