package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.UpdatableBigDecimalMap} class.
 */
public final class UpdatableBigDecimalMapTest extends UpdatableBigDecimalMapTestBase<UpdatableBigDecimalMap<String>> {
    @Override
    protected UpdatableBigDecimalMap<String> createEmptyBigDecimalMap() {
        return UpdatableBigDecimalMap.<String>empty();
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final UpdatableBigDecimalMap<String> map) {
        return UpdatableBigDecimalMap.of(map);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return UpdatableBigDecimalMap.of(entries);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableBigDecimalMap<String> map) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return UpdatableBigDecimalMap.of(key, value);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2) {
        return UpdatableBigDecimalMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3) {
        return UpdatableBigDecimalMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4) {
        return UpdatableBigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4,
            final String key5, final BigDecimal value5) {
        return UpdatableBigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return UpdatableBigDecimalMap.of(entries);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimal defaultValue, final Collection<String> keys) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimal defaultValue, final String... keys) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue,
            final Collection<String> keys) {
        return UpdatableBigDecimalMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue, final String... keys) {
        return UpdatableBigDecimalMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableBigDecimalMap<String> map12 = createBigDecimalMap(ENTRY1, ENTRY2);
        UpdatableBigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        UpdatableBigDecimalMap<String> actual = UpdatableBigDecimalMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createBigDecimalMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableBigDecimalMap<String> map12 = createBigDecimalMap(ENTRY1, ENTRY2);
        UpdatableBigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        UpdatableBigDecimalMap<String> actual =
                UpdatableBigDecimalMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableBigDecimalMap<String> expected =
                createBigDecimalMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
