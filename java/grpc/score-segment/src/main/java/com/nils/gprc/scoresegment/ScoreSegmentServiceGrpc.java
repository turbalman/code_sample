package com.nils.gprc.scoresegment;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.58.0)",
        comments = "Source: score_segment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScoreSegmentServiceGrpc {

    public static final java.lang.String SERVICE_NAME = "scoresegment.ScoreSegmentService";
    private static final int METHODID_CALCULATE_SCORE_SEGMENT = 0;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.nils.gprc.scoresegment.ScoreSegmentRequest,
            com.nils.gprc.scoresegment.ScoreSegmentResponse> getCalculateScoreSegmentMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private ScoreSegmentServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "calculateScoreSegment",
            requestType = com.nils.gprc.scoresegment.ScoreSegmentRequest.class,
            responseType = com.nils.gprc.scoresegment.ScoreSegmentResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.nils.gprc.scoresegment.ScoreSegmentRequest,
            com.nils.gprc.scoresegment.ScoreSegmentResponse> getCalculateScoreSegmentMethod() {
        io.grpc.MethodDescriptor<com.nils.gprc.scoresegment.ScoreSegmentRequest, com.nils.gprc.scoresegment.ScoreSegmentResponse> getCalculateScoreSegmentMethod;
        if ((getCalculateScoreSegmentMethod = ScoreSegmentServiceGrpc.getCalculateScoreSegmentMethod) == null) {
            synchronized (ScoreSegmentServiceGrpc.class) {
                if ((getCalculateScoreSegmentMethod = ScoreSegmentServiceGrpc.getCalculateScoreSegmentMethod) == null) {
                    ScoreSegmentServiceGrpc.getCalculateScoreSegmentMethod = getCalculateScoreSegmentMethod =
                            io.grpc.MethodDescriptor.<com.nils.gprc.scoresegment.ScoreSegmentRequest, com.nils.gprc.scoresegment.ScoreSegmentResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "calculateScoreSegment"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.nils.gprc.scoresegment.ScoreSegmentRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.nils.gprc.scoresegment.ScoreSegmentResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ScoreSegmentServiceMethodDescriptorSupplier("calculateScoreSegment"))
                                    .build();
                }
            }
        }
        return getCalculateScoreSegmentMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static ScoreSegmentServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceStub>() {
                    @java.lang.Override
                    public ScoreSegmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ScoreSegmentServiceStub(channel, callOptions);
                    }
                };
        return ScoreSegmentServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static ScoreSegmentServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceBlockingStub>() {
                    @java.lang.Override
                    public ScoreSegmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ScoreSegmentServiceBlockingStub(channel, callOptions);
                    }
                };
        return ScoreSegmentServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static ScoreSegmentServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ScoreSegmentServiceFutureStub>() {
                    @java.lang.Override
                    public ScoreSegmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ScoreSegmentServiceFutureStub(channel, callOptions);
                    }
                };
        return ScoreSegmentServiceFutureStub.newStub(factory, channel);
    }

    public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                .addMethod(
                        getCalculateScoreSegmentMethod(),
                        io.grpc.stub.ServerCalls.asyncUnaryCall(
                                new MethodHandlers<
                                        com.nils.gprc.scoresegment.ScoreSegmentRequest,
                                        com.nils.gprc.scoresegment.ScoreSegmentResponse>(
                                        service, METHODID_CALCULATE_SCORE_SEGMENT)))
                .build();
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ScoreSegmentServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ScoreSegmentServiceFileDescriptorSupplier())
                            .addMethod(getCalculateScoreSegmentMethod())
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
        default void calculateScoreSegment(com.nils.gprc.scoresegment.ScoreSegmentRequest request,
                                           io.grpc.stub.StreamObserver<com.nils.gprc.scoresegment.ScoreSegmentResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCalculateScoreSegmentMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service ScoreSegmentService.
     */
    public static abstract class ScoreSegmentServiceImplBase
            implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return ScoreSegmentServiceGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service ScoreSegmentService.
     */
    public static final class ScoreSegmentServiceStub
            extends io.grpc.stub.AbstractAsyncStub<ScoreSegmentServiceStub> {
        private ScoreSegmentServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ScoreSegmentServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScoreSegmentServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public void calculateScoreSegment(com.nils.gprc.scoresegment.ScoreSegmentRequest request,
                                          io.grpc.stub.StreamObserver<com.nils.gprc.scoresegment.ScoreSegmentResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getCalculateScoreSegmentMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service ScoreSegmentService.
     */
    public static final class ScoreSegmentServiceBlockingStub
            extends io.grpc.stub.AbstractBlockingStub<ScoreSegmentServiceBlockingStub> {
        private ScoreSegmentServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ScoreSegmentServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScoreSegmentServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public com.nils.gprc.scoresegment.ScoreSegmentResponse calculateScoreSegment(com.nils.gprc.scoresegment.ScoreSegmentRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getCalculateScoreSegmentMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service ScoreSegmentService.
     */
    public static final class ScoreSegmentServiceFutureStub
            extends io.grpc.stub.AbstractFutureStub<ScoreSegmentServiceFutureStub> {
        private ScoreSegmentServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ScoreSegmentServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScoreSegmentServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * unary
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.nils.gprc.scoresegment.ScoreSegmentResponse> calculateScoreSegment(
                com.nils.gprc.scoresegment.ScoreSegmentRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getCalculateScoreSegmentMethod(), getCallOptions()), request);
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
                case METHODID_CALCULATE_SCORE_SEGMENT:
                    serviceImpl.calculateScoreSegment((com.nils.gprc.scoresegment.ScoreSegmentRequest) request,
                            (io.grpc.stub.StreamObserver<com.nils.gprc.scoresegment.ScoreSegmentResponse>) responseObserver);
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

    private static abstract class ScoreSegmentServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        ScoreSegmentServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.nils.gprc.scoresegment.ScoreSegment.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ScoreSegmentService");
        }
    }

    private static final class ScoreSegmentServiceFileDescriptorSupplier
            extends ScoreSegmentServiceBaseDescriptorSupplier {
        ScoreSegmentServiceFileDescriptorSupplier() {
        }
    }

    private static final class ScoreSegmentServiceMethodDescriptorSupplier
            extends ScoreSegmentServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final java.lang.String methodName;

        ScoreSegmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
