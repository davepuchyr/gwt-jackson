package com.github.nmorel.gwtjackson.client.deser.array;

import java.io.IOException;
import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.NumberJsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

/**
 * Default {@link JsonDeserializer} implementation for array of long.
 *
 * @author Nicolas Morel
 */
public class PrimitiveLongArrayJsonDeserializer extends AbstractArrayJsonDeserializer<long[]> {

    private static final PrimitiveLongArrayJsonDeserializer INSTANCE = new PrimitiveLongArrayJsonDeserializer();

    /**
     * @return an instance of {@link PrimitiveLongArrayJsonDeserializer}
     */
    public static PrimitiveLongArrayJsonDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveLongArrayJsonDeserializer() { }

    @Override
    public long[] doDeserialize( JsonReader reader, JsonDeserializationContext ctx ) throws IOException {
        List<Long> list = deserializeIntoList( reader, ctx, NumberJsonDeserializer.getLongInstance() );

        long[] result = new long[list.size()];
        int i = 0;
        for ( Long value : list ) {
            if ( null != value ) {
                result[i] = value;
            }
            i++;
        }
        return result;
    }
}