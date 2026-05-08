package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} class.
 */
public final class UpdatableLongMapTest extends UpdatableLongMapTestBase<UpdatableLongMap<String>> {
    @Override
    protected UpdatableLongMap<String> createEmptyLongMap() {
        return UpdatableLongMap.<String>empty();
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final UpdatableLongMap<String> map) {
        return UpdatableLongMap.of(map);
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
    protected UpdatableLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableLongMap<String> map) {
        return UpdatableLongMap.of(keyAndValueCardinality, map);
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

    @Override
    protected UpdatableLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return UpdatableLongMap.of(entries);
    }

    @Override
    protected UpdatableLongMap<String> createUpdatableLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Long defaultValue, final Collection<String> keys) {
        return UpdatableLongMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableLongMap<String> createUpdatableLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Long defaultValue, final String... keys) {
        return UpdatableLongMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableLongMap<String> createUpdatableLongMap(final Long defaultValue,
            final Collection<String> keys) {
        return UpdatableLongMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableLongMap<String> createUpdatableLongMap(final Long defaultValue, final String... keys) {
        return UpdatableLongMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableLongMap<String> map12 = createLongMap(ENTRY1, ENTRY2);
        UpdatableLongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        UpdatableLongMap<String> actual = UpdatableLongMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createLongMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableLongMap<String> map12 = createLongMap(ENTRY1, ENTRY2);
        UpdatableLongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        UpdatableLongMap<String> actual =
                UpdatableLongMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableLongMap<String> expected =
                createLongMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
