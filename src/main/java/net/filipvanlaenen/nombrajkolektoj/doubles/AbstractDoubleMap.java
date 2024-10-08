package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * Doubles.
 *
 * @param <K> The key type.
 */
abstract class AbstractDoubleMap<K> implements NumericMap<K, Double> {
    @Override
    public Double max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Double min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Double product() {
        return getValues().product();
    }

    @Override
    public Double sum() {
        return getValues().sum();
    }
}
