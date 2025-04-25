package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongMap} class.
 */
public final class SortedLongMapTest extends LongMapTestBase<SortedLongMap<String>> {
    @Override
    protected SortedLongMap<String> createEmptyLongMap() {
        return SortedLongMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return SortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return SortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key, final Long value) {
        return SortedLongMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }
}
