package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedByteMap<K> extends AbstractModifiableByteMap<K>
        implements ModifiableSortedNumericMap<K, Byte> {
}
