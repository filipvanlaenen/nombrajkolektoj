package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.AbstractModifiableOrderedFloatCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableOrderedFloatCollection}
 * implementation.
 */
public class AbstractModifiableOrderedFloatCollectionTest {
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
    private static final float FLOAT_THREE = 3F;
    /**
     * The magic number four.
     */
    private static final float FLOAT_FOUR = 4F;
    /**
     * The magic number five.
     */
    private static final float FLOAT_FIVE = 5F;
    /**
     * The magic number six.
     */
    private static final float FLOAT_SIX = 6F;
    /**
     * The magic number seven.
     */
    private static final float FLOAT_SEVEN = 7F;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedFloatCollection createCollection1234() {
        return ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, FLOAT_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedFloatCollection createDistinctCollection1234() {
        return ModifiableOrderedFloatCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE,
                FLOAT_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedFloatCollection createCollection123Null() {
        return ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(2F, createCollection1234().augment(1, FLOAT_FIVE));
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
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.augment(1, FLOAT_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedFloatCollection.of(1F, FLOAT_SEVEN, FLOAT_THREE, FLOAT_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, FLOAT_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, FLOAT_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedFloatCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, 1F));
        assertEquals(
                "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(2F, createCollection1234().multiply(1, FLOAT_FIVE));
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
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.multiply(1, FLOAT_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedFloatCollection.of(1F, FLOAT_SIX, FLOAT_THREE, FLOAT_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, FLOAT_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, FLOAT_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedFloatCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, 2F));
        assertEquals(
                "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }
}
