package hands.on.grpc.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * A JAX-RS provider to produce and write Protocol Buffers response entities.
 */
@Provider
@Produces({
        ProtocolBufferMediaType.APPLICATION_PROTOBUF,
        ProtocolBufferMediaType.APPLICATION_PROTOBUF_TEXT
})
public class ProtocolBufferMessageBodyWriter implements MessageBodyWriter<Message> {

    @Override
    public boolean isWriteable(final Class<?> type, final Type genericType,
                               final Annotation[] annotations, final MediaType mediaType) {
        return Message.class.isAssignableFrom(type);
    }

    @Override
    public void writeTo(final Message m, final Class<?> type, final Type genericType, final Annotation[] annotations,
                        final MediaType mediaType, final MultivaluedMap<String, Object> httpHeaders,
                        final OutputStream entityStream)
            throws IOException {

        if (mediaType.getSubtype().contains("text-format")) {
            entityStream.write(m.toString().getBytes(StandardCharsets.UTF_8));
        } else {
            m.writeTo(entityStream);
        }
    }

    @Override
    public long getSize(final Message m, final Class<?> type, final Type genericType,
                        final Annotation[] annotations, final MediaType mediaType) {

        if (mediaType.getSubtype().contains("text-format")) {
            final String formatted = TextFormat.printer().escapingNonAscii(false).printToString(m);
            return formatted.getBytes(StandardCharsets.UTF_8).length;
        }

        return m.getSerializedSize();
    }
}
