# MoenSun GRPC Spring boot starter
##说明
    本项目主要用于spring boot 与grpc的集成。包括拦截器配置
##使用方法
###引入jar包

    <dependency>
    	<groupId>com.moensun.grpc</groupId>
    	<artifactId>ms-grpc-spring-boot-starter</artifactId>
    	<version>1.0-SNAPSHOT</version>
    </dependency>
###配置监听端口
     ms.grpc.server.port=50051
###通过注解讲项目加入扫描
    @EnableGrpcServer
###在提供服务的类上加注解，以便程序可以扫描到
    @GrpcService
###拦截器
####拦截器的用法类似于spring-boot的拦截器使用
#####实现一个拦截器
    @Component
    public class GrpcInterceptor implements ServerInterceptor {
    	@Override
    	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
    		return null;
    	}
    }
#####将拦截器注入到容器，容器启动完成的时候，会去获取所有的拦截器，在注册grpc服务的时候，会将拦截器配置进去
    @Component
    public class GrpcConfig extends GrpcServerConfigurerAdapter {
    	@Override
    	public void addInterceptors(GrpcInterceptorRegistry grpcInterceptorRegistry) {
    		super.addInterceptors(grpcInterceptorRegistry);
    	}
    }
    