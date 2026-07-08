package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedIntegerCollectionTestBase<T extends OrderedIntegerCollection>
        extends IntegerCollectionTestBase<T> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;

    /**
     * Creates an ordered integers collection containing the provided integers.
     *
     * @param source The integers to be included in the ordered integers collection.
     * @return An ordered integers collection containing the provided integers.
     */
    protected abstract T createOrderedIntegerCollection(T source);

    /**
     * Creates an ordered integers collection containing the provided range of integers.
     *
     * @param source    The integers to be included in the ordered integers collection.
     * @param fromIndex The index of the first element to be included in the new ordered integers collection.
     * @param toIndex   The index of the first element not to be included in the new ordered integers collection.
     * @return An ordered integers collection containing the provided range of integers.
     */
    protected abstract T createOrderedIntegerCollection(T source, int fromIndex, int toIndex);

    /**
     * Creates an ordered integers collection containing the provided integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers to be included in the ordered integers collection.
     * @return An ordered integers collection containing the provided integers.
     */
    protected abstract T createOrderedIntegerCollection(ElementCardinality elementCardinality, Integer... numbers);

    /**
     * Verifies that an ordered integers collection created from another ordered collection has the same element
     * cardinality and integers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnAIntegerCollectionWithTheSameElementCardinalityAndIntegers() {
        T source = createOrderedIntegerCollection(DISTINCT_ELEMENTS, 1, 2, INTEGER_THREE);
        T actual = createOrderedIntegerCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Integer[] {1, 2, INTEGER_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered integers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct integers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedIntegerCollection(DISTINCT_ELEMENTS, 1, 2, INTEGER_THREE, INTEGER_FOUR);
        T actual = createOrderedIntegerCollection(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Integer[] {2, INTEGER_THREE}, actual.toArray());
    }
}
