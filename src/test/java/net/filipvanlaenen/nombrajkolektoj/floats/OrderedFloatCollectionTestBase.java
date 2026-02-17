package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedFloatCollectionTestBase<T extends OrderedNumericCollection<Float>>
        extends FloatCollectionTestBase<T> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param numbers The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(Float... numbers);

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param numbers The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(OrderedNumericCollection<Float> source);

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(ElementCardinality elementCardinality, Float... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).firstIndexOf(2F));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).indexOf(2F));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).lastIndexOf(2F));
    }

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
}
