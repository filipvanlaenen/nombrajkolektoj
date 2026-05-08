package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalMap} class.
 */
public final class BigDecimalMapTest extends BigDecimalMapTestBase<BigDecimalMap<String>> {
    @Override
    protected BigDecimalMap<String> createEmptyBigDecimalMap() {
        return BigDecimalMap.empty();
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final BigDecimalMap<String> map) {
        return BigDecimalMap.of(map);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return BigDecimalMap.of(entries);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimalMap<String> map) {
        return BigDecimalMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return BigDecimalMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return BigDecimalMap.of(key, value);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2) {
        return BigDecimalMap.of(key1, value1, key2, value2);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4,
            final String key5, final BigDecimal value5) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        BigDecimalMap<String> map12 = createBigDecimalMap(ENTRY1, ENTRY2);
        BigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        BigDecimalMap<String> actual = BigDecimalMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createBigDecimalMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        BigDecimalMap<String> map12 = createBigDecimalMap(ENTRY1, ENTRY2);
        BigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        BigDecimalMap<String> actual = BigDecimalMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        BigDecimalMap<String> expected =
                createBigDecimalMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
