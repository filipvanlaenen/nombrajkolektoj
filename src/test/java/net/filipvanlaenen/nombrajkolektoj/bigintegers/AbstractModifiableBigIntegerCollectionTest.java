package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.AbstractModifiableBigIntegerCollection}
 * class. The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerCollection}
 * implementation.
 */
public class AbstractModifiableBigIntegerCollectionTest {
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
    private static final BigInteger THREE = BigInteger.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigInteger FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number five.
     */
    private static final BigInteger FIVE = BigInteger.valueOf(5L);
    /**
     * The magic number six.
     */
    private static final BigInteger SIX = BigInteger.valueOf(6L);
    /**
     * The magic number eight.
     */
    private static final BigInteger EIGHT = BigInteger.valueOf(8L);

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableBigIntegerCollection createEmptyCollection() {
        return ModifiableBigIntegerCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableBigIntegerCollection createCollection1234() {
        return ModifiableBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableBigIntegerCollection createCollection123Null() {
        return ModifiableBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, THREE, null);
    }

    /**
     * Creates a collection with the number 0.
     *
     * @return A collection with the number 0.
     */
    private ModifiableBigIntegerCollection createCollection0() {
        return ModifiableBigIntegerCollection.of(BigInteger.ZERO);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableBigIntegerCollection createCollectionNull() {
        return ModifiableBigIntegerCollection.of(new BigInteger[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment(BigInteger.ONE));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment(BigInteger.ONE));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment(BigInteger.ONE));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment(BigInteger.ZERO));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment(BigInteger.ONE));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectly() {
        ModifiableBigIntegerCollection collection = createCollection1234();
        collection.augment(BigInteger.ONE);
        assertTrue(collection.containsSame(ModifiableBigIntegerCollection.of(BigInteger.TWO, THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigIntegerCollection collection = createCollection123Null();
        collection.augment(BigInteger.ONE);
        assertTrue(collection.containsSame(ModifiableBigIntegerCollection.of(BigInteger.TWO, THREE, FOUR, null)));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersIsMultipliedByTwo() {
        assertTrue(createCollection1234().multiply(BigInteger.TWO));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersWithNullIsMultipliedByTwo() {
        assertTrue(createCollection123Null().multiply(BigInteger.TWO));
    }

    /**
     * Verifies that multiply returns false on an empty collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().multiply(BigInteger.TWO));
    }

    /**
     * Verifies that multiply returns false when no number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenACollectionOfNumbersIsMultipliedByOne() {
        assertFalse(createCollection1234().multiply(BigInteger.ONE));
    }

    /**
     * Verifies that multiply returns false when the collection contains zero only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().multiply(BigInteger.TWO));
    }

    /**
     * Verifies that multiply returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().multiply(BigInteger.TWO));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectly() {
        ModifiableBigIntegerCollection collection = createCollection1234();
        collection.multiply(BigInteger.TWO);
        assertTrue(collection.containsSame(ModifiableBigIntegerCollection.of(BigInteger.TWO, FOUR, SIX, EIGHT)));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigIntegerCollection collection = createCollection123Null();
        collection.multiply(BigInteger.TWO);
        assertTrue(collection.containsSame(ModifiableBigIntegerCollection.of(BigInteger.TWO, FOUR, SIX, null)));
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
        ModifiableBigIntegerCollection collection = createCollection1234();
        collection.negate();
        assertTrue(
                collection.containsSame(ModifiableBigIntegerCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigIntegerCollection collection = createCollection123Null();
        collection.negate();
        assertTrue(collection.containsSame(ModifiableBigIntegerCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, null)));
    }
}
