// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: score_segment.proto

package com.nils.gprc.scoresegment;

/**
 * Protobuf type {@code scoresegment.ScoreSegmentRequest}
 */
public final class ScoreSegmentRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:scoresegment.ScoreSegmentRequest)
        ScoreSegmentRequestOrBuilder {
    public static final int ID_NUMBER_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:scoresegment.ScoreSegmentRequest)
    private static final com.nils.gprc.scoresegment.ScoreSegmentRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<ScoreSegmentRequest>
            PARSER = new com.google.protobuf.AbstractParser<ScoreSegmentRequest>() {
        @java.lang.Override
        public ScoreSegmentRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            Builder builder = newBuilder();
            try {
                builder.mergeFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());
            } catch (com.google.protobuf.UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(builder.buildPartial());
            }
            return builder.buildPartial();
        }
    };

    static {
        DEFAULT_INSTANCE = new com.nils.gprc.scoresegment.ScoreSegmentRequest();
    }

    private long idNumber_ = 0L;
    private byte memoizedIsInitialized = -1;
    // Use ScoreSegmentRequest.newBuilder() to construct.
    private ScoreSegmentRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ScoreSegmentRequest() {
    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return com.nils.gprc.scoresegment.ScoreSegment.internal_static_scoresegment_ScoreSegmentRequest_descriptor;
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.nils.gprc.scoresegment.ScoreSegmentRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.nils.gprc.scoresegment.ScoreSegmentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<ScoreSegmentRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new ScoreSegmentRequest();
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return com.nils.gprc.scoresegment.ScoreSegment.internal_static_scoresegment_ScoreSegmentRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.nils.gprc.scoresegment.ScoreSegmentRequest.class, com.nils.gprc.scoresegment.ScoreSegmentRequest.Builder.class);
    }

    /**
     * <code>uint64 id_number = 1;</code>
     *
     * @return The idNumber.
     */
    @java.lang.Override
    public long getIdNumber() {
        return idNumber_;
    }

    @java.lang.Override
    public boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (idNumber_ != 0L) {
            output.writeUInt64(1, idNumber_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (idNumber_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt64Size(1, idNumber_);
        }
        size += getUnknownFields().getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ScoreSegmentRequest other)) {
            return super.equals(obj);
        }

      if (getIdNumber()
                != other.getIdNumber()) return false;
        return getUnknownFields().equals(other.getUnknownFields());
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + ID_NUMBER_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getIdNumber());
        hash = (29 * hash) + getUnknownFields().hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ScoreSegmentRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public com.nils.gprc.scoresegment.ScoreSegmentRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code scoresegment.ScoreSegmentRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:scoresegment.ScoreSegmentRequest)
            com.nils.gprc.scoresegment.ScoreSegmentRequestOrBuilder {
        private int bitField0_;
        private long idNumber_;

        // Construct using com.nils.gprc.scoresegment.ScoreSegmentRequest.newBuilder()
        private Builder() {

        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.nils.gprc.scoresegment.ScoreSegment.internal_static_scoresegment_ScoreSegmentRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.nils.gprc.scoresegment.ScoreSegment.internal_static_scoresegment_ScoreSegmentRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.nils.gprc.scoresegment.ScoreSegmentRequest.class, com.nils.gprc.scoresegment.ScoreSegmentRequest.Builder.class);
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            bitField0_ = 0;
            idNumber_ = 0L;
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return com.nils.gprc.scoresegment.ScoreSegment.internal_static_scoresegment_ScoreSegmentRequest_descriptor;
        }

        @java.lang.Override
        public com.nils.gprc.scoresegment.ScoreSegmentRequest getDefaultInstanceForType() {
            return com.nils.gprc.scoresegment.ScoreSegmentRequest.getDefaultInstance();
        }

        @java.lang.Override
        public com.nils.gprc.scoresegment.ScoreSegmentRequest build() {
            com.nils.gprc.scoresegment.ScoreSegmentRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public com.nils.gprc.scoresegment.ScoreSegmentRequest buildPartial() {
            com.nils.gprc.scoresegment.ScoreSegmentRequest result = new com.nils.gprc.scoresegment.ScoreSegmentRequest(this);
            if (bitField0_ != 0) {
                buildPartial0(result);
            }
            onBuilt();
            return result;
        }

        private void buildPartial0(com.nils.gprc.scoresegment.ScoreSegmentRequest result) {
            int from_bitField0_ = bitField0_;
            if (((from_bitField0_ & 0x00000001) != 0)) {
                result.idNumber_ = idNumber_;
            }
        }

        @java.lang.Override
        public Builder clone() {
            return super.clone();
        }

        @java.lang.Override
        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return super.setField(field, value);
        }

        @java.lang.Override
        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @java.lang.Override
        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @java.lang.Override
        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, java.lang.Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @java.lang.Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof com.nils.gprc.scoresegment.ScoreSegmentRequest) {
                return mergeFrom((com.nils.gprc.scoresegment.ScoreSegmentRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.nils.gprc.scoresegment.ScoreSegmentRequest other) {
            if (other == com.nils.gprc.scoresegment.ScoreSegmentRequest.getDefaultInstance()) return this;
            if (other.getIdNumber() != 0L) {
                setIdNumber(other.getIdNumber());
            }
            this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @java.lang.Override
        public boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8: {
                            idNumber_ = input.readUInt64();
                            bitField0_ |= 0x00000001;
                            break;
                        } // case 8
                        default: {
                            if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                done = true; // was an endgroup tag
                            }
                            break;
                        } // default:
                    } // switch (tag)
                } // while (!done)
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            } finally {
                onChanged();
            } // finally
            return this;
        }

        /**
         * <code>uint64 id_number = 1;</code>
         *
         * @return The idNumber.
         */
        @java.lang.Override
        public long getIdNumber() {
            return idNumber_;
        }

        /**
         * <code>uint64 id_number = 1;</code>
         *
         * @param value The idNumber to set.
         * @return This builder for chaining.
         */
        public Builder setIdNumber(long value) {

            idNumber_ = value;
            bitField0_ |= 0x00000001;
            onChanged();
            return this;
        }

        /**
         * <code>uint64 id_number = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearIdNumber() {
            bitField0_ = (bitField0_ & ~0x00000001);
            idNumber_ = 0L;
            onChanged();
            return this;
        }

        @java.lang.Override
        public Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @java.lang.Override
        public Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }


        // @@protoc_insertion_point(builder_scope:scoresegment.ScoreSegmentRequest)
    }

}

