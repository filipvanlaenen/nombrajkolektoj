package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.BigIntegerMap} class.
 */
public final class BigIntegerMapTest extends BigIntegerMapTestBase<BigIntegerMap<String>> {
    @Override
    protected BigIntegerMap<String> createEmptyBigIntegerMap() {
        return BigIntegerMap.empty();
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return BigIntegerMap.of(entries);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return BigIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return BigIntegerMap.of(key, value);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return BigIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4, final String key5, final BigInteger value5) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }
}
