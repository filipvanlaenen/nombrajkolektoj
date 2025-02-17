package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.floats.AbstractFloatMap} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} implementation.
 */
public class AbstractFloatMapTest {
    /**
     * The magic number three.
     */
    private static final Float THREE = 3F;
    /**
     * The magic number four.
     */
    private static final Float FOUR = 4F;
    /**
     * The magic number six.
     */
    private static final Float SIX = 6F;
    /**
     * The magic number ten.
     */
    private static final Float TEN = 10F;
    /**
     * The magic number twenty-four.
     */
    private static final Float TWENTY_FOUR = 24F;
    /**
     * Map with the floats 1, 2, 3 and 4.
     */
    private static final FloatMap<String> MAP1234 = FloatMap.of("one", 1F, "two", 2F, "three", THREE, "four", FOUR);
    /**
     * Map with the floats 1, 2 and 3 and <code>null</code>.
     */
    private static final FloatMap<String> MAP123NULL = FloatMap.of("one", 1F, "two", 2F, "three", THREE, null, null);
    /**
     * Map with <code>null</code>.
     */
    private static final FloatMap<String> MAP_NULL = FloatMap.of(new Entry<String, Float>(null, null));

    /**
     * Verifies that <code>max</code> returns the largest number in the map.
     */
    @Test
    public void maxShouldReturnTheLargestNumber() {
        assertEquals(FOUR, MAP1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest number in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestNumber() {
        assertEquals(1F, MAP1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the numbers in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheNumbers() {
        assertEquals(TWENTY_FOUR, MAP1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the numbers in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheNumbers() {
        assertEquals(TEN, MAP1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest number in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestNumber() {
        assertEquals(THREE, MAP123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest number in the collection even when there are
     * <code>null</code> elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestNumber() {
        assertEquals(1F, MAP123NULL.min());
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
        assertEquals(1F, MAP_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0F, MAP_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> FloatMap.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> FloatMap.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1F, FloatMap.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0F, FloatMap.empty().sum());
    }
}
