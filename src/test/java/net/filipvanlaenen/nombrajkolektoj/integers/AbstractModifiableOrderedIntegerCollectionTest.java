package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.integers.AbstractModifiableOrderedIntegerCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableOrderedIntegerCollection}
 * implementation.
 */
public class AbstractModifiableOrderedIntegerCollectionTest {
    /**
     * The magic number minus four.
     */
    private static final int MINUS_FOUR = -4;
    /**
     * The magic number minus three.
     */
    private static final int MINUS_THREE = -3;
    /**
     * The magic number minus two.
     */
    private static final int MINUS_TWO = -2;
    /**
     * The magic number minus one.
     */
    private static final int MINUS_ONE = -1;
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
    private static final int INTEGER_THREE = 3;
    /**
     * The magic number four.
     */
    private static final int INTEGER_FOUR = 4;
    /**
     * The magic number five.
     */
    private static final int INTEGER_FIVE = 5;
    /**
     * The magic number six.
     */
    private static final int INTEGER_SIX = 6;
    /**
     * The magic number seven.
     */
    private static final int INTEGER_SEVEN = 7;
    /**
     * The magic number eight.
     */
    private static final int INTEGER_EIGHT = 8;
    /**
     * The magic number nine.
     */
    private static final int INTEGER_NINE = 9;
    /**
     * The magic number sixteen.
     */
    private static final int INTEGER_SIXTEEN = 16;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedIntegerCollection createCollection1234() {
        return ModifiableOrderedIntegerCollection.of(1, 2, INTEGER_THREE, INTEGER_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedIntegerCollection createDistinctCollection1234() {
        return ModifiableOrderedIntegerCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1, 2, INTEGER_THREE,
                INTEGER_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedIntegerCollection createCollection123Null() {
        return ModifiableOrderedIntegerCollection.of(1, 2, INTEGER_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(2, createCollection1234().augment(1, INTEGER_FIVE));
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
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.augment(1, INTEGER_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(1, INTEGER_SEVEN, INTEGER_THREE, INTEGER_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedIntegerCollection.of(1, 2, INTEGER_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, INTEGER_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, INTEGER_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedIntegerCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, 1));
        assertEquals(
                "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with a collection returns true if a change was made.
     */
    @Test
    public void augmentWithCollectionShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().augment(createCollection1234()));
    }

    /**
     * Verifies that augment with a collection returns true if a change was made and <code>null</code> values match
     */
    @Test
    public void augmentWithCollectionShouldReturnTrueWhenChangeDetectedAndMatchingNulls() {
        assertTrue(createCollection123Null().augment(createCollection123Null()));
    }

    /**
     * Verifies that augment with a collection returns false if no change was made.
     */
    @Test
    public void augmentWithCollectionShouldReturnFalseWhenNoChangeDetected() {
        assertFalse(createCollection123Null().augment(ModifiableOrderedIntegerCollection.of(0, 0, 0, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(2, INTEGER_FOUR, INTEGER_SIX, INTEGER_EIGHT)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedIntegerCollection.of(2, INTEGER_FOUR, INTEGER_SIX, null)));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedIntegerCollection.of(1, 2)));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedIntegerCollection.of(1, null, 2, INTEGER_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(2, createCollection1234().multiply(1, INTEGER_FIVE));
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
    public void multiplyWithIndexShouldMultiplyNumberCorrectly() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.multiply(1, INTEGER_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(1, INTEGER_SIX, INTEGER_THREE, INTEGER_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedIntegerCollection.of(1, 2, INTEGER_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, INTEGER_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, INTEGER_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedIntegerCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, 2));
        assertEquals(
                "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection returns true if a change was made.
     */
    @Test
    public void multiplyWithCollectionShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().multiply(createCollection1234()));
    }

    /**
     * Verifies that multiply with a collection returns true if a change was made and <code>null</code> values match
     */
    @Test
    public void multiplyWithCollectionShouldReturnTrueWhenChangeDetectedAndMatchingNulls() {
        assertTrue(createCollection123Null().multiply(createCollection123Null()));
    }

    /**
     * Verifies that multiply with a collection returns false if no change was made.
     */
    @Test
    public void multiplyWithCollectionShouldReturnFalseWhenNoChangeDetected() {
        assertFalse(createCollection123Null().multiply(ModifiableOrderedIntegerCollection.of(1, 1, 1, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(1, INTEGER_FOUR, INTEGER_NINE, INTEGER_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedIntegerCollection.of(1, INTEGER_FOUR, INTEGER_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedIntegerCollection.of(1, 2)));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedIntegerCollection.of(1, null, 2, INTEGER_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals(2, createCollection1234().negate(1));
    }

    /**
     * Verifies that negate with an index returns <code>null</code> when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void negateWithIndexShouldReturnOriginalNullWhenCalledWithIndexHoldingNullValue() {
        assertNull(createCollection123Null().negate(THREE));
    }

    /**
     * Verifies that negate with an index negates the number in the collection correctly.
     */
    @Test
    public void negateWithIndexShouldNegateNumberCorrectly() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(1, MINUS_TWO, INTEGER_THREE, INTEGER_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedIntegerCollection.of(1, 2, INTEGER_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedIntegerCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.negate(FOUR));
        assertEquals("Cannot negate an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, 1, 2, MINUS_TWO, INTEGER_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> collection.negate(1));
        assertEquals(
                "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that negate returns true if a change was made.
     */
    @Test
    public void negateShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().negate());
    }

    /**
     * Verifies that negate returns true if there's a <code>null</code> value.
     */
    @Test
    public void negateShouldReturnTrueWhenChangeDetectedAndMatchingNulls() {
        assertTrue(createCollection123Null().negate());
    }

    /**
     * Verifies that negate returns false if no change was made.
     */
    @Test
    public void negateShouldReturnFalseWhenNoChangeDetected() {
        assertFalse(ModifiableOrderedIntegerCollection.of(0, 0, 0, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedIntegerCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedIntegerCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }
}
