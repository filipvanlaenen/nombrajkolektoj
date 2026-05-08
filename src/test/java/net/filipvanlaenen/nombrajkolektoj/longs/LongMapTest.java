package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
    protected LongMap<String> createLongMap(final LongMap<String> map) {
        return LongMap.of(map);
    }

    @Override
    protected LongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return LongMap.of(entries);
    }

    @Override
    protected LongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final LongMap<String> map) {
        return LongMap.of(keyAndValueCardinality, map);
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

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        LongMap<String> map12 = createLongMap(ENTRY1, ENTRY2);
        LongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        LongMap<String> actual = LongMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createLongMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        LongMap<String> map12 = createLongMap(ENTRY1, ENTRY2);
        LongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        LongMap<String> actual = LongMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        LongMap<String> expected =
                createLongMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
