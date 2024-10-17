package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bytes.AbstractLongMap} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} implementation.
 */
public class AbstractByteMapTest {
    /**
     * The magic number three.
     */
    private static final Byte THREE = (byte) 3;
    /**
     * The magic number four.
     */
    private static final Byte FOUR = (byte) 4;
    /**
     * The magic number six.
     */
    private static final Byte SIX = (byte) 6;
    /**
     * The magic number ten.
     */
    private static final Byte TEN = (byte) 10;
    /**
     * The magic number twenty-four.
     */
    private static final Byte TWENTY_FOUR = (byte) 24;
    /**
     * Map with the bytes 1, 2, 3 and 4.
     */
    private static final ByteMap<String> MAP1234 = ByteMap.of("one", (byte) 1, "two", (byte) 2, "three", THREE, "four", FOUR);
    /**
     * Map with the bytes 1, 2 and 3 and <code>null</code>.
     */
    private static final ByteMap<String> MAP123NULL = ByteMap.of("one", (byte) 1, "two", (byte) 2, "three", THREE, null, null);
    /**
     * Map with <code>null</code>.
     */
    private static final ByteMap<String> MAP_NULL = ByteMap.of(new Entry<String, Byte>(null, null));

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
        assertEquals((byte) 1, MAP1234.min());
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
        assertEquals((byte) 1, MAP123NULL.min());
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
        assertEquals((byte) 1, MAP_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals((byte) 0, MAP_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ByteMap.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ByteMap.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals((byte) 1, ByteMap.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals((byte) 0, ByteMap.empty().sum());
    }
}
