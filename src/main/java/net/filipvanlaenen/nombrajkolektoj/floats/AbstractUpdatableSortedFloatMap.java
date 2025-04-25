package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for Floats.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedFloatMap<K> extends AbstractUpdatableFloatMap<K>
        implements UpdatableSortedNumericMap<K, Float> {
}
