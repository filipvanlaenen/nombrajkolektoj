package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Longs.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedLongMap<K> extends AbstractUpdatableLongMap<K>
        implements UpdatableSortedNumericMap<K, Long> {
}
