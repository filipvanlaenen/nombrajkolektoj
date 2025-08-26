package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableSortedLongMap} class.
 */
public final class UpdatableSortedLongMapTest extends UpdatableLongMapTestBase<UpdatableSortedLongMap<String>> {
    @Override
    protected UpdatableSortedLongMap<String> createEmptyLongMap() {
        return UpdatableSortedLongMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key, final Long value) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4, final String key5, final Long value5) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(final Long defaultValue,
            final String... keys) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Long defaultValue, final String... keys) {
        return UpdatableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }
}
