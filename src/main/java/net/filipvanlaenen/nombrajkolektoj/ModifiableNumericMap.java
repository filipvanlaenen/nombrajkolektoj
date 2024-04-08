package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableMap;

/**
 * Interface defining the signature for all modifiable numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface ModifiableNumericMap<K, N extends Number> extends UpdatableNumericMap<K, N>, ModifiableMap<K, N> {
}
