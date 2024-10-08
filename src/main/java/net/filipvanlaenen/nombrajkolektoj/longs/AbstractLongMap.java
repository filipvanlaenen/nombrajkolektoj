package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * Longs.
 *
 * @param <K> The key type.
 */
abstract class AbstractLongMap<K> implements NumericMap<K, Long> {
    @Override
    public Long max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Long min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Long product() {
        return getValues().product();
    }

    @Override
    public Long sum() {
        return getValues().sum();
    }
}
