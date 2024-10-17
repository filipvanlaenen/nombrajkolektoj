package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} class.
 */
public final class ByteMapTest extends ByteMapTestBase<ByteMap<String>> {
    @Override
    protected ByteMap<String> createEmptyByteMap() {
        return ByteMap.empty();
    }

    @Override
    protected ByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ByteMap.of(entries);
    }

    @Override
    protected ByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key, final Byte value) {
        return ByteMap.of(key, value);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return ByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
