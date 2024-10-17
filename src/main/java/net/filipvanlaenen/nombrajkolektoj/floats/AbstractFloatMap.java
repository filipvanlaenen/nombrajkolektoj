package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * Floats.
 *
 * @param <K> The key type.
 */
abstract class AbstractFloatMap<K> implements NumericMap<K, Float> {
    @Override
    public Float max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Float min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Float product() {
        return getValues().product();
    }

    @Override
    public Float sum() {
        return getValues().sum();
    }
}
