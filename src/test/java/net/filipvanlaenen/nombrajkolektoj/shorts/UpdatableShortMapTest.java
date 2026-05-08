package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} class.
 */
public final class UpdatableShortMapTest extends UpdatableShortMapTestBase<UpdatableShortMap<String>> {
    @Override
    protected UpdatableShortMap<String> createEmptyShortMap() {
        return UpdatableShortMap.<String>empty();
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final UpdatableShortMap<String> map) {
        return UpdatableShortMap.of(map);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return UpdatableShortMap.of(entries);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return UpdatableShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableShortMap<String> map) {
        return UpdatableShortMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key, final Short value) {
        return UpdatableShortMap.of(key, value);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return UpdatableShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return UpdatableShortMap.of(entries);
    }

    @Override
    protected UpdatableShortMap<String> createUpdatableShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Short defaultValue, final Collection<String> keys) {
        return UpdatableShortMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableShortMap<String> createUpdatableShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Short defaultValue, final String... keys) {
        return UpdatableShortMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableShortMap<String> createUpdatableShortMap(final Short defaultValue,
            final Collection<String> keys) {
        return UpdatableShortMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableShortMap<String> createUpdatableShortMap(final Short defaultValue, final String... keys) {
        return UpdatableShortMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableShortMap<String> map12 = createShortMap(ENTRY1, ENTRY2);
        UpdatableShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        UpdatableShortMap<String> actual = UpdatableShortMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createShortMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableShortMap<String> map12 = createShortMap(ENTRY1, ENTRY2);
        UpdatableShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        UpdatableShortMap<String> actual =
                UpdatableShortMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableShortMap<String> expected =
                createShortMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
