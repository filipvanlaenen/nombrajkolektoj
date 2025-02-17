package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.integers.AbstractIntegerMap} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} implementation.
 */
public class AbstractIntegerMapTest {
    /**
     * The magic number three.
     */
    private static final Integer THREE = 3;
    /**
     * The magic number four.
     */
    private static final Integer FOUR = 4;
    /**
     * The magic number six.
     */
    private static final Integer SIX = 6;
    /**
     * The magic number ten.
     */
    private static final Integer TEN = 10;
    /**
     * The magic number twenty-four.
     */
    private static final Integer TWENTY_FOUR = 24;
    /**
     * Map with the integers 1, 2, 3 and 4.
     */
    private static final IntegerMap<String> MAP1234 = IntegerMap.of("one", 1, "two", 2, "three", THREE, "four", FOUR);
    /**
     * Map with the integers 1, 2 and 3 and <code>null</code>.
     */
    private static final IntegerMap<String> MAP123NULL = IntegerMap.of("one", 1, "two", 2, "three", THREE, null, null);
    /**
     * Map with <code>null</code>.
     */
    private static final IntegerMap<String> MAP_NULL = IntegerMap.of(new Entry<String, Integer>(null, null));

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
        assertEquals(1, MAP1234.min());
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
        assertEquals(1, MAP123NULL.min());
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
        assertEquals(1, MAP_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals(0, MAP_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> IntegerMap.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> IntegerMap.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals(1, IntegerMap.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0, IntegerMap.empty().sum());
    }
}
