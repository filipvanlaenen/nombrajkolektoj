package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} class.
 */
public final class DoubleMapTest extends DoubleMapTestBase<DoubleMap<String>> {
    @Override
    protected DoubleMap<String> createEmptyDoubleMap() {
        return DoubleMap.empty();
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final DoubleMap<String> map) {
        return DoubleMap.of(map);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return DoubleMap.of(entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final DoubleMap<String> map) {
        return DoubleMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return DoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key, final Double value) {
        return DoubleMap.of(key, value);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return DoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        DoubleMap<String> map12 = createDoubleMap(ENTRY1, ENTRY2);
        DoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        DoubleMap<String> actual = DoubleMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createDoubleMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        DoubleMap<String> map12 = createDoubleMap(ENTRY1, ENTRY2);
        DoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        DoubleMap<String> actual = DoubleMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        DoubleMap<String> expected =
                createDoubleMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
