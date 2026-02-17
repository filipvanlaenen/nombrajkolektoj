package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedLongCollectionTestBase<T extends OrderedNumericCollection<Long>>
        extends LongCollectionTestBase<T> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;

    /**
     * Creates an ordered longs collection containing the provided longs.
     *
     * @param numbers The longs to be included in the ordered longs collection.
     * @return An ordered longs collection containing the provided longs.
     */
    protected abstract T createOrderedLongCollection(Long... numbers);

    /**
     * Creates an ordered longs collection containing the provided longs.
     *
     * @param source The longs to be included in the ordered longs collection.
     * @return An ordered longs collection containing the provided longs.
     */
    protected abstract T createOrderedLongCollection(OrderedNumericCollection<Long> source);

    /**
     * Creates an ordered longs collection containing the provided range of longs.
     *
     * @param source    The longs to be included in the ordered longs collection.
     * @param fromIndex The index of the first element to be included in the new ordered longs collection.
     * @param toIndex   The index of the first element not to be included in the new ordered longs collection.
     * @return An ordered longs collection containing the provided range of longs.
     */
    protected abstract T createOrderedLongCollection(OrderedNumericCollection<Long> source, final int fromIndex,
            final int toIndex);

    /**
     * Creates an ordered longs collection containing the provided longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs to be included in the ordered longs collection.
     * @return An ordered longs collection containing the provided longs.
     */
    protected abstract T createOrderedLongCollection(ElementCardinality elementCardinality, Long... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).firstIndexOf(2L));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createOrderedLongCollection(1L, 2L, LONG_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedLongCollection(1L, 2L, LONG_THREE).indexOf(2L));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).lastIndexOf(2L));
    }

    /**
     * Verifies that an ordered longs collection created from another ordered collection has the same element
     * cardinality and longs in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnALongCollectionWithTheSameElementCardinalityAndLongs() {
        T source = createOrderedLongCollection(DISTINCT_ELEMENTS, 1L, 2L, LONG_THREE);
        T actual = createOrderedLongCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Long[] {1L, 2L, LONG_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered longs collection created as a slice from another ordered collection has the same
     * element cardinality and the correct longs in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedLongCollection(DISTINCT_ELEMENTS, 1L, 2L, LONG_THREE, LONG_FOUR);
        T actual = createOrderedLongCollection(source, 1, 3);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Long[] {2L, LONG_THREE}, actual.toArray());
    }
}
