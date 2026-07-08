package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * A modifiable numeric collection. In addition to the functionality of modifiable collections in general and numeric
 * collections, it supports augmenting, subtracting, multiplying and dividing the collection with a number, and negating
 * it.
 *
 * @param <N> The numeric element type.
 */
public interface ModifiableNumericCollection<N extends Number> extends NumericCollection<N>, ModifiableCollection<N> {
    /**
     * Augments all the numbers in the collection with the addend and returns whether any of the numbers were changed.
     * Ignores <code>null</code> elements.
     *
     * @param addend The number by which all numbers in the collection should be augmented.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collection would contain duplicates when they're not allowed.
     */
    boolean augment(N addend) throws IllegalArgumentException;

    /**
     * Divides all the numbers in the collection with the divisor and returns whether any of the numbers were changed.
     * Ignores <code>null</code> elements.
     *
     * @param divisor The number by which all numbers in the collection should be divided.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collection would contain duplicates when they're not allowed.
     */
    boolean divide(N divisor) throws IllegalArgumentException;

    /**
     * Multiplies all the numbers in the collection with the multiplicand and returns whether any of the numbers were
     * changed. Ignores <code>null</code> elements.
     *
     * @param multiplicand The number by which all numbers in the collection should be multiplied.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collection would contain duplicates when they're not allowed.
     */
    boolean multiply(N multiplicand) throws IllegalArgumentException;

    /**
     * Negates all the numbers in the collection and returns whether any of the numbers were changed. Ignores
     * <code>null</code> elements.
     *
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collection would contain duplicates when they're not allowed.
     */
    boolean negate() throws IllegalArgumentException;

    /**
     * Subtracts all the numbers in the collection with the subtrahend and returns whether any of the numbers were
     * changed. Ignores <code>null</code> elements.
     *
     * @param subtrahend The number that should be subtracted from all numbers in the collection.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collection would contain duplicates when they're not allowed.
     */
    boolean subtract(N subtrahend) throws IllegalArgumentException;
}
