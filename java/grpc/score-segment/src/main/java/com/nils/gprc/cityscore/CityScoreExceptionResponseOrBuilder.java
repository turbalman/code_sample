// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: city_score.proto

package com.nils.gprc.cityscore;

public interface CityScoreExceptionResponseOrBuilder extends
        // @@protoc_insertion_point(interface_extends:cityscore.CityScoreExceptionResponse)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     *
     * @return Whether the timestamp field is set.
     */
    boolean hasTimestamp();

    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     *
     * @return The timestamp.
     */
    com.google.protobuf.Timestamp getTimestamp();

    /**
     * <code>.google.protobuf.Timestamp timestamp = 1;</code>
     */
    com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();

    /**
     * <code>.cityscore.CityScoreErrorCode error_code = 2;</code>
     *
     * @return The enum numeric value on the wire for errorCode.
     */
    int getErrorCodeValue();

    /**
     * <code>.cityscore.CityScoreErrorCode error_code = 2;</code>
     *
     * @return The errorCode.
     */
    com.nils.gprc.cityscore.CityScoreErrorCode getErrorCode();
}
