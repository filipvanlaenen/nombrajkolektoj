package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableSortedIntegerMap} class.
 */
public final class UpdatableSortedIntegerMapTest extends UpdatableIntegerMapTestBase<UpdatableSortedIntegerMap<String>> {
    @Override
    protected UpdatableSortedIntegerMap<String> createEmptyIntegerMap() {
        return UpdatableSortedIntegerMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return UpdatableSortedIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3, final String key4,
            final Integer value4) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3, final String key4,
            final Integer value4, final String key5, final Integer value5) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createUpdatableIntegerMap(final Entry<String, Integer>... entries) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createUpdatableIntegerMap(final Integer defaultValue,
            final String... keys) {
        return UpdatableSortedIntegerMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedIntegerMap<String> createUpdatableIntegerMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Integer defaultValue, final String... keys) {
        return UpdatableSortedIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }
}
