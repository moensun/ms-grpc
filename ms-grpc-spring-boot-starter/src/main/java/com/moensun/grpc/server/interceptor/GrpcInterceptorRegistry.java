package com.moensun.grpc.server.interceptor;

import io.grpc.ServerInterceptor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/13
 * Time: 11:33
 */
@Component
public class GrpcInterceptorRegistry {
	private final List<GrpcInterceptorRegistration> registrations = new ArrayList<>();

	public List<GrpcInterceptorRegistration> getRegistrations() {
		return registrations;
	}

	public GrpcInterceptorRegistration addInterceptor(ServerInterceptor serverInterceptor) {
		GrpcInterceptorRegistration grpcInterceptorRegistration = new GrpcInterceptorRegistration(serverInterceptor);
		registrations.add(grpcInterceptorRegistration);
		return grpcInterceptorRegistration;
	}
}
