package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.UpdatableSortedMap;

/**
 * Interface defining the signature for all updatable sorted numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface UpdatableSortedNumericMap<K, N extends Number>
        extends UpdatableNumericMap<K, N>, UpdatableSortedMap<K, N> {
}
