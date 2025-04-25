package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Shorts.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedShortMap<K> extends AbstractUpdatableShortMap<K>
        implements UpdatableSortedNumericMap<K, Short> {
}
