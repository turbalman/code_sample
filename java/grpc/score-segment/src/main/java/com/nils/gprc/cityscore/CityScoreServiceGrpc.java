package com.nils.gprc.cityscore;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.58.0)",
        comments = "Source: city_score.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CityScoreServiceGrpc {

    public static final java.lang.String SERVICE_NAME = "cityscore.CityScoreService";
    private static final int METHODID_CALCULATE_CITY_SCORE = 0;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.nils.gprc.cityscore.CityScoreRequest,
            com.nils.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private CityScoreServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "calculateCityScore",
            requestType = com.nils.gprc.cityscore.CityScoreRequest.class,
            responseType = com.nils.gprc.cityscore.CityScoreResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.nils.gprc.cityscore.CityScoreRequest,
            com.nils.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod() {
        io.grpc.MethodDescriptor<com.nils.gprc.cityscore.CityScoreRequest, com.nils.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod;
        if ((getCalculateCityScoreMethod = CityScoreServiceGrpc.getCalculateCityScoreMethod) == null) {
            synchronized (CityScoreServiceGrpc.class) {
                if ((getCalculateCityScoreMethod = CityScoreServiceGrpc.getCalculateCityScoreMethod) == null) {
                    CityScoreServiceGrpc.getCalculateCityScoreMethod = getCalculateCityScoreMethod =
                            io.grpc.MethodDescriptor.<com.nils.gprc.cityscore.CityScoreRequest, com.nils.gprc.cityscore.CityScoreResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "calculateCityScore"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.nils.gprc.cityscore.CityScoreRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.nils.gprc.cityscore.CityScoreResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CityScoreServiceMethodDescriptorSupplier("calculateCityScore"))
                                    .build();
                }
            }
        }
        return getCalculateCityScoreMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CityScoreServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceStub>() {
                    @java.lang.Override
                    public CityScoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new CityScoreServiceStub(channel, callOptions);
                    }
                };
        return CityScoreServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CityScoreServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceBlockingStub>() {
                    @java.lang.Override
                    public CityScoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new CityScoreServiceBlockingStub(channel, callOptions);
                    }
                };
        return CityScoreServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CityScoreServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<CityScoreServiceFutureStub>() {
                    @java.lang.Override
                    public CityScoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new CityScoreServiceFutureStub(channel, callOptions);
                    }
                };
        return CityScoreServiceFutureStub.newStub(factory, channel);
    }

    public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                .addMethod(
                        getCalculateCityScoreMethod(),
                        io.grpc.stub.ServerCalls.asyncUnaryCall(
                                new MethodHandlers<
                                        com.nils.gprc.cityscore.CityScoreRequest,
                                        com.nils.gprc.cityscore.CityScoreResponse>(
                                        service, METHODID_CALCULATE_CITY_SCORE)))
                .build();
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (CityScoreServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new CityScoreServiceFileDescriptorSupplier())
                            .addMethod(getCalculateCityScoreMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public interface AsyncService {

        /**
         * <pre>
         * unary
         * </pre>
         */
        default void calculateCityScore(com.nils.gprc.cityscore.CityScoreRequest request,
                                        io.grpc.stub.StreamObserver<com.nils.gprc.cityscore.CityScoreResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCalculateCityScoreMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service CityScoreService.
     */
    public static abstract class CityScoreServiceImplBase
            implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return CityScoreServiceGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service CityScoreService.
     */
    public static final class CityScoreServiceStub
            extends io.grpc.stub.AbstractAsyncStub<CityScoreServiceStub> {
        private CityScoreServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CityScoreServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CityScoreServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public void calculateCityScore(com.nils.gprc.cityscore.CityScoreRequest request,
                                       io.grpc.stub.StreamObserver<com.nils.gprc.cityscore.CityScoreResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getCalculateCityScoreMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service CityScoreService.
     */
    public static final class CityScoreServiceBlockingStub
            extends io.grpc.stub.AbstractBlockingStub<CityScoreServiceBlockingStub> {
        private CityScoreServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CityScoreServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CityScoreServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public com.nils.gprc.cityscore.CityScoreResponse calculateCityScore(com.nils.gprc.cityscore.CityScoreRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getCalculateCityScoreMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service CityScoreService.
     */
    public static final class CityScoreServiceFutureStub
            extends io.grpc.stub.AbstractFutureStub<CityScoreServiceFutureStub> {
        private CityScoreServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CityScoreServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CityScoreServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.nils.gprc.cityscore.CityScoreResponse> calculateCityScore(
                com.nils.gprc.cityscore.CityScoreRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getCalculateCityScoreMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final AsyncService serviceImpl;
        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CALCULATE_CITY_SCORE:
                    serviceImpl.calculateCityScore((com.nils.gprc.cityscore.CityScoreRequest) request,
                            (io.grpc.stub.StreamObserver<com.nils.gprc.cityscore.CityScoreResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class CityScoreServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        CityScoreServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.nils.gprc.cityscore.CityScore.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CityScoreService");
        }
    }

    private static final class CityScoreServiceFileDescriptorSupplier
            extends CityScoreServiceBaseDescriptorSupplier {
        CityScoreServiceFileDescriptorSupplier() {
        }
    }

    private static final class CityScoreServiceMethodDescriptorSupplier
            extends CityScoreServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final java.lang.String methodName;

        CityScoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
