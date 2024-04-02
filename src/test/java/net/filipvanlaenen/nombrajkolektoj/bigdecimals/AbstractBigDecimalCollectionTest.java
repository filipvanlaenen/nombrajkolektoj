package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bigdecimals.AbstractBigDecimalCollection} class.
 * The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bigdecimals.BigDecimalCollection}
 * implementation.
 */
public class AbstractBigDecimalCollectionTest {
    /**
     * The magic number two.
     */
    private static final BigDecimal TWO = BigDecimal.valueOf(2L);
    /**
     * The magic number three.
     */
    private static final BigDecimal THREE = BigDecimal.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigDecimal FOUR = BigDecimal.valueOf(4L);
    /**
     * The magic number six.
     */
    private static final BigDecimal SIX = BigDecimal.valueOf(6L);
    /**
     * The magic number ten.
     */
    private static final BigDecimal TEN = BigDecimal.valueOf(10L);
    /**
     * The magic number twenty-four.
     */
    private static final BigDecimal TWENTY_FOUR = BigDecimal.valueOf(24L);
    /**
     * Collection with the doubles 1, 2, 3 and 4.
     */
    private static final BigDecimalCollection COLLECTION1234 =
            BigDecimalCollection.of(BigDecimal.ONE, TWO, THREE, FOUR);
    /**
     * Collection with the doubles 1, 2 and 3 and <code>null</code>.
     */
    private static final BigDecimalCollection COLLECTION123NULL =
            BigDecimalCollection.of(BigDecimal.ONE, TWO, THREE, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final BigDecimalCollection COLLECTION_NULL = BigDecimalCollection.of(new BigDecimal[] {null});

    /**
     * Verifies that <code>max</code> returns the largest BigDecimal in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestBigDecimal() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest BigDecimal in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestBigDecimal() {
        assertEquals(BigDecimal.ONE, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the BigDecimals in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheBigDecimals() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the BigDecimals in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheBigDecimals() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest BigDecimal in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestBigDecimal() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest BigDecimal in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestBigDecimal() {
        assertEquals(BigDecimal.ONE, COLLECTION123NULL.min());
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
        assertEquals(BigDecimal.ONE, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(BigDecimal.ZERO, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigDecimalCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigDecimalCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(BigDecimal.ONE, BigDecimalCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(BigDecimal.ZERO, BigDecimalCollection.empty().sum());
    }
}
