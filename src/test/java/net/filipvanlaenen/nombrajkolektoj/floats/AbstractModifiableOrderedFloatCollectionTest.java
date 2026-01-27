package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.*;

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
     * The magic number minus four.
     */
    private static final float MINUS_FOUR = -4F;
    /**
     * The magic number minus three.
     */
    private static final float MINUS_THREE = -3F;
    /**
     * The magic number minus two.
     */
    private static final float MINUS_TWO = -2F;
    /**
     * The magic number minus one.
     */
    private static final float MINUS_ONE = -1F;
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
     * The magic number eight.
     */
    private static final float FLOAT_EIGHT = 8F;
    /**
     * The magic number nine.
     */
    private static final float FLOAT_NINE = 9F;
    /**
     * The magic number sixteen.
     */
    private static final float FLOAT_SIXTEEN = 16F;

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
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableOrderedFloatCollection createCollection2468() {
        return ModifiableOrderedFloatCollection.of(2F, FLOAT_FOUR, FLOAT_SIX, FLOAT_EIGHT);
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
     * Creates a collection with the numbers 2, 4, 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4, 6 and <code>null</code>.
     */
    private ModifiableOrderedFloatCollection createCollection246Null() {
        return ModifiableOrderedFloatCollection.of(2F, FLOAT_FOUR, FLOAT_SIX, null);
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
        assertFalse(createCollection123Null().augment(ModifiableOrderedFloatCollection.of(0F, 0F, 0F, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedFloatCollection.of(1F, 2F)));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedFloatCollection.of(1F, null, 2F, FLOAT_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
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
    public void multiplyWithIndexShouldMultiplyNumberCorrectly() {
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
        assertFalse(createCollection123Null().multiply(ModifiableOrderedFloatCollection.of(1F, 1F, 1F, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedFloatCollection.of(1F, FLOAT_FOUR, FLOAT_NINE, FLOAT_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, FLOAT_FOUR, FLOAT_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedFloatCollection.of(1F, 2F)));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedFloatCollection.of(1F, null, 2F, FLOAT_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals(2F, createCollection1234().negate(1));
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
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedFloatCollection.of(1F, MINUS_TWO, FLOAT_THREE, FLOAT_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
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
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, 1F, 2F, MINUS_TWO, FLOAT_THREE);
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
        assertFalse(ModifiableOrderedFloatCollection.of(0F, 0F, 0F, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedFloatCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that subtract with an index returns the original number.
     */
    @Test
    public void subtractWithIndexShouldReturnOriginal() {
        assertEquals(2F, createCollection1234().subtract(1, FLOAT_FIVE));
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
        ModifiableOrderedFloatCollection collection = createCollection1234();
        collection.subtract(1, 2F);
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, 0F, FLOAT_THREE, FLOAT_FOUR)));
    }

    /**
     * Verifies that subtract with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void subtractWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        collection.subtract(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedFloatCollection.of(1F, 2F, FLOAT_THREE, null)));
    }

    /**
     * Verifies that subtract with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.subtract(1, null));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.subtract(THREE, FLOAT_FIVE));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index that's too large.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.subtract(FOUR, FLOAT_FIVE));
        assertEquals("Cannot subtract an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedFloatCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.subtract(1, 1F));
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
        assertFalse(createCollection123Null().subtract(ModifiableOrderedFloatCollection.of(0F, 0F, 0F, null)));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectly() {
        ModifiableOrderedFloatCollection collection = createCollection2468();
        collection.subtract(createCollection1234());
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedFloatCollection collection = createCollection246Null();
        collection.subtract(createCollection123Null());
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that subtract with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedFloatCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.subtract(ModifiableOrderedFloatCollection.of(1F, 2F)));
        assertEquals("Cannot subtract a collection from a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that subtract with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedFloatCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.subtract(ModifiableOrderedFloatCollection.of(1F, null, 2F, FLOAT_THREE)));
        assertEquals("Cannot subtract a collection from a collection when null values don't match.",
                exception.getMessage());
    }
}
