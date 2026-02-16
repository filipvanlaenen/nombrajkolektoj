package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} class.
 */
public final class DoubleMapTest extends DoubleMapTestBase<DoubleMap<String>> {
    @Override
    protected DoubleMap<String> createEmptyDoubleMap() {
        return DoubleMap.empty();
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return DoubleMap.of(entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return DoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key, final Double value) {
        return DoubleMap.of(key, value);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return DoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(DoubleMap<String> map) {
        return DoubleMap.of(map);
    }
}
