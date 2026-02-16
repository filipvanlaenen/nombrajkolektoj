package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.UpdatableBigIntegerMap} class.
 */
public final class UpdatableBigIntegerMapTest extends UpdatableBigIntegerMapTestBase<UpdatableBigIntegerMap<String>> {
    @Override
    protected UpdatableBigIntegerMap<String> createEmptyBigIntegerMap() {
        return UpdatableBigIntegerMap.<String>empty();
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(UpdatableBigIntegerMap<String> map) {
        return UpdatableBigIntegerMap.of(map);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return UpdatableBigIntegerMap.of(entries);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return UpdatableBigIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return UpdatableBigIntegerMap.of(key, value);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return UpdatableBigIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return UpdatableBigIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4) {
        return UpdatableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4,
            final String key5, final BigInteger value5) {
        return UpdatableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createUpdatableBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return UpdatableBigIntegerMap.of(entries);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue, final String... keys) {
        return UpdatableBigIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableBigIntegerMap<String> createUpdatableBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigInteger defaultValue, final String... keys) {
        return UpdatableBigIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }
}
