package com.moensun.grpc.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 12:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Component
public @interface GrpcService {
}
