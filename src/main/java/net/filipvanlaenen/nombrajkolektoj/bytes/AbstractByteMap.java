package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} for
 * Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractByteMap<K> implements NumericMap<K, Byte> {
    @Override
    public Byte max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Byte min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Byte product() {
        return getValues().product();
    }

    @Override
    public Byte sum() {
        return getValues().sum();
    }
}
