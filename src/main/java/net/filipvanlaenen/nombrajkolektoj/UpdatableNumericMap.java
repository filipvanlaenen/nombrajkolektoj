package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.UpdatableMap;

/**
 * Interface defining the signature for all updatable numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface UpdatableNumericMap<K, N extends Number> extends NumericMap<K, N>, UpdatableMap<K, N> {
    /**
     * Augments the value for the key in the map with the addend and returns the value that was previously mapped to the
     * key. Throws an exception if the map doesn't contain an entry with the key or its value is <code>null</code>.
     *
     * @param key    The key.
     * @param addend The number by which the value should be augmented.
     * @return The value the key was mapped to previously.
     */
    N augment(K key, N addend);

    /**
     * Multiplies the value for the key in the map with the multiplicand and returns the value that was previously
     * mapped to the key. Throws an exception if the map doesn't contain an entry with the key or its value is
     * <code>null</code>.
     *
     * @param key          The key.
     * @param multiplicand The number by which the value should be multiplied.
     * @return The value the key was mapped to previously.
     */
    N multiply(K key, N multiplicand);

    /**
     * Negates the value for the key in the map and returns the value that was previously mapped to the key. Throws an
     * exception if the map doesn't contain an entry with the key or its value is <code>null</code>.
     *
     * @param key The key.
     * @return The value the key was mapped to previously.
     */
    N negate(K key);
}
