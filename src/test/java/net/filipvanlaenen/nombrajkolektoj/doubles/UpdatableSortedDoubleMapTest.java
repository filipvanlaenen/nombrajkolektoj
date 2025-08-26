package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableSortedDoubleMap} class.
 */
public final class UpdatableSortedDoubleMapTest extends UpdatableDoubleMapTestBase<UpdatableSortedDoubleMap<String>> {
    @Override
    protected UpdatableSortedDoubleMap<String> createEmptyDoubleMap() {
        return UpdatableSortedDoubleMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4, final String key5, final Double value5) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue,
            final String... keys) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Double defaultValue, final String... keys) {
        return UpdatableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }
}
