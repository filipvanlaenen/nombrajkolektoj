package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bytes.AbstractModifiableByteCollection}
 * class. The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection}
 * implementation.
 */
public class AbstractModifiableByteCollectionTest {
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
    private static final byte THREE = (byte) 3;
    /**
     * The magic number four.
     */
    private static final byte FOUR = (byte) 4;
    /**
     * The magic number five.
     */
    private static final byte FIVE = (byte) 5;
    /**
     * The magic number six.
     */
    private static final byte SIX = (byte) 6;
    /**
     * The magic number eight.
     */
    private static final byte EIGHT = (byte) 8;

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableByteCollection createEmptyCollection() {
        return ModifiableByteCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableByteCollection createCollection1234() {
        return ModifiableByteCollection.of((byte) 1, (byte) 2, THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableByteCollection createCollection123Null() {
        return ModifiableByteCollection.of((byte) 1, (byte) 2, THREE, null);
    }

    /**
     * Creates a collection with the number 0.
     *
     * @return A collection with the number 0.
     */
    private ModifiableByteCollection createCollection0() {
        return ModifiableByteCollection.of((byte) 0);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableByteCollection createCollectionNull() {
        return ModifiableByteCollection.of(new Byte[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment((byte) 1));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment((byte) 1));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment((byte) 1));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment((byte) 0));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment((byte) 1));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectly() {
        ModifiableByteCollection collection = createCollection1234();
        collection.augment((byte) 1);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 2, THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection123Null();
        collection.augment((byte) 1);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 2, THREE, FOUR, null)));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersIsMultipliedByTwo() {
        assertTrue(createCollection1234().multiply((byte) 2));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersWithNullIsMultipliedByTwo() {
        assertTrue(createCollection123Null().multiply((byte) 2));
    }

    /**
     * Verifies that multiply returns false on an empty collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().multiply((byte) 2));
    }

    /**
     * Verifies that multiply returns false when no number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenACollectionOfNumbersIsMultipliedByOne() {
        assertFalse(createCollection1234().multiply((byte) 1));
    }

    /**
     * Verifies that multiply returns false when the collection contains zero only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().multiply((byte) 2));
    }

    /**
     * Verifies that multiply returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().multiply((byte) 2));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectly() {
        ModifiableByteCollection collection = createCollection1234();
        collection.multiply((byte) 2);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 2, FOUR, SIX, EIGHT)));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection123Null();
        collection.multiply((byte) 2);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 2, FOUR, SIX, null)));
    }

    /**
     * Verifies that negate returns true when a number was changed in the collection.
     */
    @Test
    public void negateShouldReturnTrueWhenACollectionOfNumbersIsNegated() {
        assertTrue(createCollection1234().negate());
    }

    /**
     * Verifies that negate returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void negateShouldReturnTrueWhenACollectionOfNumbersWithNullIsNegated() {
        assertTrue(createCollection123Null().negate());
    }

    /**
     * Verifies that negate returns false on an empty collection.
     */
    @Test
    public void negateShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().negate());
    }

    /**
     * Verifies that negate returns false when the collection contains zero only.
     */
    @Test
    public void negateShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().negate());
    }

    /**
     * Verifies that negate returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void negateShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().negate());
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectly() {
        ModifiableByteCollection collection = createCollection1234();
        collection.negate();
        assertTrue(
                collection.containsSame(ModifiableByteCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection123Null();
        collection.negate();
        assertTrue(collection.containsSame(ModifiableByteCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, null)));
    }
}
