package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.shorts.AbstractShortCollection} class. The class
 * is tested through the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} implementation.
 */
public class AbstractShortCollectionTest {
    /**
     * The magic number three.
     */
    private static final short THREE = (short) 3;
    /**
     * The magic number four.
     */
    private static final short FOUR = (short) 4;
    /**
     * The magic number six.
     */
    private static final short SIX = (short) 6;
    /**
     * The magic number ten.
     */
    private static final short TEN = (short) 10;
    /**
     * The magic number twenty-four.
     */
    private static final short TWENTY_FOUR = (short) 24;
    /**
     * Collection with the shorts 1, 2, 3 and 4.
     */
    private static final ShortCollection COLLECTION1234 =
            ShortCollection.of((short) 1, (short) 2, (short) 3, (short) 4);
    /**
     * Collection with the shorts 1, 2 and 3 and <code>null</code>.
     */
    private static final ShortCollection COLLECTION123NULL = ShortCollection.of((short) 1, (short) 2, (short) 3, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final ShortCollection COLLECTION_NULL = ShortCollection.of(new Short[] {null});

    /**
     * Verifies that <code>max</code> returns the largest Short in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestShort() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest Short in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestShort() {
        assertEquals((short) 1, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the Shorts in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheShorts() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the Shorts in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheShorts() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest Short in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestShort() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest Short in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestShort() {
        assertEquals((short) 1, COLLECTION123NULL.min());
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
        assertEquals((short) 1, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals((short) 0, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ShortCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ShortCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals((short) 1, ShortCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals((short) 0, ShortCollection.empty().sum());
    }
}
