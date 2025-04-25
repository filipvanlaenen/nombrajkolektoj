package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for Longs.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedLongMap<K> extends AbstractModifiableLongMap<K>
        implements ModifiableSortedNumericMap<K, Long> {
}
