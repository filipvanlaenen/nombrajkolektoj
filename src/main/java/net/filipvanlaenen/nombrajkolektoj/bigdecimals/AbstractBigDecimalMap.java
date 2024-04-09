package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * BigDecimals.
 */
abstract class AbstractBigDecimalMap<K> implements NumericMap<K, BigDecimal> {
    @Override
    public BigDecimal max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public BigDecimal min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public BigDecimal product() {
        return getValues().product();
    }

    @Override
    public BigDecimal sum() {
        return getValues().sum();
    }
}
