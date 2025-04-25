package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatMap} class.
 */
public final class SortedFloatMapTest extends FloatMapTestBase<SortedFloatMap<String>> {
    @Override
    protected SortedFloatMap<String> createEmptyFloatMap() {
        return SortedFloatMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return SortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return SortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key, final Float value) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }
}
