package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

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
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableByteCollection createCollection2468() {
        return ModifiableByteCollection.of((byte) 2, FOUR, SIX, EIGHT);
    }

    /**
     * Creates a collection with the numbers 2, 4 and 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4 and 6 and <code>null</code>.
     */
    private ModifiableByteCollection createCollection246Null() {
        return ModifiableByteCollection.of((byte) 2, FOUR, SIX, null);
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
     * Verifies that divide returns true when a number was changed in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersIsDividedByTwo() {
        assertTrue(createCollection1234().divide((byte) 2));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersWithNullIsDividedByTwo() {
        assertTrue(createCollection123Null().divide((byte) 2));
    }

    /**
     * Verifies that divide returns false on an empty collection.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().divide((byte) 2));
    }

    /**
     * Verifies that divide returns false when no number was changed in the collection.
     */
    @Test
    public void divideShouldReturnFalseWhenACollectionOfNumbersIsDividedByOne() {
        assertFalse(createCollection1234().divide((byte) 1));
    }

    /**
     * Verifies that divide returns false when the collection contains zero only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().divide((byte) 2));
    }

    /**
     * Verifies that divide returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().divide((byte) 2));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectly() {
        ModifiableByteCollection collection = createCollection2468();
        collection.divide((byte) 2);
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection246Null();
        collection.divide((byte) 2);
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that divide can handle intermediate duplicates.
     */
    @Test
    public void divideShouldHandleIntermediateDuplicates() {
        ModifiableByteCollection collection =
                ModifiableByteCollection.of(ElementCardinality.DISTINCT_ELEMENTS, (byte) 1, MINUS_ONE);
        collection.divide(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 1, MINUS_ONE)));
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
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection123Null();
        collection.multiply((byte) 2);
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that multiply can handle intermediate duplicates.
     */
    @Test
    public void multiplyShouldHandleIntermediateDuplicates() {
        ModifiableByteCollection collection =
                ModifiableByteCollection.of(ElementCardinality.DISTINCT_ELEMENTS, (byte) 1, MINUS_ONE);
        collection.multiply(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 1, MINUS_ONE)));
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

    /**
     * Verifies that subtract returns true when a number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().subtract((byte) 1));
    }

    /**
     * Verifies that subtract returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsSubtractedFromACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().subtract((byte) 1));
    }

    /**
     * Verifies that subtract returns false on an empty collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().subtract((byte) 1));
    }

    /**
     * Verifies that subtract returns false when no number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenZeroIsSubractedFromACollectionOfNumbers() {
        assertFalse(createCollection1234().subtract((byte) 0));
    }

    /**
     * Verifies that subtract returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().subtract((byte) 1));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly.
     */
    @Test
    public void subtractShouldSubractAllNumbersCorrectly() {
        ModifiableByteCollection collection = createCollection1234();
        collection.subtract((byte) 1);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 0, (byte) 1, (byte) 2, THREE)));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void subtractShouldSubtractAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableByteCollection collection = createCollection123Null();
        collection.subtract((byte) 1);
        assertTrue(collection.containsSame(ModifiableByteCollection.of((byte) 0, (byte) 1, (byte) 2, null)));
    }

}
