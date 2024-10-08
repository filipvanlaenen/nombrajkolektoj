package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongMap} class.
 */
public final class LongMapTest extends LongMapTestBase<LongMap<String>> {
    @Override
    protected LongMap<String> createEmptyLongMap() {
        return LongMap.empty();
    }

    @Override
    protected LongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return LongMap.of(entries);
    }

    @Override
    protected LongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return LongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected LongMap<String> createLongMap(final String key, final Long value) {
        return LongMap.of(key, value);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return LongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return LongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return LongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return LongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
