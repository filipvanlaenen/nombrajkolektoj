package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.Doubles.AbstractDoubleMap} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} implementation.
 */
public class AbstractDoubleMapTest {
    /**
     * The magic number three.
     */
    private static final Double THREE = 3D;
    /**
     * The magic number four.
     */
    private static final Double FOUR = 4D;
    /**
     * The magic number six.
     */
    private static final Double SIX = 6D;
    /**
     * The magic number ten.
     */
    private static final Double TEN = 10D;
    /**
     * The magic number twenty-four.
     */
    private static final Double TWENTY_FOUR = 24D;
    /**
     * Map with the doubles 1, 2, 3 and 4.
     */
    private static final DoubleMap<String> MAP1234 =
            DoubleMap.of("one", 1D, "two", Double.valueOf(2L), "three", THREE, "four", FOUR);
    /**
     * Map with the doubles 1, 2 and 3 and <code>null</code>.
     */
    private static final DoubleMap<String> MAP123NULL =
            DoubleMap.of("one", 1D, "two", Double.valueOf(2L), "three", THREE, null, null);
    /**
     * Map with <code>null</code>.
     */
    private static final DoubleMap<String> MAP_NULL = DoubleMap.of(new Entry<String, Double>(null, null));

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
        assertEquals(1D, MAP1234.min());
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
        assertEquals(1D, MAP123NULL.min());
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
        assertEquals(1D, MAP_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0D, MAP_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> DoubleMap.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> DoubleMap.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1D, DoubleMap.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0D, DoubleMap.empty().sum());
    }
}
