package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerMap} class.
 */
public final class ModifiableIntegerMapTest extends UpdatableIntegerMapTestBase<ModifiableIntegerMap<String>> {
    @Override
    protected ModifiableIntegerMap<String> createEmptyIntegerMap() {
        return ModifiableIntegerMap.<String>empty();
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return ModifiableIntegerMap.of(key, value);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }
}
