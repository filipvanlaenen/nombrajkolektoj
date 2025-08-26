package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableSortedShortMap} class.
 */
public final class UpdatableSortedShortMapTest extends UpdatableShortMapTestBase<UpdatableSortedShortMap<String>> {
    @Override
    protected UpdatableSortedShortMap<String> createEmptyShortMap() {
        return UpdatableSortedShortMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key, final Short value) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4, final String key5, final Short value5) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createUpdatableShortMap(final Short defaultValue,
            final String... keys) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }
}
