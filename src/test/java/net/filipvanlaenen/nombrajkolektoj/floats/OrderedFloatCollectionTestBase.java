package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedFloatCollectionTestBase<T extends OrderedFloatCollection>
        extends FloatCollectionTestBase<T> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param source The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(T source);

    /**
     * Creates an ordered floats collection containing the provided range of floats.
     *
     * @param source    The floats to be included in the ordered floats collection.
     * @param fromIndex The index of the first element to be included in the new ordered floats collection.
     * @param toIndex   The index of the first element not to be included in the new ordered floats collection.
     * @return An ordered floats collection containing the provided range of floats.
     */
    protected abstract T createOrderedFloatCollection(T source, int fromIndex, int toIndex);

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(ElementCardinality elementCardinality, Float... numbers);

    /**
     * Verifies that an ordered floats collection created from another ordered collection has the same element
     * cardinality and floats in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnAFloatCollectionWithTheSameElementCardinalityAndFloats() {
        T source = createOrderedFloatCollection(DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE);
        T actual = createOrderedFloatCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Float[] {1F, 2F, FLOAT_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered floats collection created as a slice from another ordered collection has the same
     * element cardinality and the correct floats in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedFloatCollection(DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE, FLOAT_FOUR);
        T actual = createOrderedFloatCollection(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Float[] {2F, FLOAT_THREE}, actual.toArray());
    }
}
