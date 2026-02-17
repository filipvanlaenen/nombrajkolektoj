package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedBigDecimalCollectionTestBase<T extends OrderedNumericCollection<BigDecimal>>
        extends BigDecimalCollectionTestBase<T> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);

    /**
     * Creates an ordered BigDecimals collection containing the provided BigDecimals.
     *
     * @param numbers The BigDecimals to be included in the ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(BigDecimal... numbers);

    /**
     * Creates an ordered BigDecimals collection containing the provided BigDecimals.
     *
     * @param source The BigDecimals to be included in the ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(OrderedNumericCollection<BigDecimal> source);

    /**
     * Creates an ordered BigDecimals collection containing the provided range of BigDecimals.
     *
     * @param source    The BigDecimals to be included in the ordered BigDecimals collection.
     * @param fromIndex The index of the first element to be included in the new ordered BigDecimals collection.
     * @param toIndex   The index of the first element not to be included in the new ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided range of BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(OrderedNumericCollection<BigDecimal> source, final int fromIndex,
            final int toIndex);

    /**
     * Creates an ordered BigDecimals collection containing the provided BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals to be included in the ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(ElementCardinality elementCardinality, BigDecimal... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).firstIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).indexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).lastIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that an ordered BigDecimals collection created from another ordered collection has the same element
     * cardinality and BigDecimals in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnABigDecimalCollectionWithTheSameElementCardinalityAndBigDecimals() {
        T source = createOrderedBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        T actual = createOrderedBigDecimalCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigDecimal[] {BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered BigDecimals collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigDecimals in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR);
        T actual = createOrderedBigDecimalCollection(source, 1, 3);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigDecimal[] {BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }
}
