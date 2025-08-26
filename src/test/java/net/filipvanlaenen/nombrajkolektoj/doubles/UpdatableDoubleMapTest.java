package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableDoubleMap} class.
 */
public final class UpdatableDoubleMapTest extends UpdatableDoubleMapTestBase<UpdatableDoubleMap<String>> {
    @Override
    protected UpdatableDoubleMap<String> createEmptyDoubleMap() {
        return UpdatableDoubleMap.<String>empty();
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return UpdatableDoubleMap.of(key, value);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue, final String... keys) {
        return UpdatableDoubleMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final String... keys) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, defaultValue, keys);
    }
}
