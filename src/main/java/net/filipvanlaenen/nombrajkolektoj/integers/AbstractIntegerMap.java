package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * integers.
 */
abstract class AbstractIntegerMap<K> implements NumericMap<K, Integer> {
    @Override
    public Integer max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Integer min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Integer product() {
        return getValues().product();
    }

    @Override
    public Integer sum() {
        return getValues().sum();
    }
}
