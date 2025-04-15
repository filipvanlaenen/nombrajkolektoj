package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortMap} class.
 */
public final class ModifiableShortMapTest extends UpdatableShortMapTestBase<ModifiableShortMap<String>> {
    @Override
    protected ModifiableShortMap<String> createEmptyShortMap() {
        return ModifiableShortMap.<String>empty();
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key, final Short value) {
        return ModifiableShortMap.of(key, value);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return ModifiableShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }
}
