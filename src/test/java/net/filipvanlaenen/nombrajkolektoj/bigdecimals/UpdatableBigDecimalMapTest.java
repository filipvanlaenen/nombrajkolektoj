package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return UpdatableBigDecimalMap.of(entries);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, entries);
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
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue, final String... keys) {
        return UpdatableBigDecimalMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableBigDecimalMap<String> createUpdatableBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimal defaultValue, final String... keys) {
        return UpdatableBigDecimalMap.of(keyAndValueCardinality, defaultValue, keys);
    }
}
