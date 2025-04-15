package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} class.
 */
public final class UpdatableByteMapTest extends UpdatableByteMapTestBase<UpdatableByteMap<String>> {
    @Override
    protected UpdatableByteMap<String> createEmptyByteMap() {
        return UpdatableByteMap.<String>empty();
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(entries);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key, final Byte value) {
        return UpdatableByteMap.of(key, value);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return UpdatableByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(entries);
    }
}
