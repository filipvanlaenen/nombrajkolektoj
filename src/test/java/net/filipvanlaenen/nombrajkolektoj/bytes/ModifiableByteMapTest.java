package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteMap} class.
 */
public final class ModifiableByteMapTest extends UpdatableByteMapTestBase<ModifiableByteMap<String>> {
    @Override
    protected ModifiableByteMap<String> createEmptyByteMap() {
        return ModifiableByteMap.<String>empty();
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key, final Byte value) {
        return ModifiableByteMap.of(key, value);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return ModifiableByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }
}
