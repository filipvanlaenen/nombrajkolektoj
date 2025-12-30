package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.AbstractModifiableOrderedBigIntegerCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableOrderedBigIntegerCollection}
 * implementation.
 */
public class AbstractModifiableOrderedBigIntegerCollectionTest {
    /**
     * The magic number minus four.
     */
    private static final BigInteger MINUS_FOUR = BigInteger.valueOf(-4L);
    /**
     * The magic number minus three.
     */
    private static final BigInteger MINUS_THREE = BigInteger.valueOf(-3L);
    /**
     * The magic number minus two.
     */
    private static final BigInteger MINUS_TWO = BigInteger.valueOf(-2L);
    /**
     * The magic number minus one.
     */
    private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1L);
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
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number five.
     */
    private static final BigInteger BIG_INTEGER_FIVE = BigInteger.valueOf(5L);
    /**
     * The magic number six.
     */
    private static final BigInteger BIG_INTEGER_SIX = BigInteger.valueOf(6L);
    /**
     * The magic number seven.
     */
    private static final BigInteger BIG_INTEGER_SEVEN = BigInteger.valueOf(7L);
    /**
     * The magic number eight.
     */
    private static final BigInteger BIG_INTEGER_EIGHT = BigInteger.valueOf(8L);
    /**
     * The magic number nine.
     */
    private static final BigInteger BIG_INTEGER_NINE = BigInteger.valueOf(9L);
    /**
     * The magic number sixteen.
     */
    private static final BigInteger BIG_INTEGER_SIXTEEN = BigInteger.valueOf(16L);

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedBigIntegerCollection createCollection1234() {
        return ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedBigIntegerCollection createDistinctCollection1234() {
        return ModifiableOrderedBigIntegerCollection.of(ElementCardinality.DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE,
                BIG_INTEGER_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedBigIntegerCollection createCollection123Null() {
        return ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(BigInteger.TWO, createCollection1234().augment(1, BIG_INTEGER_FIVE));
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
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.augment(1, BIG_INTEGER_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BIG_INTEGER_SEVEN, BIG_INTEGER_THREE, BIG_INTEGER_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, BIG_INTEGER_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, BIG_INTEGER_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedBigIntegerCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, BigInteger.ONE));
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
        assertFalse(createCollection123Null().augment(ModifiableOrderedBigIntegerCollection.of(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, null)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectly() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.augment(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.TWO, BIG_INTEGER_FOUR, BIG_INTEGER_SIX, BIG_INTEGER_EIGHT)));
    }

    /**
     * Verifies that augment with a collection augments the collection correctly with matching <code>null</code> values.
     */
    @Test
    public void augmentWithCollectionShouldAugmentCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        collection.augment(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.TWO, BIG_INTEGER_FOUR, BIG_INTEGER_SIX, null)));
    }

    /**
     * Verifies that augment with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.augment(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO)));
        assertEquals("Cannot augment a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that augment with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void augmentWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.augment(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, null, BigInteger.TWO, BIG_INTEGER_THREE)));
        assertEquals("Cannot augment a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(BigInteger.TWO, createCollection1234().multiply(1, BIG_INTEGER_FIVE));
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
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.multiply(1, BIG_INTEGER_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BIG_INTEGER_SIX, BIG_INTEGER_THREE, BIG_INTEGER_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, BIG_INTEGER_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, BIG_INTEGER_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedBigIntegerCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, BigInteger.TWO));
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
        assertFalse(createCollection123Null().multiply(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, null)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectly() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.multiply(createCollection1234());
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BIG_INTEGER_FOUR, BIG_INTEGER_NINE, BIG_INTEGER_SIXTEEN)));
    }

    /**
     * Verifies that multiply with a collection multiplies the collection correctly with matching <code>null</code>
     * values.
     */
    @Test
    public void multiplyWithCollectionShouldMultiplyCollectionCorrectlyWithMatchingNullValues() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        collection.multiply(createCollection123Null());
        assertTrue(collection.containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BIG_INTEGER_FOUR, BIG_INTEGER_NINE, null)));
    }

    /**
     * Verifies that multiply with a collection throws an exception when the collections don't have the same size.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenSizeDiffers() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> collection.multiply(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO)));
        assertEquals("Cannot multiply a collection with a collection of a different size.", exception.getMessage());
    }

    /**
     * Verifies that multiply with a collection throws an exception when the <code>null</code> values don't match.
     */
    @Test
    public void multiplyWithCallectionShouldThrowExceptionWhenNullValuesDoNotMatch() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> collection.multiply(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, null, BigInteger.TWO, BIG_INTEGER_THREE)));
        assertEquals("Cannot multiply a collection with a collection when null values don't match.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals(BigInteger.TWO, createCollection1234().negate(1));
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
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, MINUS_TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedBigIntegerCollection collection = createCollection123Null();
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
        ModifiableOrderedBigIntegerCollection collection = ModifiableOrderedBigIntegerCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, MINUS_TWO, BIG_INTEGER_THREE);
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
        assertFalse(ModifiableOrderedBigIntegerCollection.of(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, null).negate());
    }

    /**
     * Verifies that negate negates the collection correctly.
     */
    @Test
    public void negateShouldAugmentCollectionCorrectly() {
        ModifiableOrderedBigIntegerCollection collection = createCollection1234();
        collection.negate();
        assertTrue(collection
                .containsSame(ModifiableOrderedBigIntegerCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }
}
