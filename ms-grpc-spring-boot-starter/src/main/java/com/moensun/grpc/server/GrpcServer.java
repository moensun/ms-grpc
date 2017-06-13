package com.moensun.grpc.server;

import com.moensun.grpc.MSGrpcException;
import com.moensun.grpc.annotations.GrpcService;
import com.moensun.grpc.server.interceptor.GrpcInterceptorRegistry;
import com.moensun.grpc.server.properties.GrpcServerProperties;
import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.type.StandardMethodMetadata;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 16:42
 */
@Component
public class GrpcServer implements ApplicationListener {
    private static final Logger logger = LoggerFactory.getLogger(GrpcServer.class);
    @Autowired
    private AbstractApplicationContext applicationContext;
    @Autowired
    private GrpcServerProperties grpcServerProperties;
    @Autowired
    private GrpcInterceptorRegistry grpcInterceptorRegistry;

    private Server server;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent)  {
        if(applicationEvent instanceof ApplicationReadyEvent){
            startServer();
        }
    }

    public void startServer() {
        ServerBuilder serverBuilder = ServerBuilder.forPort(grpcServerProperties.getPort());

        Stream.of(applicationContext.getBeanNamesForType(BindableService.class)).filter(name->{
            final BeanDefinition beanDefinition = applicationContext.getBeanFactory().getBeanDefinition(name);
            final Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(GrpcService.class);

            if ( !beansWithAnnotation.isEmpty() ) {
                return beansWithAnnotation.containsKey(name);
            } else if( beanDefinition.getSource() instanceof StandardMethodMetadata) {
                StandardMethodMetadata metadata = (StandardMethodMetadata) beanDefinition.getSource();
                return metadata.isAnnotated(GrpcService.class.getName());
            }
            return false;
        }).forEach(name->{
            BindableService srv = applicationContext.getBeanFactory().getBean(name, BindableService.class);
            ServerServiceDefinition serviceDefinition = srv.bindService();
            serverBuilder.addService(ServerInterceptors.intercept(serviceDefinition,getInterceptors()));
        });

        try {
            server = serverBuilder.build().start();
            logger.info("GRPC Server started at port{}",grpcServerProperties.getPort());
            startAwait();
        } catch (IOException e) {
            throw new MSGrpcException("grpc start error:" + e.getMessage());
        }
    }

    private void startAwait(){
        Thread awaitThread = new Thread(){
            public void run(){
                try {
                    if(Objects.nonNull(server)){
                        server.awaitTermination();
                    }
                } catch (InterruptedException e) {
                    throw new MSGrpcException(e.getMessage());
                }
            }
        };
        awaitThread.setDaemon(false);
        awaitThread.start();
    }

    protected List<ServerInterceptor> getInterceptors(){
        List<ServerInterceptor> serverInterceptors = new ArrayList<>();
        grpcInterceptorRegistry.getRegistrations().forEach(registration->{
            serverInterceptors.add(registration.getServerInterceptor());
        });
        return serverInterceptors;
    }

}
