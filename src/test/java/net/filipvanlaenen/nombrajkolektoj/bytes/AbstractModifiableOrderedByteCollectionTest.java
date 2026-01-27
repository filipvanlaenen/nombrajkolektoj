package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.*;

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
     * The magic number minus four.
     */
    private static final byte MINUS_FOUR = -(byte) 4;
    /**
     * The magic number minus three.
     */
    private static final byte MINUS_THREE = -(byte) 3;
    /**
     * The magic number minus two.
     */
    private static final byte MINUS_TWO = -(byte) 2;
    /**
     * The magic number minus one.
     */
    private static final byte MINUS_ONE = -(byte) 1;
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
     * The magic number eight.
     */
    private static final byte BYTE_EIGHT = (byte) 8;
    /**
     * The magic number nine.
     */
    private static final byte BYTE_NINE = (byte) 9;
    /**
     * The magic number sixteen.
     */
    private static final byte BYTE_SIXTEEN = (byte) 16;

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
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableOrderedByteCollection createCollection2468() {
        return ModifiableOrderedByteCollection.of((byte) 2, BYTE_FOUR, BYTE_SIX, BYTE_EIGHT);
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
     * Creates a collection with the numbers 2, 4, 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4, 6 and <code>null</code>.
     */
    private ModifiableOrderedByteCollection createCollection246Null() {
        return ModifiableOrderedByteCollection.of((byte) 2, BYTE_FOUR, BYTE_SIX, null);
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
     * Verifies that augment with a collection returns true if a change was made.
     */
    @Test
    public void augmentWithCollectionShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().augment(createCollection1234()));
    }

    /**
     * Verifies that augment with a collection returns true if a change was made and <code>null</code> values match.
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
        assertFalse(createCollection123Null().augment(ModifiableOrderedByteCollection.of((byte) 0, (byte) 0, (byte) 0, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2)));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedByteCollection.of((byte) 1, null, (byte) 2, BYTE_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
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
    public void multiplyWithIndexShouldMultiplyNumberCorrectly() {
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

    /**
     * Verifies that multiply with a collection returns true if a change was made.
     */
    @Test
    public void multiplyWithCollectionShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().multiply(createCollection1234()));
    }

    /**
     * Verifies that multiply with a collection returns true if a change was made and <code>null</code> values match.
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
        assertFalse(createCollection123Null().multiply(ModifiableOrderedByteCollection.of((byte) 1, (byte) 1, (byte) 1, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedByteCollection.of((byte) 1, BYTE_FOUR, BYTE_NINE, BYTE_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, BYTE_FOUR, BYTE_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2)));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedByteCollection.of((byte) 1, null, (byte) 2, BYTE_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals((byte) 2, createCollection1234().negate(1));
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
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedByteCollection.of((byte) 1, MINUS_TWO, BYTE_THREE, BYTE_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
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
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, (byte) 1, (byte) 2, MINUS_TWO, BYTE_THREE);
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
        assertFalse(ModifiableOrderedByteCollection.of((byte) 0, (byte) 0, (byte) 0, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedByteCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that subtract with an index returns the original number.
     */
    @Test
    public void subtractWithIndexShouldReturnOriginal() {
        assertEquals((byte) 2, createCollection1234().subtract(1, BYTE_FIVE));
    }

    /**
     * Verifies that subtract with an index returns <code>null</code> when called with <code>null</code> and an index
     * holding the value <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldReturnOriginalNullWhenCalledWithNullValue() {
        assertNull(createCollection123Null().subtract(THREE, null));
    }

    /**
     * Verifies that subtract with an index subtracts the number in the collection correctly.
     */
    @Test
    public void subtractWithIndexShouldSubtractNumberCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        collection.subtract(1, (byte) 2);
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, (byte) 0, BYTE_THREE, BYTE_FOUR)));
    }

    /**
     * Verifies that subtract with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void subtractWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        collection.subtract(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2, BYTE_THREE, null)));
    }

    /**
     * Verifies that subtract with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.subtract(1, null));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.subtract(THREE, BYTE_FIVE));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index that's too large.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.subtract(FOUR, BYTE_FIVE));
        assertEquals("Cannot subtract an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedByteCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.subtract(1, (byte) 1));
        assertEquals(
                "Cannot subtract the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that subtract with a collection returns true if a change was made.
     */
    @Test
    public void subtractWithCollectionShouldReturnTrueWhenChangeDetected() {
        assertTrue(createCollection1234().subtract(createCollection1234()));
    }

    /**
     * Verifies that subtract with a collection returns true if a change was made and <code>null</code> values match.
     */
    @Test
    public void subtractWithCollectionShouldReturnTrueWhenChangeDetectedAndMatchingNulls() {
        assertTrue(createCollection123Null().subtract(createCollection123Null()));
    }

    /**
     * Verifies that subtract with a collection returns false if no change was made.
     */
    @Test
    public void subtractWithCollectionShouldReturnFalseWhenNoChangeDetected() {
        assertFalse(createCollection123Null().subtract(ModifiableOrderedByteCollection.of((byte) 0, (byte) 0, (byte) 0, null)));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectly() {
        ModifiableOrderedByteCollection collection = createCollection2468();
        collection.subtract(createCollection1234());
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedByteCollection collection = createCollection246Null();
        collection.subtract(createCollection123Null());
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that subtract with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedByteCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.subtract(ModifiableOrderedByteCollection.of((byte) 1, (byte) 2)));
        assertEquals("Cannot subtract a collection from a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that subtract with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedByteCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.subtract(ModifiableOrderedByteCollection.of((byte) 1, null, (byte) 2, BYTE_THREE)));
        assertEquals("Cannot subtract a collection from a collection when null values don't match.",
                exception.getMessage());
    }
}
