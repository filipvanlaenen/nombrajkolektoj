package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.SortedMap;

/**
 * Interface defining the signature for all sorted numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface SortedNumericMap<K, N extends Number> extends NumericMap<K, N>, SortedMap<K, N> {
}
