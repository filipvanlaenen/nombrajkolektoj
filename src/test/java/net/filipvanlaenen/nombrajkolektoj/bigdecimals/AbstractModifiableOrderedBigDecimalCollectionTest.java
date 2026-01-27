package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.AbstractModifiableOrderedBigDecimalCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableOrderedBigDecimalCollection}
 * implementation.
 */
public class AbstractModifiableOrderedBigDecimalCollectionTest {
    /**
     * The magic number minus four.
     */
    private static final BigDecimal MINUS_FOUR = BigDecimal.valueOf(-4L);
    /**
     * The magic number minus three.
     */
    private static final BigDecimal MINUS_THREE = BigDecimal.valueOf(-3L);
    /**
     * The magic number minus two.
     */
    private static final BigDecimal MINUS_TWO = BigDecimal.valueOf(-2L);
    /**
     * The magic number minus one.
     */
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1L);
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
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * The magic number five.
     */
    private static final BigDecimal BIG_DECIMAL_FIVE = BigDecimal.valueOf(5L);
    /**
     * The magic number six.
     */
    private static final BigDecimal BIG_DECIMAL_SIX = BigDecimal.valueOf(6L);
    /**
     * The magic number seven.
     */
    private static final BigDecimal BIG_DECIMAL_SEVEN = BigDecimal.valueOf(7L);
    /**
     * The magic number eight.
     */
    private static final BigDecimal BIG_DECIMAL_EIGHT = BigDecimal.valueOf(8L);
    /**
     * The magic number nine.
     */
    private static final BigDecimal BIG_DECIMAL_NINE = BigDecimal.valueOf(9L);
    /**
     * The magic number sixteen.
     */
    private static final BigDecimal BIG_DECIMAL_SIXTEEN = BigDecimal.valueOf(16L);

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedBigDecimalCollection createCollection1234() {
        return ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedBigDecimalCollection createDistinctCollection1234() {
        return ModifiableOrderedBigDecimalCollection.of(ElementCardinality.DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE,
                BIG_DECIMAL_FOUR);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableOrderedBigDecimalCollection createCollection2468() {
        return ModifiableOrderedBigDecimalCollection.of(BigDecimal.valueOf(2L), BIG_DECIMAL_FOUR, BIG_DECIMAL_SIX, BIG_DECIMAL_EIGHT);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedBigDecimalCollection createCollection123Null() {
        return ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, null);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4, 6 and <code>null</code>.
     */
    private ModifiableOrderedBigDecimalCollection createCollection246Null() {
        return ModifiableOrderedBigDecimalCollection.of(BigDecimal.valueOf(2L), BIG_DECIMAL_FOUR, BIG_DECIMAL_SIX, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(BigDecimal.valueOf(2L), createCollection1234().augment(1, BIG_DECIMAL_FIVE));
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
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.augment(1, BIG_DECIMAL_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BIG_DECIMAL_SEVEN, BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, BIG_DECIMAL_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, BIG_DECIMAL_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedBigDecimalCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, BigDecimal.ONE));
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
        assertFalse(createCollection123Null().augment(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L))));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, null, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(BigDecimal.valueOf(2L), createCollection1234().multiply(1, BIG_DECIMAL_FIVE));
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
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.multiply(1, BIG_DECIMAL_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BIG_DECIMAL_SIX, BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, BIG_DECIMAL_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, BIG_DECIMAL_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedBigDecimalCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, BigDecimal.valueOf(2L)));
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
        assertFalse(createCollection123Null().multiply(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BIG_DECIMAL_FOUR, BIG_DECIMAL_NINE, BIG_DECIMAL_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BIG_DECIMAL_FOUR, BIG_DECIMAL_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L))));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, null, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals(BigDecimal.valueOf(2L), createCollection1234().negate(1));
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
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, MINUS_TWO, BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
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
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), MINUS_TWO, BIG_DECIMAL_THREE);
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
        assertFalse(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedBigDecimalCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that subtract with an index returns the original number.
     */
    @Test
    public void subtractWithIndexShouldReturnOriginal() {
        assertEquals(BigDecimal.valueOf(2L), createCollection1234().subtract(1, BIG_DECIMAL_FIVE));
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
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        collection.subtract(1, BigDecimal.valueOf(2L));
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.ZERO, BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR)));
    }

    /**
     * Verifies that subtract with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void subtractWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        collection.subtract(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, null)));
    }

    /**
     * Verifies that subtract with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.subtract(1, null));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.subtract(THREE, BIG_DECIMAL_FIVE));
        assertEquals("Cannot subtract a null value from a number.", exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception when called with an index that's too large.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.subtract(FOUR, BIG_DECIMAL_FIVE));
        assertEquals("Cannot subtract an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that subtract with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void subtractWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedBigDecimalCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.subtract(1, BigDecimal.ONE));
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
        assertFalse(createCollection123Null().subtract(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, null)));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectly() {
        ModifiableOrderedBigDecimalCollection collection = createCollection2468();
        collection.subtract(createCollection1234());
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that subtract with a collection subtracts the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void subtractWithCollectionShouldSubtractCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedBigDecimalCollection collection = createCollection246Null();
        collection.subtract(createCollection123Null());
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that subtract with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedBigDecimalCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.subtract(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L))));
        assertEquals("Cannot subtract a collection from a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that subtract with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void subtractWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedBigDecimalCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.subtract(ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, null, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)));
        assertEquals("Cannot subtract a collection from a collection when null values don't match.",
                exception.getMessage());
    }
}
