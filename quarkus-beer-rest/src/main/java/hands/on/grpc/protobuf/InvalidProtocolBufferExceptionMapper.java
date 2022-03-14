package hands.on.grpc.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidProtocolBufferExceptionMapper implements ExceptionMapper<InvalidProtocolBufferException> {
    @Override
    public Response toResponse(InvalidProtocolBufferException e) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
