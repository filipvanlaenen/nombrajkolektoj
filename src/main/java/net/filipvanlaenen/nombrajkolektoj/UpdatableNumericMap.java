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
    N augment(K key, N addend) throws IllegalArgumentException;

    /**
     * Divides the value for the key in the map with the divisor and returns the value that was previously mapped to the
     * key. Throws an exception if the map doesn't contain an entry with the key or its value is <code>null</code>.
     *
     * @param key     The key.
     * @param divisor The number by which the value should be divided.
     * @return The value the key was mapped to previously.
     */
    N divide(K key, N divisor) throws IllegalArgumentException;

    /**
     * Multiplies the value for the key in the map with the multiplicand and returns the value that was previously
     * mapped to the key. Throws an exception if the map doesn't contain an entry with the key or its value is
     * <code>null</code>.
     *
     * @param key          The key.
     * @param multiplicand The number by which the value should be multiplied.
     * @return The value the key was mapped to previously.
     */
    N multiply(K key, N multiplicand) throws IllegalArgumentException;

    /**
     * Negates the value for the key in the map and returns the value that was previously mapped to the key. Throws an
     * exception if the map doesn't contain an entry with the key or its value is <code>null</code>.
     *
     * @param key The key.
     * @return The value the key was mapped to previously.
     */
    N negate(K key) throws IllegalArgumentException;

    /**
     * Subtracts the value for the key in the map with the subtrahend and returns the value that was previously mapped
     * to the key. Throws an exception if the map doesn't contain an entry with the key or its value is
     * <code>null</code>.
     *
     * @param key        The key.
     * @param subtrahend The number by which the value should be subtracted.
     * @return The value the key was mapped to previously.
     */
    N subtract(K key, N subtrahend) throws IllegalArgumentException;
}
