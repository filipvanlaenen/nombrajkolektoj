package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteMap} class.
 */
public final class SortedByteMapTest extends ByteMapTestBase<SortedByteMap<String>> {
    @Override
    protected SortedByteMap<String> createEmptyByteMap() {
        return SortedByteMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return SortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return SortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key, final Byte value) {
        return SortedByteMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }
}
