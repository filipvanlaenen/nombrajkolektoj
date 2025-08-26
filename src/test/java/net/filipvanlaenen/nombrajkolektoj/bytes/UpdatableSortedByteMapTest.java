package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableSortedByteMap} class.
 */
public final class UpdatableSortedByteMapTest extends UpdatableByteMapTestBase<UpdatableSortedByteMap<String>> {
    @Override
    protected UpdatableSortedByteMap<String> createEmptyByteMap() {
        return UpdatableSortedByteMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key, final Byte value) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4, final String key5, final Byte value5) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(final Byte defaultValue,
            final String... keys) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Byte defaultValue, final String... keys) {
        return UpdatableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }
}
