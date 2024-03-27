package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.integers.AbstractIntegerCollection} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} implementation.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class AbstractIntegerCollectionTestBase<T extends IntegerCollection> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The magic number four.
     */
    private static final int FOUR = 4;
    /**
     * The magic number six.
     */
    private static final int SIX = 6;
    /**
     * The magic number ten.
     */
    private static final int TEN = 10;
    /**
     * The magic number twenty-four.
     */
    private static final int TWENTY_FOUR = 24;
    /**
     * Collection with the integers 1, 2, 3 and 4.
     */
    private final IntegerCollection collection1234 = createIntegerCollection(1, 2, 3, 4);
    /**
     * Collection with the integers 1, 2 and 3 and <code>null</code>.
     */
    private final IntegerCollection collection123null = createIntegerCollection(1, 2, 3, null);
    /**
     * Collection with <code>null</code>.
     */
    private final IntegerCollection collectionNull = createIntegerCollection(new Integer[] {null});

    /**
     * Creates a collection containing the provided integers.
     *
     * @param integers The integers to be included in the collection.
     * @return A collection containing the provided integers.
     */
    protected abstract T createIntegerCollection(Integer... integers);

    /**
     * Verifies that <code>max</code> returns the largest integer in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestInteger() {
        assertEquals(FOUR, collection1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest integer in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestInteger() {
        assertEquals(1, collection1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the integers in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheIntegers() {
        assertEquals(TWENTY_FOUR, collection1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the integers in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheIntegers() {
        assertEquals(TEN, collection1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest integer in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestInteger() {
        assertEquals(THREE, collection123null.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest integer in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestInteger() {
        assertEquals(1, collection123null.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void productShouldIgnoreNullAndReturnTheProduct() {
        assertEquals(SIX, collection123null.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the collection even when there are <code>null</code> elements
     * in the collection.
     */
    @Test
    public void sumShouldIgnoreNullAndReturnTheSum() {
        assertEquals(SIX, collection123null.sum());
    }

    /**
     * Verifies that <code>max</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void maxShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(collectionNull.max());
    }

    /**
     * Verifies that <code>min</code> returns <code>null</code> if the collection only contains <code>null</code>.
     */
    @Test
    public void minShouldReturnNullIfTheCollectionContainsOnlyNull() {
        assertNull(collectionNull.min());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection only contains <code>null</code>.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionContainsOnlyNull() {
        assertEquals(1, collectionNull.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0, collectionNull.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> createIntegerCollection().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> createIntegerCollection().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1, createIntegerCollection().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0, createIntegerCollection().sum());
    }
}
