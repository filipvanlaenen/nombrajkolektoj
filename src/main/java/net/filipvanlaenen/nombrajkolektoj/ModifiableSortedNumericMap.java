package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableSortedMap;

/**
 * Interface defining the signature for all modifiable sorted numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface ModifiableSortedNumericMap<K, N extends Number>
        extends ModifiableNumericMap<K, N>, SortedNumericMap<K, N>, ModifiableSortedMap<K, N> {
}
