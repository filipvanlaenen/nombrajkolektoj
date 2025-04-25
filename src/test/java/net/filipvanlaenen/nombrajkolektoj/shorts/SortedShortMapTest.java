package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortMap} class.
 */
public final class SortedShortMapTest extends ShortMapTestBase<SortedShortMap<String>> {
    @Override
    protected SortedShortMap<String> createEmptyShortMap() {
        return SortedShortMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return SortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return SortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final String key, final Short value) {
        return SortedShortMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return SortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return SortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return SortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return SortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }
}
