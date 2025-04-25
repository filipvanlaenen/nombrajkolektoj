package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Integers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedIntegerMap<K> extends AbstractUpdatableIntegerMap<K>
        implements UpdatableSortedNumericMap<K, Integer> {
}
