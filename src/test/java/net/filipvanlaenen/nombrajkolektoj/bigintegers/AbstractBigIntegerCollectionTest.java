package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.AbstractBigIntegerCollection} class.
 * The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.BigIntegerCollection}
 * implementation.
 */
public class AbstractBigIntegerCollectionTest {
    /**
     * The magic number two.
     */
    private static final BigInteger TWO = BigInteger.valueOf(2L);
    /**
     * The magic number three.
     */
    private static final BigInteger THREE = BigInteger.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigInteger FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number six.
     */
    private static final BigInteger SIX = BigInteger.valueOf(6L);
    /**
     * The magic number ten.
     */
    private static final BigInteger TEN = BigInteger.valueOf(10L);
    /**
     * The magic number twenty-four.
     */
    private static final BigInteger TWENTY_FOUR = BigInteger.valueOf(24L);
    /**
     * Collection with the BigIntegers 1, 2, 3 and 4.
     */
    private static final BigIntegerCollection COLLECTION1234 =
            BigIntegerCollection.of(BigInteger.ONE, TWO, THREE, FOUR);
    /**
     * Collection with the BigIntegers 1, 2 and 3 and <code>null</code>.
     */
    private static final BigIntegerCollection COLLECTION123NULL =
            BigIntegerCollection.of(BigInteger.ONE, TWO, THREE, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final BigIntegerCollection COLLECTION_NULL = BigIntegerCollection.of(new BigInteger[] {null});

    /**
     * Verifies that <code>max</code> returns the largest BigInteger in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestBigInteger() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest BigInteger in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestBigInteger() {
        assertEquals(BigInteger.ONE, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the BigIntegers in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheBigIntegers() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the BigIntegers in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheBigIntegers() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest BigInteger in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestBigInteger() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest BigInteger in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestBigInteger() {
        assertEquals(BigInteger.ONE, COLLECTION123NULL.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void productShouldIgnoreNullAndReturnTheProduct() {
        assertEquals(SIX, COLLECTION123NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the collection even when there are <code>null</code> elements
     * in the collection.
     */
    @Test
    public void sumShouldIgnoreNullAndReturnTheSum() {
        assertEquals(SIX, COLLECTION123NULL.sum());
    }

    /**
     * Verifies that <code>max</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void maxShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(COLLECTION_NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void minShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(COLLECTION_NULL.min());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection only contains <code>null</code>.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionContainsOnlyNull() {
        assertEquals(BigInteger.ONE, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(BigInteger.ZERO, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigIntegerCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigIntegerCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(BigInteger.ONE, BigIntegerCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(BigInteger.ZERO, BigIntegerCollection.empty().sum());
    }
}
