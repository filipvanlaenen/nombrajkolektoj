package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} class.
 */
public final class UpdatableFloatMapTest extends UpdatableFloatMapTestBase<UpdatableFloatMap<String>> {
    @Override
    protected UpdatableFloatMap<String> createEmptyFloatMap() {
        return UpdatableFloatMap.<String>empty();
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(entries);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key, final Float value) {
        return UpdatableFloatMap.of(key, value);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return UpdatableFloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(entries);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final Float defaultValue, final String... keys) {
        return UpdatableFloatMap.of(defaultValue, keys);
    }
}
