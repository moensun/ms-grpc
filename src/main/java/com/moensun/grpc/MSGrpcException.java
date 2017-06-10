package com.moensun.grpc;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 19:33
 */
public class MSGrpcException extends RuntimeException {
    public MSGrpcException(String message) {
        super(message);
    }
}
