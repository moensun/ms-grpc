package com.moensun.grpc.test.client;

import com.moensun.grpc.service.GreeterGrpc;
import com.moensun.grpc.service.HelloReply;
import com.moensun.grpc.service.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 21:07
 */
public class GreetTest extends BaseGrpcTest {

/*    @Autowired
    private ManagedChannel managedChannel;*/

    @Test
    public void getMessage(){
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1",50051)
                .usePlaintext(true)
                .build();
        GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder().setName("gggg").build();
        HelloReply response;
        blockingStub.sayHello(request);

        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
