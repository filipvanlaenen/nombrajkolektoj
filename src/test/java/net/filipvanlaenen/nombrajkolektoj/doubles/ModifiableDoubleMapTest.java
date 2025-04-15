package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleMap} class.
 */
public final class ModifiableDoubleMapTest extends UpdatableDoubleMapTestBase<ModifiableDoubleMap<String>> {
    @Override
    protected ModifiableDoubleMap<String> createEmptyDoubleMap() {
        return ModifiableDoubleMap.<String>empty();
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return ModifiableDoubleMap.of(key, value);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }
}
