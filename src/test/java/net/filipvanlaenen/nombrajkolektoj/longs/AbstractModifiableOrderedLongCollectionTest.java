package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.longs.AbstractModifiableOrderedLongCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableOrderedLongCollection}
 * implementation.
 */
public class AbstractModifiableOrderedLongCollectionTest {
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
    private static final long LONG_THREE = 3L;
    /**
     * The magic number four.
     */
    private static final long LONG_FOUR = 4L;
    /**
     * The magic number five.
     */
    private static final long LONG_FIVE = 5L;
    /**
     * The magic number six.
     */
    private static final long LONG_SIX = 6L;
    /**
     * The magic number seven.
     */
    private static final long LONG_SEVEN = 7L;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedLongCollection createCollection1234() {
        return ModifiableOrderedLongCollection.of(1L, 2L, LONG_THREE, LONG_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedLongCollection createDistinctCollection1234() {
        return ModifiableOrderedLongCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1L, 2L, LONG_THREE,
                LONG_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedLongCollection createCollection123Null() {
        return ModifiableOrderedLongCollection.of(1L, 2L, LONG_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(2L, createCollection1234().augment(1, LONG_FIVE));
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
        ModifiableOrderedLongCollection collection = createCollection1234();
        collection.augment(1, LONG_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedLongCollection.of(1L, LONG_SEVEN, LONG_THREE, LONG_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedLongCollection.of(1L, 2L, LONG_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedLongCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, LONG_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, LONG_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedLongCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, 1L));
        assertEquals(
                "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(2L, createCollection1234().multiply(1, LONG_FIVE));
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
        ModifiableOrderedLongCollection collection = createCollection1234();
        collection.multiply(1, LONG_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedLongCollection.of(1L, LONG_SIX, LONG_THREE, LONG_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedLongCollection.of(1L, 2L, LONG_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedLongCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, LONG_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedLongCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, LONG_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedLongCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, 2L));
        assertEquals(
                "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }
}
