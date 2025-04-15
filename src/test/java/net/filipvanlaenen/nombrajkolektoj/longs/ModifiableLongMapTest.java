package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongMap} class.
 */
public final class ModifiableLongMapTest extends UpdatableLongMapTestBase<ModifiableLongMap<String>> {
    @Override
    protected ModifiableLongMap<String> createEmptyLongMap() {
        return ModifiableLongMap.<String>empty();
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(entries);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key, final Long value) {
        return ModifiableLongMap.of(key, value);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return ModifiableLongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(entries);
    }
}
