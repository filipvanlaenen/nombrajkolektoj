package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedShortCollectionTestBase<T extends OrderedNumericCollection<Short>>
        extends ShortCollectionTestBase<T> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;

    /**
     * Creates an ordered shorts collection containing the provided shorts.
     *
     * @param numbers The shorts to be included in the ordered shorts collection.
     * @return An ordered shorts collection containing the provided shorts.
     */
    protected abstract T createOrderedShortCollection(Short... numbers);

    /**
     * Creates an ordered shorts collection containing the provided shorts.
     *
     * @param source The shorts to be included in the ordered shorts collection.
     * @return An ordered shorts collection containing the provided shorts.
     */
    protected abstract T createOrderedShortCollection(OrderedNumericCollection<Short> source);

    /**
     * Creates an ordered shorts collection containing the provided range of shorts.
     *
     * @param source    The shorts to be included in the ordered shorts collection.
     * @param fromIndex The index of the first element to be included in the new ordered shorts collection.
     * @param toIndex   The index of the first element not to be included in the new ordered shorts collection.
     * @return An ordered shorts collection containing the provided range of shorts.
     */
    protected abstract T createOrderedShortCollection(OrderedNumericCollection<Short> source, final int fromIndex,
            final int toIndex);

    /**
     * Creates an ordered shorts collection containing the provided shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts to be included in the ordered shorts collection.
     * @return An ordered shorts collection containing the provided shorts.
     */
    protected abstract T createOrderedShortCollection(ElementCardinality elementCardinality, Short... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).firstIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).indexOf((short) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).lastIndexOf((short) 2));
    }

    /**
     * Verifies that an ordered shorts collection created from another ordered collection has the same element
     * cardinality and shorts in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnAShortCollectionWithTheSameElementCardinalityAndShorts() {
        T source = createOrderedShortCollection(DISTINCT_ELEMENTS, (short) 1, (short) 2, SHORT_THREE);
        T actual = createOrderedShortCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Short[] {(short) 1, (short) 2, SHORT_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered shorts collection created as a slice from another ordered collection has the same
     * element cardinality and the correct shorts in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedShortCollection(DISTINCT_ELEMENTS, (short) 1, (short) 2, SHORT_THREE, SHORT_FOUR);
        T actual = createOrderedShortCollection(source, 1, 3);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Short[] {(short) 2, SHORT_THREE}, actual.toArray());
    }
}
