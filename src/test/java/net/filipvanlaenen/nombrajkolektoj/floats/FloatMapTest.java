package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} class.
 */
public final class FloatMapTest extends FloatMapTestBase<FloatMap<String>> {
    @Override
    protected FloatMap<String> createEmptyFloatMap() {
        return FloatMap.empty();
    }

    @Override
    protected FloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return FloatMap.of(entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return FloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key, final Float value) {
        return FloatMap.of(key, value);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return FloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
