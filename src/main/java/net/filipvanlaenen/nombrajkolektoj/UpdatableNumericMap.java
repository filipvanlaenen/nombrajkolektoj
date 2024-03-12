package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.UpdatableMap;

/**
 * Interface defining the signature for all updatable numeric maps.
 * 
 * @param <K> The key type.
 * @param <N> The value type.
 */
public interface UpdatableNumericMap<K, N extends Number> extends NumericMap<K, N>, UpdatableMap<K, N> {
    N augment(K key, N addend);

    /**
     * Augments all the values in the map with the addend and returns whether any of the values were changed. Ignores
     * <code>null</code> values.
     *
     * @param addend The number by which all values in the map should be augmented.
     * @return True if any of the values in the map was changed.
     */
    boolean augment(N addend);

    N multiply(K key, N addend);

    /**
     * Multiplies all the values in the map with the multiplicand and returns whether any of the values were changed.
     * Ignores <code>null</code> values.
     *
     * @param multiplicand The number by which all values in the map should be multiplied.
     * @return True if any of the values in the map was changed.
     */
    boolean multiply(N multiplicand);

    /**
     * Negates all the values in the map and returns whether any of the values were changed. Ignores <code>null</code>
     * values.
     *
     * @return True if any of the values in the map was changed.
     */
    boolean negate();

    N negate(K key);
}
