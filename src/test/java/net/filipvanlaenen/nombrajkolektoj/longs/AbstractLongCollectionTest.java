package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.longs.AbstractLongCollection} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} implementation.
 */
public class AbstractLongCollectionTest {
    /**
     * The magic number three.
     */
    private static final long THREE = 3L;
    /**
     * The magic number four.
     */
    private static final long FOUR = 4L;
    /**
     * The magic number six.
     */
    private static final long SIX = 6L;
    /**
     * The magic number ten.
     */
    private static final long TEN = 10L;
    /**
     * The magic number twenty-four.
     */
    private static final long TWENTY_FOUR = 24L;
    /**
     * Collection with the longs 1, 2, 3 and 4.
     */
    private static final LongCollection COLLECTION1234 = LongCollection.of(1L, 2L, THREE, FOUR);
    /**
     * Collection with the longs 1, 2 and 3 and <code>null</code>.
     */
    private static final LongCollection COLLECTION123NULL = LongCollection.of(1L, 2L, THREE, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final LongCollection COLLECTION_NULL = LongCollection.of(new Long[] {null});

    /**
     * Verifies that <code>max</code> returns the largest long in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestLong() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest long in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestLong() {
        assertEquals(1L, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the longs in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheLongs() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the longs in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheLongs() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest long in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestLong() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest long in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestLong() {
        assertEquals(1L, COLLECTION123NULL.min());
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
        assertEquals(1L, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0L, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> LongCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> LongCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1L, LongCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0L, LongCollection.empty().sum());
    }
}
