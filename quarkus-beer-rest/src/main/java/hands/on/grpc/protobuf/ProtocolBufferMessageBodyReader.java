package hands.on.grpc.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A JAX-RS provider to parse Protocol Buffers request entities into objects.
 */
@Provider
@Consumes({
        ProtocolBufferMediaType.APPLICATION_PROTOBUF,
        ProtocolBufferMediaType.APPLICATION_PROTOBUF_TEXT
})
public class ProtocolBufferMessageBodyReader implements MessageBodyReader<Message> {
    private final Map<Class<Message>, Method> methodCache = new ConcurrentHashMap<>();

    @Override
    public boolean isReadable(final Class<?> type, final Type genericType,
                              final Annotation[] annotations, final MediaType mediaType) {
        return Message.class.isAssignableFrom(type);
    }

    @Override
    public Message readFrom(final Class<Message> type, final Type genericType, final Annotation[] annotations,
                            final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders,
                            final InputStream entityStream) throws IOException {

        final Method newBuilder =
                methodCache.computeIfAbsent(
                        type,
                        t -> {
                            try {
                                return t.getMethod("newBuilder");
                            } catch (Exception e) {
                                return null;
                            }
                        });

        final Message.Builder builder;
        try {
            builder = (Message.Builder) newBuilder.invoke(type);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
        if (mediaType.getSubtype().contains("text-format")) {
            TextFormat.merge(new InputStreamReader(entityStream, StandardCharsets.UTF_8), builder);
            return builder.build();
        } else {
            return builder.mergeFrom(entityStream).build();
        }
    }
}
