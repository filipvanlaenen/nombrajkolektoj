package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.shorts.AbstractModifiableOrderedShortCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableOrderedShortCollection}
 * implementation.
 */
public class AbstractModifiableOrderedShortCollectionTest {
    /**
     * The magic number minus four.
     */
    private static final short MINUS_FOUR = -(short) 4;
    /**
     * The magic number minus three.
     */
    private static final short MINUS_THREE = -(short) 3;
    /**
     * The magic number minus two.
     */
    private static final short MINUS_TWO = -(short) 2;
    /**
     * The magic number minus one.
     */
    private static final short MINUS_ONE = -(short) 1;
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
    private static final short SHORT_THREE = (short) 3;
    /**
     * The magic number four.
     */
    private static final short SHORT_FOUR = (short) 4;
    /**
     * The magic number five.
     */
    private static final short SHORT_FIVE = (short) 5;
    /**
     * The magic number six.
     */
    private static final short SHORT_SIX = (short) 6;
    /**
     * The magic number seven.
     */
    private static final short SHORT_SEVEN = (short) 7;
    /**
     * The magic number eight.
     */
    private static final short SHORT_EIGHT = (short) 8;
    /**
     * The magic number nine.
     */
    private static final short SHORT_NINE = (short) 9;
    /**
     * The magic number sixteen.
     */
    private static final short SHORT_SIXTEEN = (short) 16;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedShortCollection createCollection1234() {
        return ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, SHORT_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedShortCollection createDistinctCollection1234() {
        return ModifiableOrderedShortCollection.of(ElementCardinality.DISTINCT_ELEMENTS, (short) 1, (short) 2, SHORT_THREE,
                SHORT_FOUR);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableOrderedShortCollection createCollection2468() {
        return ModifiableOrderedShortCollection.of((short) 2, SHORT_FOUR, SHORT_SIX, SHORT_EIGHT);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedShortCollection createCollection123Null() {
        return ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, null);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4, 6 and <code>null</code>.
     */
    private ModifiableOrderedShortCollection createCollection246Null() {
        return ModifiableOrderedShortCollection.of((short) 2, SHORT_FOUR, SHORT_SIX, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals((short) 2, createCollection1234().augment(1, SHORT_FIVE));
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
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.augment(1, SHORT_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedShortCollection.of((short) 1, SHORT_SEVEN, SHORT_THREE, SHORT_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, SHORT_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, SHORT_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedShortCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, (short) 1));
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
        assertFalse(createCollection123Null().augment(ModifiableOrderedShortCollection.of((short) 0, (short) 0, (short) 0, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedShortCollection.of((short) 1, (short) 2)));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedShortCollection.of((short) 1, null, (short) 2, SHORT_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals((short) 2, createCollection1234().multiply(1, SHORT_FIVE));
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
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.multiply(1, SHORT_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedShortCollection.of((short) 1, SHORT_SIX, SHORT_THREE, SHORT_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, SHORT_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, SHORT_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedShortCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, (short) 2));
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
        assertFalse(createCollection123Null().multiply(ModifiableOrderedShortCollection.of((short) 1, (short) 1, (short) 1, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedShortCollection.of((short) 1, SHORT_FOUR, SHORT_NINE, SHORT_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, SHORT_FOUR, SHORT_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedShortCollection.of((short) 1, (short) 2)));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedShortCollection.of((short) 1, null, (short) 2, SHORT_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals((short) 2, createCollection1234().negate(1));
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
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedShortCollection.of((short) 1, MINUS_TWO, SHORT_THREE, SHORT_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
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
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, (short) 1, (short) 2, MINUS_TWO, SHORT_THREE);
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
        assertFalse(ModifiableOrderedShortCollection.of((short) 0, (short) 0, (short) 0, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedShortCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that subtract with an index returns the original number.
     */
    @Test
    public void subtractWithIndexShouldReturnOriginal() {
        assertEquals((short) 2, createCollection1234().subtract(1, SHORT_FIVE));
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
        ModifiableOrderedShortCollection collection = createCollection1234();
        collection.subtract(1, (short) 2);
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, (short) 0, SHORT_THREE, SHORT_FOUR)));
    }

    /**
     * Verifies that subtract with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void subtractWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        collection.subtract(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE, null)));
    }

    /**
     * Verifies that subtract with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.subtract(1, null));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.subtract(THREE, SHORT_FIVE));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index that's too large.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.subtract(FOUR, SHORT_FIVE));
        assertEquals("Cannot subtract an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedShortCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.subtract(1, (short) 1));
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
        assertFalse(createCollection123Null().subtract(ModifiableOrderedShortCollection.of((short) 0, (short) 0, (short) 0, null)));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectly() {
        ModifiableOrderedShortCollection collection = createCollection2468();
        collection.subtract(createCollection1234());
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedShortCollection collection = createCollection246Null();
        collection.subtract(createCollection123Null());
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that subtract with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedShortCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.subtract(ModifiableOrderedShortCollection.of((short) 1, (short) 2)));
        assertEquals("Cannot subtract a collection from a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that subtract with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedShortCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.subtract(ModifiableOrderedShortCollection.of((short) 1, null, (short) 2, SHORT_THREE)));
        assertEquals("Cannot subtract a collection from a collection when null values don't match.",
                exception.getMessage());
    }
}
