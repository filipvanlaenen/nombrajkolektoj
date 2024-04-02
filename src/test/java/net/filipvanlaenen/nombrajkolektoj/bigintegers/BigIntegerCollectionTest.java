package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.BigIntegerCollection} class.
 */
public class BigIntegerCollectionTest {
    /**
     * The magic number two.
     */
    private static final BigInteger TWO = BigInteger.valueOf(2L);
    /**
     * The magic number three.
     */
    private static final BigInteger THREE = BigInteger.valueOf(3L);
    /**
     * The magic number three (int).
     */
    private static final int THREE_INT = 3;
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private static final BigIntegerCollection COLLECTION123 = BigIntegerCollection.of(BigInteger.ONE, TWO, THREE);

    /**
     * Verifies that an empty BigIntegers collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigIntegersCollection() {
        assertTrue(BigIntegerCollection.empty().isEmpty());
    }

    /**
     * Verifies that a BigIntegers collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnABigIntegersCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS,
                BigIntegerCollection.of(DISTINCT_ELEMENTS, BigInteger.ONE).getElementCardinality());
    }

    /**
     * Verifies that a BigIntegers collection created from another collection has the same element cardinality and
     * integers.
     */
    @Test
    public void ofWithCollectionShouldReturnABigIntegersCollectionWithTheSameElementCardinalityAndBigIntegers() {
        Collection<BigInteger> source = Collection.of(DISTINCT_ELEMENTS, BigInteger.ONE);
        BigIntegerCollection actual = new BigIntegerCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(BigInteger.ONE));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(BigInteger.ONE));
        assertFalse(COLLECTION123.contains(BigInteger.ZERO));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(BigIntegerCollection.of(BigInteger.ONE)));
        assertFalse(COLLECTION123.containsAll(BigIntegerCollection.of(BigInteger.ZERO)));
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
