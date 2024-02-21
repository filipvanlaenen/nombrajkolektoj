package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Interface defining the signature for all numeric collections.
 *
 * @param <N> The element type.
 */
public interface NumericCollection<N extends Number> extends Collection<N> {
    /**
     * Returns the largest number in the collection. Ignores <code>null</code> elements, but returns <code>null</code>
     * if the collection contains <code>null</code> elements only. Throws an exception if the collection is empty.
     *
     * @return The largest number in the collection, or <code>null</code> if the collection contains <code>null</code>
     *         elements only.
     * @throws IndexOutOfBoundsException Thrown if the collection is empty.
     */
    N max() throws IndexOutOfBoundsException;

    /**
     * Returns the smallest number in the collection. Ignores <code>null</code> elements, but returns <code>null</code>
     * if the collection contains <code>null</code> elements only. Throws an exception if the collection is empty.
     *
     * @return The smallest number in the collection, or <code>null</code> if the collection contains <code>null</code>
     *         elements only.
     * @throws IndexOutOfBoundsException Thrown if the collection is empty.
     */
    N min() throws IndexOutOfBoundsException;

    /**
     * Returns the product of the numbers in the collection, or one if the collection is empty. Ignores
     * <code>null</code> elements, but returns <code>null</code> if the collection contains <code>null</code> elements
     * only.
     *
     * @return The product of the numbers in the collection, one if the collection is empty, or <code>null</code> if the
     *         collection contains <code>null</code> elements only.
     */
    N product();

    /**
     * Returns the sum of the numbers in the collection, or zero if the collection is empty. Ignores <code>null</code>
     * elements, but returns <code>null</code> if the collection contains <code>null</code> elements only.
     *
     * @return The sum of the numbers in the collection, zero if the collection is empty, or <code>null</code> if the
     *         collection contains <code>null</code> elements only.
     */
    N sum();
}
