package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} class.
 */
public final class FloatMapTest extends FloatMapTestBase<FloatMap<String>> {
    @Override
    protected FloatMap<String> createEmptyFloatMap() {
        return FloatMap.empty();
    }

    @Override
    protected FloatMap<String> createFloatMap(final FloatMap<String> map) {
        return FloatMap.of(map);
    }

    @Override
    protected FloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return FloatMap.of(entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final FloatMap<String> map) {
        return FloatMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected FloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return FloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key, final Float value) {
        return FloatMap.of(key, value);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return FloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        FloatMap<String> map12 = createFloatMap(ENTRY1, ENTRY2);
        FloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        FloatMap<String> actual = FloatMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createFloatMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        FloatMap<String> map12 = createFloatMap(ENTRY1, ENTRY2);
        FloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        FloatMap<String> actual = FloatMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        FloatMap<String> expected =
                createFloatMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
