package hands.on.grpc.protobuf;

import javax.ws.rs.core.MediaType;

/**
 * Custom MediaType subclass for the Protobuf media types.
 */
public class ProtocolBufferMediaType extends MediaType {

    /**
     * "application/x-protobuf"
     */
    public static final String APPLICATION_PROTOBUF = "application/x-protobuf";

    /**
     * "application/x-protobuf"
     */
    public static final MediaType APPLICATION_PROTOBUF_TYPE = new MediaType("application", "x-protobuf");

    /**
     * "application/x-protobuf-text-format"
     */
    public static final String APPLICATION_PROTOBUF_TEXT = "application/x-protobuf-text-format";

    /**
     * "application/x-protobuf-text-format"
     */
    public static final MediaType APPLICATION_PROTOBUF_TEXT_TYPE = new MediaType("application", "x-protobuf-text-format");

}
