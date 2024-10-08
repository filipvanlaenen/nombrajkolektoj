package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractBigIntegerMap<K> implements NumericMap<K, BigInteger> {
    @Override
    public BigInteger max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public BigInteger min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public BigInteger product() {
        return getValues().product();
    }

    @Override
    public BigInteger sum() {
        return getValues().sum();
    }
}
