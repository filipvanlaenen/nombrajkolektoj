package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap}
 * for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractSortedByteMap<K> extends AbstractByteMap<K> implements SortedNumericMap<K, Byte> {
}
