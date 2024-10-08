package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.doubles.AbstractDoubleCollection} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} implementation.
 */
public class AbstractDoubleCollectionTest {
    /**
     * The magic number three.
     */
    private static final double THREE = 3D;
    /**
     * The magic number four.
     */
    private static final double FOUR = 4D;
    /**
     * The magic number six.
     */
    private static final double SIX = 6D;
    /**
     * The magic number ten.
     */
    private static final double TEN = 10D;
    /**
     * The magic number twenty-four.
     */
    private static final double TWENTY_FOUR = 24D;
    /**
     * Collection with the doubles 1, 2, 3 and 4.
     */
    private static final DoubleCollection COLLECTION1234 = DoubleCollection.of(1D, 2D, 3D, 4D);
    /**
     * Collection with the doubles 1, 2 and 3 and <code>null</code>.
     */
    private static final DoubleCollection COLLECTION123NULL = DoubleCollection.of(1D, 2D, 3D, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final DoubleCollection COLLECTION_NULL = DoubleCollection.of(new Double[] {null});

    /**
     * Verifies that <code>max</code> returns the largest double in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestDouble() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest double in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestDouble() {
        assertEquals(1D, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the doubles in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheDoubles() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the doubles in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheDoubles() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest double in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestDouble() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest double in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestDouble() {
        assertEquals(1D, COLLECTION123NULL.min());
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
        assertEquals(1D, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0D, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> DoubleCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> DoubleCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1D, DoubleCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0D, DoubleCollection.empty().sum());
    }
}
