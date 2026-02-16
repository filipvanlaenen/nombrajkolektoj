package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
    protected BigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return BigDecimalMap.of(entries);
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

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(BigDecimalMap<String> map) {
        return BigDecimalMap.of(map);
    }
}
