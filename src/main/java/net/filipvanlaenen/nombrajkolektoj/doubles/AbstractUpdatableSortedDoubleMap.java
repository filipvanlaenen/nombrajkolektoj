package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Doubles.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedDoubleMap<K> extends AbstractUpdatableDoubleMap<K>
        implements UpdatableSortedNumericMap<K, Double> {
}
