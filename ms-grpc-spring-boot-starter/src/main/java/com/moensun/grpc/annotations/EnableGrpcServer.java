package com.moensun.grpc.annotations;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(value = {com.moensun.grpc.server.configuration.ServerScanConfiguration.class})
public @interface EnableGrpcServer {
}
