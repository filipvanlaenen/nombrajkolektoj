package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * Interface defining the signature for all modifiable numeric collections.
 *
 * @param <N> The element type.
 */
public interface ModifiableNumericCollection<N extends Number> extends NumericCollection<N>, ModifiableCollection<N> {
    /**
     * Augments all the numbers in the collection with the addend and returns whether any of the numbers were changed.
     * Ignores <code>null</code> elements.
     *
     * @param addend The number by which all numbers in the collection should be augmented.
     * @return True if any of the numbers in the collection was changed.
     */
    boolean augment(N addend);

    /**
     * Multiplies all the numbers in the collection with the multiplicand and returns whether any of the numbers were
     * changed. Ignores <code>null</code> elements.
     *
     * @param multiplicand The number by which all numbers in the collection should be multiplied.
     * @return True if any of the numbers in the collection was changed.
     */
    boolean multiply(N multiplicand);

    /**
     * Negates all the numbers in the collection and returns whether any of the numbers were changed. Ignores
     * <code>null</code> elements.
     *
     * @return True if any of the numbers in the collection was changed.
     */
    boolean negate();
}
