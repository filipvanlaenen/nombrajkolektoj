package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.AbstractBigIntegerMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bigintegers.BigIntegerMap} implementation.
 */
public class AbstractBigIntegerMapTest {
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
     * Map with the BigIntegers 1, 2, 3 and 4.
     */
    private static final BigIntegerMap<String> MAP1234 =
            BigIntegerMap.of("one", BigInteger.ONE, "two", BigInteger.valueOf(2L), "three", THREE, "four", FOUR);
    /**
     * Map with the BigIntegers 1, 2 and 3 and <code>null</code>.
     */
    private static final BigIntegerMap<String> MAP123NULL =
            BigIntegerMap.of("one", BigInteger.ONE, "two", BigInteger.valueOf(2L), "three", THREE, null, null);
    /**
     * Map with <code>null</code>.
     */
    private static final BigIntegerMap<String> MAP_NULL = BigIntegerMap.of(new Entry<String, BigInteger>(null, null));

    /**
     * Verifies that <code>max</code> returns the largest integer in the map.
     */
    @Test
    public void maxShouldReturnTheLargestInteger() {
        assertEquals(FOUR, MAP1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest integer in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestInteger() {
        assertEquals(BigInteger.ONE, MAP1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the integers in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheIntegers() {
        assertEquals(TWENTY_FOUR, MAP1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the integers in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheIntegers() {
        assertEquals(TEN, MAP1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest integer in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestInteger() {
        assertEquals(THREE, MAP123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest integer in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestInteger() {
        assertEquals(BigInteger.ONE, MAP123NULL.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void productShouldIgnoreNullAndReturnTheProduct() {
        assertEquals(SIX, MAP123NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the collection even when there are <code>null</code> elements
     * in the collection.
     */
    @Test
    public void sumShouldIgnoreNullAndReturnTheSum() {
        assertEquals(SIX, MAP123NULL.sum());
    }

    /**
     * Verifies that <code>max</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void maxShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(MAP_NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void minShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(MAP_NULL.min());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection only contains <code>null</code>.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionContainsOnlyNull() {
        assertEquals(BigInteger.ONE, MAP_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(BigInteger.ZERO, MAP_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigIntegerMap.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> BigIntegerMap.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(BigInteger.ONE, BigIntegerMap.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(BigInteger.ZERO, BigIntegerMap.empty().sum());
    }
}
