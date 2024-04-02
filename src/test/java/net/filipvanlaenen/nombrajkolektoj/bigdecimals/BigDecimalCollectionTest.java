package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bigdecimals.BigDecimalCollection} class.
 */
public class BigDecimalCollectionTest {
    /**
     * The magic number two.
     */
    private static final BigDecimal TWO = BigDecimal.valueOf(2L);
    /**
     * The magic number three.
     */
    private static final BigDecimal THREE = BigDecimal.valueOf(3L);
    /**
     * The magic number three (int).
     */
    private static final int THREE_INT = 3;
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private static final BigDecimalCollection COLLECTION123 = BigDecimalCollection.of(BigDecimal.ONE, TWO, THREE);

    /**
     * Verifies that an empty BigDecimals collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigDecimalsCollection() {
        assertTrue(BigDecimalCollection.empty().isEmpty());
    }

    /**
     * Verifies that a BigDecimals collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnABigDecimalsCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS,
                BigDecimalCollection.of(DISTINCT_ELEMENTS, BigDecimal.ONE).getElementCardinality());
    }

    /**
     * Verifies that a BigDecimals collection created from another collection has the same element cardinality and
     * integers.
     */
    @Test
    public void ofWithCollectionShouldReturnABigDecimalsCollectionWithTheSameElementCardinalityAndDoubles() {
        Collection<BigDecimal> source = Collection.of(DISTINCT_ELEMENTS, BigDecimal.ONE);
        BigDecimalCollection actual = new BigDecimalCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(BigDecimal.ONE));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(BigDecimal.ONE));
        assertFalse(COLLECTION123.contains(BigDecimal.ZERO));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(BigDecimalCollection.of(BigDecimal.ONE)));
        assertFalse(COLLECTION123.containsAll(BigDecimalCollection.of(BigDecimal.ZERO)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(COLLECTION123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE_INT, COLLECTION123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE_INT, COLLECTION123.toArray().length);
    }
}
