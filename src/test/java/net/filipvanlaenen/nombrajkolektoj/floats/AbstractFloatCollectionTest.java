package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.floats.AbstractFloatCollection} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} implementation.
 */
public class AbstractFloatCollectionTest {
    /**
     * The magic number three.
     */
    private static final float THREE = 3F;
    /**
     * The magic number four.
     */
    private static final float FOUR = 4F;
    /**
     * The magic number six.
     */
    private static final float SIX = 6F;
    /**
     * The magic number ten.
     */
    private static final float TEN = 10F;
    /**
     * The magic number twenty-four.
     */
    private static final float TWENTY_FOUR = 24F;
    /**
     * Collection with the floats 1, 2, 3 and 4.
     */
    private static final FloatCollection COLLECTION1234 = FloatCollection.of(1F, 2F, THREE, FOUR);
    /**
     * Collection with the floats 1, 2 and 3 and <code>null</code>.
     */
    private static final FloatCollection COLLECTION123NULL = FloatCollection.of(1F, 2F, THREE, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final FloatCollection COLLECTION_NULL = FloatCollection.of(new Float[] {null});

    /**
     * Verifies that <code>max</code> returns the largest float in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestFloat() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest float in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestFloat() {
        assertEquals(1F, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the floats in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheFloats() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the floats in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheFloats() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest float in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestFloat() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest float in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestFloat() {
        assertEquals(1F, COLLECTION123NULL.min());
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
        assertEquals(1F, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0F, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> FloatCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> FloatCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1F, FloatCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0F, FloatCollection.empty().sum());
    }
}
