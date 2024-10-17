package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * Shorts.
 *
 * @param <K> The key type.
 */
abstract class AbstractShortMap<K> implements NumericMap<K, Short> {
    @Override
    public Short max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Short min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Short product() {
        return getValues().product();
    }

    @Override
    public Short sum() {
        return getValues().sum();
    }
}
