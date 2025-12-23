package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.AbstractModifiableOrderedByteCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableOrderedByteCollection}
 * implementation.
 */
public class AbstractModifiableOrderedByteCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The magic number four.
     */
    private static final int FOUR = 4;
    /**
     * The magic number three.
     */
    private static final byte BYTE_THREE = (byte) 3;
    /**
     * The magic number four.
     */
    private static final byte BYTE_FOUR = (byte) 4;
    /**
     * The magic number five.
     */
    private static final byte BYTE_FIVE = (byte) 5;
    /**
     * The magic number six.
     */
    private static final byte BYTE_SIX = (byte) 6;
    /**
     * The magic number seven.
     */
    private static final byte BYTE_SEVEN = (byte) 7;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedByteCollection createCollection1234() {
        return ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, BYTE_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedByteCollection createDistinctCollection1234() {
        return ModifiableOrderedByteCollection.of(ElementCardinality.DISTINCT_ELEMENTS, (byte) 1, (byte) 2, BYTE_THREE,
                BYTE_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedByteCollection createCollection123Null() {
        return ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals((byte) 2, createCollection1234().augment(1, BYTE_FIVE));
    }

    /**
     * Verifies that augment with an index returns <code>null</code> when called with <code>null</code> and an index
     * holding the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginalNullWhenCalledWithNullValue() {
        assertNull(createCollection123Null().augment(THREE, null));
    }

    /**
     * Verifies that augment with an index augments the number in the collection correctly.
     */
    @Test
    public void augmentWithIndexShouldAugmentNumberCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.augment(1, BYTE_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedByteCollection.of((byte) 1, BYTE_SEVEN, BYTE_THREE, BYTE_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, BYTE_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, BYTE_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedByteCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, (byte) 1));
        assertEquals(
                "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals((byte) 2, createCollection1234().multiply(1, BYTE_FIVE));
    }

    /**
     * Verifies that multiply with an index returns <code>null</code> when called with <code>null</code> and an index
     * holding the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginalNullWhenCalledWithNullValue() {
        assertNull(createCollection123Null().multiply(THREE, null));
    }

    /**
     * Verifies that multiply with an index multiplies the number in the collection correctly.
     */
    @Test
    public void multiplyWithIndexShouldAugmentNumberCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.multiply(1, BYTE_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedByteCollection.of((byte) 1, BYTE_SIX, BYTE_THREE, BYTE_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, BYTE_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, BYTE_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedByteCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, (byte) 2));
        assertEquals(
                "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }
}
