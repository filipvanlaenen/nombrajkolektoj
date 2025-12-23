package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.AbstractModifiableOrderedDoubleCollection} class. The class is
 * tested through the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableOrderedDoubleCollection}
 * implementation.
 */
public class AbstractModifiableOrderedDoubleCollectionTest {
    /**
     * The magic number minus two.
     */
    private static final double MINUS_TWO = -2D;
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
    private static final double DOUBLE_THREE = 3D;
    /**
     * The magic number four.
     */
    private static final double DOUBLE_FOUR = 4D;
    /**
     * The magic number five.
     */
    private static final double DOUBLE_FIVE = 5D;
    /**
     * The magic number six.
     */
    private static final double DOUBLE_SIX = 6D;
    /**
     * The magic number seven.
     */
    private static final double DOUBLE_SEVEN = 7D;

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedDoubleCollection createCollection1234() {
        return ModifiableOrderedDoubleCollection.of(1D, 2D, DOUBLE_THREE, DOUBLE_FOUR);
    }

    /**
     * Creates a distinct collection with the numbers 1, 2, 3 and 4.
     *
     * @return A distinct collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableOrderedDoubleCollection createDistinctCollection1234() {
        return ModifiableOrderedDoubleCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1D, 2D, DOUBLE_THREE,
                DOUBLE_FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2, 3 and <code>null</code>.
     */
    private ModifiableOrderedDoubleCollection createCollection123Null() {
        return ModifiableOrderedDoubleCollection.of(1D, 2D, DOUBLE_THREE, null);
    }

    /**
     * Verifies that augment with an index returns the original number.
     */
    @Test
    public void augmentWithIndexShouldReturnOriginal() {
        assertEquals(2D, createCollection1234().augment(1, DOUBLE_FIVE));
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
        ModifiableOrderedDoubleCollection collection = createCollection1234();
        collection.augment(1, DOUBLE_FIVE);
        assertTrue(collection
                .containsSame(ModifiableOrderedDoubleCollection.of(1D, DOUBLE_SEVEN, DOUBLE_THREE, DOUBLE_FOUR)));
    }

    /**
     * Verifies that augment with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void augmentWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        collection.augment(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedDoubleCollection.of(1D, 2D, DOUBLE_THREE, null)));
    }

    /**
     * Verifies that augment with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedDoubleCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.augment(1, null));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.augment(THREE, DOUBLE_FIVE));
        assertEquals("Cannot augment a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception when called with an index that's too large.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.augment(FOUR, DOUBLE_FIVE));
        assertEquals("Cannot augment an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that augment with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void augmentWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedDoubleCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.augment(1, 1D));
        assertEquals(
                "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with an index returns the original number.
     */
    @Test
    public void multiplyWithIndexShouldReturnOriginal() {
        assertEquals(2D, createCollection1234().multiply(1, DOUBLE_FIVE));
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
        ModifiableOrderedDoubleCollection collection = createCollection1234();
        collection.multiply(1, DOUBLE_THREE);
        assertTrue(collection
                .containsSame(ModifiableOrderedDoubleCollection.of(1D, DOUBLE_SIX, DOUBLE_THREE, DOUBLE_FOUR)));
    }

    /**
     * Verifies that multiply with an index leaves the collection unchanged for matching <code>null</code> values.
     */
    @Test
    public void multiplyWithIndexShouldLeaveCollectionUnchangedForMatchingNull() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        collection.multiply(THREE, null);
        assertTrue(collection.containsSame(ModifiableOrderedDoubleCollection.of(1D, 2D, DOUBLE_THREE, null)));
    }

    /**
     * Verifies that multiply with index throws an exception when called with the value <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithNull() {
        ModifiableOrderedDoubleCollection collection = createCollection1234();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> collection.multiply(1, null));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index holding the value
     * <code>null</code>.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> collection.multiply(THREE, DOUBLE_FIVE));
        assertEquals("Cannot multiply a null value with a number.", exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception when called with an index that's too large.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> collection.multiply(FOUR, DOUBLE_FIVE));
        assertEquals("Cannot multiply an element at a position beyond the size of the collection.",
                exception.getMessage());
    }

    /**
     * Verifies that multiply with index throws an exception if it would result in a duplicate.
     */
    @Test
    public void multiplyWithIndexShouldThrowExceptionForDuplicate() {
        ModifiableOrderedDoubleCollection collection = createDistinctCollection1234();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> collection.multiply(1, 2D));
        assertEquals(
                "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }

    /**
     * Verifies that negate with an index returns the original number.
     */
    @Test
    public void negateWithIndexShouldReturnOriginal() {
        assertEquals(2D, createCollection1234().negate(1));
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
        ModifiableOrderedDoubleCollection collection = createCollection1234();
        collection.negate(1);
        assertTrue(collection
                .containsSame(ModifiableOrderedDoubleCollection.of(1D, MINUS_TWO, DOUBLE_THREE, DOUBLE_FOUR)));
    }

    /**
     * Verifies that negate with an index holding <code>null</code> leaves the collection unchanged.
     */
    @Test
    public void negateWithIndexShouldLeaveCollectionUnchangedWhenCalledWithIndexHoldingNull() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
        collection.negate(THREE);
        assertTrue(collection.containsSame(ModifiableOrderedDoubleCollection.of(1D, 2D, DOUBLE_THREE, null)));
    }

    /**
     * Verifies that negate with index throws an exception when called with an index that's too large.
     */
    @Test
    public void negateWithIndexShouldThrowExceptionWhenCalledWithTooLargeIndex() {
        ModifiableOrderedDoubleCollection collection = createCollection123Null();
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
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection
                .of(ElementCardinality.DISTINCT_ELEMENTS, 1D, 2D, MINUS_TWO, DOUBLE_THREE);
        ;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> collection.negate(1));
        assertEquals(
                "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.",
                exception.getMessage());
    }
}
