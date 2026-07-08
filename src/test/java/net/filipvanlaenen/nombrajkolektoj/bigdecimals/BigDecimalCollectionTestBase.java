package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigDecimalCollectionTestBase<T extends NumericCollection<BigDecimal>> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

    /**
     * Creates a BigDecimals collection with the provided element cardinality containing the provided BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals to be included in the BigDecimals collection.
     * @return A BigDecimals collection with the provided element cardinality containing the provided BigDecimals.
     */
    protected abstract T createBigDecimalCollection(ElementCardinality elementCardinality, BigDecimal... numbers);

    /**
     * Creates a BigDecimals collection from a collection of BigDecimals with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of BigDecimals.
     * @return A BigDecimals collection containing the provided BigDecimals with the provided element cardinality.
     */
    protected abstract T createBigDecimalCollection(ElementCardinality elementCardinality,
            NumericCollection<BigDecimal> source);

    /**
     * Creates a BigDecimals collection from a collection of BigDecimals.
     *
     * @param source The collection of BigDecimals.
     * @return A BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createBigDecimalCollection(NumericCollection<BigDecimal> source);

    /**
     * Verifies that a BigDecimals collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnABigDecimalCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE).getElementCardinality());
    }

    /**
     * Verifies that a BigDecimals collection created from another collection has the same element cardinality and BigDecimals.
     */
    @Test
    public void ofWithCollectionShouldReturnABigDecimalCollectionWithTheSameElementCardinalityAndBigDecimals() {
        BigDecimalCollection source = BigDecimalCollection.of(DISTINCT_ELEMENTS, BigDecimal.ONE);
        T actual = createBigDecimalCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(BigDecimal.ONE));
    }

    /**
     * Verifies that a BigDecimals collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnABigDecimalCollectionWithTheProvidedElementCardinality() {
        BigDecimalCollection source = BigDecimalCollection.of(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        T actual = createBigDecimalCollection(DISTINCT_ELEMENTS, source);
        BigDecimalCollection expected = BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
