package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;

/**
 * Interface defining the signature for all modifiable ordered numeric collections.
 *
 * @param <N> The element type.
 */
public interface ModifiableOrderedNumericCollection<N extends Number>
        extends ModifiableNumericCollection<N>, OrderedNumericCollection<N>, ModifiableOrderedCollection<N> {
    /**
     * Augments the number at a given position in this collection and returns the original value.
     *
     * @param index  The position that should be augmented.
     * @param addend The number by which the number at the given position should be augmented.
     * @return The original value that has been overwritten.
     * @throws IllegalArgumentException  Thrown if the resulting number at the given position would result into
     *                                   duplicates when they're not allowed.
     * @throws IndexOutOfBoundsException Thrown if the index is out of bounds.
     * @throws NullPointerException      Thrown if the original value at the given position is <code>null</code>.
     */
    N augment(int index, N addend) throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException;

    /**
     * Augments the numbers in this collection with each of the numbers in the other collection and returns whether any
     * of the numbers were changed.
     *
     * @param addends The numbers by which the numbers in this collection should be augmented.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collections are not of the same size, or if the resulting numbers
     *                                  would result into duplicates when they're not allowed.
     * @throws NullPointerException     Thrown a <code>null</code> in one collection isn't matched by a
     *                                  <code>null</code> in the other collection.
     */
    boolean augment(OrderedNumericCollection<N> addends)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException;

    /**
     * Multiplies the number at a given position in this collection and returns the original value.
     *
     * @param index        The position that should be multiplied.
     * @param multiplicand The number by which the number at the given position should be multiplied.
     * @return The original value that has been overwritten.
     * @throws IllegalArgumentException  Thrown if the resulting number at the given position would result into
     *                                   duplicates when they're not allowed.
     * @throws IndexOutOfBoundsException Thrown if the index is out of bounds.
     * @throws NullPointerException      Thrown if the original value at the given position is <code>null</code>.
     */
    N multiply(int index, N multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException;

    /**
     * Multiplies the numbers in this collection with each of the numbers in the other collection and returns whether
     * any of the numbers were changed.
     *
     * @param multiplicands The numbers by which the numbers in this collection should be multiplied.
     * @return True if any of the numbers in the collection was changed.
     * @throws IllegalArgumentException Thrown if the collections are not of the same size, or if the resulting numbers
     *                                  would result into duplicates when they're not allowed.
     * @throws NullPointerException     Thrown a <code>null</code> in one collection isn't matched by a
     *                                  <code>null</code> in the other collection.
     */
    boolean multiply(OrderedNumericCollection<N> multiplicands)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException;

    /**
     * Negates the number at a given position in this collection and returns the original value.
     *
     * @param index The position that should be negated.
     * @return The original value that has been overwritten.
     * @throws IllegalArgumentException  Thrown if the resulting number at the given position would result into
     *                                   duplicates when they're not allowed.
     * @throws IndexOutOfBoundsException Thrown if the index is out of bounds.
     * @throws NullPointerException      Thrown if the original value at the given position is <code>null</code>.
     */
    N negate(int index) throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException;
}
