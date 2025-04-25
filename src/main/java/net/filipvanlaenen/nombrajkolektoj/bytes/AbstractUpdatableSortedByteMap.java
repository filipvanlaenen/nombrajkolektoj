package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedByteMap<K> extends AbstractUpdatableByteMap<K>
        implements UpdatableSortedNumericMap<K, Byte> {
}
