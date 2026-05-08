package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 */
public final class IntegerMapTest extends IntegerMapTestBase<IntegerMap<String>> {
    @Override
    protected IntegerMap<String> createEmptyIntegerMap() {
        return IntegerMap.empty();
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final IntegerMap<String> map) {
        return IntegerMap.of(map);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return IntegerMap.of(entries);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final IntegerMap<String> map) {
        return IntegerMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return IntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return IntegerMap.of(key, value);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return IntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        IntegerMap<String> map12 = createIntegerMap(ENTRY1, ENTRY2);
        IntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        IntegerMap<String> actual = IntegerMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createIntegerMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        IntegerMap<String> map12 = createIntegerMap(ENTRY1, ENTRY2);
        IntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        IntegerMap<String> actual = IntegerMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        IntegerMap<String> expected =
                createIntegerMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
