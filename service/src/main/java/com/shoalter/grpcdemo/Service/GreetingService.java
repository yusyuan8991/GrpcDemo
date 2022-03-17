package com.shoalter.grpcdemo.Service;

import com.shoalter.grpc.GreetingRequest;
import com.shoalter.grpc.GreetingResponse;
import com.shoalter.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received message: " + message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received message: " + message + ". Hello From Server!")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
