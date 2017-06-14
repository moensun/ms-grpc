package com.moensun.grpc.service;

import com.moensun.grpc.annotations.GrpcService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 15:03
 */
@GrpcService
public class UserService extends GreeterGrpc.GreeterImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        try{
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+request.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }catch (Exception ex){
            responseObserver.onError(Status.INTERNAL.withCause(ex).withDescription("err").asRuntimeException());
        }
    }
}
