package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigDecimalCollectionTestBase<T extends NumericCollection<BigDecimal>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final NumericCollection<BigDecimal> collection123 = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    /**
     * Creates an empty BigDecimals collection.
     *
     * @return An empty BigDecimals collection.
     */
    protected abstract T createEmptyBigDecimalCollection();

    /**
     * Creates a BigDecimals collection from a collection of BigDecimals.
     *
     * @param source The collection of BigDecimals.
     * @return A BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createBigDecimalCollection(NumericCollection<BigDecimal> source);

    /**
     * Creates a BigDecimals collection with the provided element cardinality containing the provided BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals to be included in the BigDecimals collection.
     * @return A BigDecimals collection with the provided element cardinality containing the provided BigDecimals.
     */
    protected abstract T createBigDecimalCollection(ElementCardinality elementCardinality, BigDecimal... numbers);

    /**
     * Creates a BigDecimals collection containing the provided BigDecimals.
     *
     * @param numbers The BigDecimals to be included in the BigDecimals collection.
     * @return An BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createBigDecimalCollection(BigDecimal... numbers);

    /**
     * Verifies that an empty BigDecimals collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigDecimalCollection() {
        assertTrue(createEmptyBigDecimalCollection().isEmpty());
    }

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
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(BigDecimal.ONE));
        assertFalse(collection123.contains(BigDecimal.ZERO));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertFalse(collection123.containsAll(createBigDecimalCollection(BigDecimal.ZERO)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(collection123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.toArray().length);
    }
}
