package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.Map;

/**
 * Interface defining the signature for all numeric maps.
 *
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface NumericMap<K, N extends Number> extends Map<K, N> {
    /**
     * Returns a numeric collection with all values mapped to the key. Throws an exception if the map doesn't contain
     * entries with the key.
     *
     * @param key The key.
     * @return A numeric collection with all the values mapped to the key.
     * @throws IllegalArgumentException Thrown if the map doesn't contain entries with the key.
     */
    NumericCollection<N> getAll(K key) throws IllegalArgumentException;

    /**
     * Returns a numeric collection with all the values present in the map.
     *
     * @return A numeric collection with all the values present in the map.
     */
    NumericCollection<N> getValues();

    /**
     * Returns the largest number of the map values. Ignores <code>null</code> values, but returns <code>null</code> if
     * the map contains <code>null</code> values only. Throws an exception if the map is empty.
     *
     * @return The largest number of the map values, or <code>null</code> if the map contains <code>null</code> values
     *         only.
     * @throws IndexOutOfBoundsException Thrown if the map is empty.
     */
    N max() throws IndexOutOfBoundsException;

    /**
     * Returns the smallest number of the map values. Ignores <code>null</code> values, but returns <code>null</code> if
     * the map contains <code>null</code> values only. Throws an exception if the map is empty.
     *
     * @return The smallest number of the map values, or <code>null</code> if the map contains <code>null</code> values
     *         only.
     * @throws IndexOutOfBoundsException Thrown if the map is empty.
     */
    N min() throws IndexOutOfBoundsException;

    /**
     * Returns the product of the map values, or one if the map is empty. Ignores <code>null</code> values, but returns
     * one if the map contains <code>null</code> values only.
     *
     * @return The product of the map values, or one if the map is empty.
     */
    N product();

    /**
     * Returns the sum of the map values, or zero if the map is empty. Ignores <code>null</code> values, but returns
     * zero if the map contains <code>null</code> values only.
     *
     * @return The sum of the map values, or zero if the map is empty.
     */
    N sum();
}
