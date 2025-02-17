package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableIntegerMap} class.
 */
public class UpdatableIntegerMapTest extends IntegerMapTestBase<UpdatableIntegerMap<String>> {
    @Override
    protected UpdatableIntegerMap<String> createEmptyIntegerMap() {
        return UpdatableIntegerMap.<String>empty();
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return UpdatableIntegerMap.of(entries);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return UpdatableIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return UpdatableIntegerMap.of(key, value);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
