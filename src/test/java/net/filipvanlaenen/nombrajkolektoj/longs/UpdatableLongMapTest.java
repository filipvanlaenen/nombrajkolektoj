package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} class.
 */
public class UpdatableLongMapTest extends LongMapTestBase<UpdatableLongMap<String>> {
    @Override
    protected UpdatableLongMap<String> createEmptyLongMap() {
        return UpdatableLongMap.<String>empty();
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return UpdatableLongMap.of(entries);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return UpdatableLongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key, final Long value) {
        return UpdatableLongMap.of(key, value);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return UpdatableLongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
