package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableSortedFloatMap} class.
 */
public final class UpdatableSortedFloatMapTest extends UpdatableFloatMapTestBase<UpdatableSortedFloatMap<String>> {
    @Override
    protected UpdatableSortedFloatMap<String> createEmptyFloatMap() {
        return UpdatableSortedFloatMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key, final Float value) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4, final String key5, final Float value5) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createUpdatableFloatMap(final Float defaultValue,
            final String... keys) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }
}
