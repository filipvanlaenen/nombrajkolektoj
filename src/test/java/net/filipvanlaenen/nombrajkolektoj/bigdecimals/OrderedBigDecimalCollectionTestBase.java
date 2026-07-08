package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedBigDecimalCollectionTestBase<T extends OrderedBigDecimalCollection>
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
     * The magic number three.
     */
    private static final int THREE = 3;

    /**
     * Creates an ordered BigDecimals collection containing the provided BigDecimals.
     *
     * @param source The BigDecimals to be included in the ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(T source);

    /**
     * Creates an ordered BigDecimals collection containing the provided range of BigDecimals.
     *
     * @param source    The BigDecimals to be included in the ordered BigDecimals collection.
     * @param fromIndex The index of the first element to be included in the new ordered BigDecimals collection.
     * @param toIndex   The index of the first element not to be included in the new ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided range of BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(T source, int fromIndex, int toIndex);

    /**
     * Creates an ordered BigDecimals collection containing the provided BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals to be included in the ordered BigDecimals collection.
     * @return An ordered BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createOrderedBigDecimalCollection(ElementCardinality elementCardinality, BigDecimal... numbers);

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
        T actual = createOrderedBigDecimalCollection(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigDecimal[] {BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }
}
