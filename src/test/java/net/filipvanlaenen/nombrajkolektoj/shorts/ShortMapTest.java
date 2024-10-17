package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortMap} class.
 */
public final class ShortMapTest extends ShortMapTestBase<ShortMap<String>> {
    @Override
    protected ShortMap<String> createEmptyShortMap() {
        return ShortMap.empty();
    }

    @Override
    protected ShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ShortMap.of(entries);
    }

    @Override
    protected ShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key, final Short value) {
        return ShortMap.of(key, value);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return ShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}