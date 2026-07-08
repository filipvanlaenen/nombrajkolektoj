package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedDoubleCollectionTestBase<T extends OrderedDoubleCollection>
        extends DoubleCollectionTestBase<T> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;

    /**
     * Creates an ordered doubles collection containing the provided doubles.
     *
     * @param source The doubles to be included in the ordered doubles collection.
     * @return An ordered doubles collection containing the provided doubles.
     */
    protected abstract T createOrderedDoubleCollection(T source);

    /**
     * Creates an ordered doubles collection containing the provided range of doubles.
     *
     * @param source    The doubles to be included in the ordered doubles collection.
     * @param fromIndex The index of the first element to be included in the new ordered doubles collection.
     * @param toIndex   The index of the first element not to be included in the new ordered doubles collection.
     * @return An ordered doubles collection containing the provided range of doubles.
     */
    protected abstract T createOrderedDoubleCollection(T source, int fromIndex, int toIndex);

    /**
     * Creates an ordered doubles collection containing the provided doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles to be included in the ordered doubles collection.
     * @return An ordered doubles collection containing the provided doubles.
     */
    protected abstract T createOrderedDoubleCollection(ElementCardinality elementCardinality, Double... numbers);

    /**
     * Verifies that an ordered doubles collection created from another ordered collection has the same element
     * cardinality and doubles in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnADoubleCollectionWithTheSameElementCardinalityAndDoubles() {
        T source = createOrderedDoubleCollection(DISTINCT_ELEMENTS, 1D, 2D, DOUBLE_THREE);
        T actual = createOrderedDoubleCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Double[] {1D, 2D, DOUBLE_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered doubles collection created as a slice from another ordered collection has the same
     * element cardinality and the correct doubles in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedDoubleCollection(DISTINCT_ELEMENTS, 1D, 2D, DOUBLE_THREE, DOUBLE_FOUR);
        T actual = createOrderedDoubleCollection(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Double[] {2D, DOUBLE_THREE}, actual.toArray());
    }
}
