package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bytes.AbstractByteCollection} class. The class
 * is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} implementation.
 */
public class AbstractByteCollectionTest {
    /**
     * The magic number three.
     */
    private static final byte THREE = (byte) 3;
    /**
     * The magic number four.
     */
    private static final byte FOUR = (byte) 4;
    /**
     * The magic number six.
     */
    private static final byte SIX = (byte) 6;
    /**
     * The magic number ten.
     */
    private static final byte TEN = (byte) 10;
    /**
     * The magic number twenty-four.
     */
    private static final byte TWENTY_FOUR = (byte) 24;
    /**
     * Collection with the bytes 1, 2, 3 and 4.
     */
    private static final ByteCollection COLLECTION1234 =
            ByteCollection.of((byte) 1, (byte) 2, (byte) 3, (byte) 4);
    /**
     * Collection with the bytes 1, 2 and 3 and <code>null</code>.
     */
    private static final ByteCollection COLLECTION123NULL = ByteCollection.of((byte) 1, (byte) 2, (byte) 3, null);
    /**
     * Collection with <code>null</code>.
     */
    private static final ByteCollection COLLECTION_NULL = ByteCollection.of(new Byte[] {null});

    /**
     * Verifies that <code>max</code> returns the largest Byte in the collection.
     */
    @Test
    public void maxShouldReturnTheLargestByte() {
        assertEquals(FOUR, COLLECTION1234.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest Byte in the collection.
     */
    @Test
    public void minShouldReturnTheSmallestByte() {
        assertEquals((byte) 1, COLLECTION1234.min());
    }

    /**
     * Verifies that <code>product</code> returns the product of the Bytes in the collection.
     */
    @Test
    public void productShouldReturnTheProductOfTheBytes() {
        assertEquals(TWENTY_FOUR, COLLECTION1234.product());
    }

    /**
     * Verifies that <code>sum</code> returns the sum of the Bytes in the collection.
     */
    @Test
    public void sumShouldReturnTheSumOfTheBytes() {
        assertEquals(TEN, COLLECTION1234.sum());
    }

    /**
     * Verifies that <code>max</code> returns the largest Byte in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void maxShouldIgnoreNullAndReturnTheLargestByte() {
        assertEquals(THREE, COLLECTION123NULL.max());
    }

    /**
     * Verifies that <code>min</code> returns the smallest Byte in the collection even when there are <code>null</code>
     * elements in the collection.
     */
    @Test
    public void minShouldIgnoreNullAndReturnTheSmallestByte() {
        assertEquals((byte) 1, COLLECTION123NULL.min());
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
        assertEquals((byte) 1, COLLECTION_NULL.product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection only contains <code>null</code>.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionContainsOnlyNull() {
        assertEquals((byte) 0, COLLECTION_NULL.sum());
    }

    /**
     * Verifies that <code>max</code> throws an exception when called on an empty collection.
     */
    @Test
    public void maxShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ByteCollection.empty().max());
        assertEquals("Cannot return a maximum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>min</code> throws an exception when called on an empty collection.
     */
    @Test
    public void minShouldThrowExceptionWhenCalledOnAnEmptyCollection() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> ByteCollection.empty().min());
        assertEquals("Cannot return a minimum for an empty collection.", exception.getMessage());
    }

    /**
     * Verifies that <code>product</code> returns one if the collection is empty.
     */
    @Test
    public void productShouldReturnOneIfTheCollectionIsEmpty() {
        assertEquals((byte) 1, ByteCollection.empty().product());
    }

    /**
     * Verifies that <code>sum</code> returns zero if the collection is empty.
     */
    @Test
    public void sumShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals((byte) 0, ByteCollection.empty().sum());
    }
}
