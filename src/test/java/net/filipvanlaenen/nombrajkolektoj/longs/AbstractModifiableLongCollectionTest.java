package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.longs.AbstractModifiableLongCollection}
 * class. The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongCollection}
 * implementation.
 */
public class AbstractModifiableLongCollectionTest {
    /**
     * The magic number minus four.
     */
    private static final long MINUS_FOUR = -4L;
    /**
     * The magic number minus three.
     */
    private static final long MINUS_THREE = -3L;
    /**
     * The magic number minus two.
     */
    private static final long MINUS_TWO = -2L;
    /**
     * The magic number minus one.
     */
    private static final long MINUS_ONE = -1L;
    /**
     * The magic number three.
     */
    private static final long THREE = 3L;
    /**
     * The magic number four.
     */
    private static final long FOUR = 4L;
    /**
     * The magic number five.
     */
    private static final long FIVE = 5L;
    /**
     * The magic number six.
     */
    private static final long SIX = 6L;
    /**
     * The magic number eight.
     */
    private static final long EIGHT = 8L;

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableLongCollection createEmptyCollection() {
        return ModifiableLongCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableLongCollection createCollection1234() {
        return ModifiableLongCollection.of(1L, 2L, THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableLongCollection createCollection123Null() {
        return ModifiableLongCollection.of(1L, 2L, THREE, null);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableLongCollection createCollection2468() {
        return ModifiableLongCollection.of(2L, FOUR, SIX, EIGHT);
    }

    /**
     * Creates a collection with the numbers 2, 4 and 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4 and 6 and <code>null</code>.
     */
    private ModifiableLongCollection createCollection246Null() {
        return ModifiableLongCollection.of(2L, FOUR, SIX, null);
    }

    /**
     * Creates a collection with the number 0.
     *
     * @return A collection with the number 0.
     */
    private ModifiableLongCollection createCollection0() {
        return ModifiableLongCollection.of(0L);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableLongCollection createCollectionNull() {
        return ModifiableLongCollection.of(new Long[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment(1L));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment(1L));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment(1L));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment(0L));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment(1L));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectly() {
        ModifiableLongCollection collection = createCollection1234();
        collection.augment(1L);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(2L, THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableLongCollection collection = createCollection123Null();
        collection.augment(1L);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(2L, THREE, FOUR, null)));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersIsDividedByTwo() {
        assertTrue(createCollection1234().divide(2L));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersWithNullIsDividedByTwo() {
        assertTrue(createCollection123Null().divide(2L));
    }

    /**
     * Verifies that divide returns false on an empty collection.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().divide(2L));
    }

    /**
     * Verifies that divide returns false when no number was changed in the collection.
     */
    @Test
    public void divideShouldReturnFalseWhenACollectionOfNumbersIsDividedByOne() {
        assertFalse(createCollection1234().divide(1L));
    }

    /**
     * Verifies that divide returns false when the collection contains zero only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().divide(2L));
    }

    /**
     * Verifies that divide returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().divide(2L));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectly() {
        ModifiableLongCollection collection = createCollection2468();
        collection.divide(2L);
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableLongCollection collection = createCollection246Null();
        collection.divide(2L);
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that divide can handle intermediate duplicates.
     */
    @Test
    public void divideShouldHandleIntermediateDuplicates() {
        ModifiableLongCollection collection =
                ModifiableLongCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1L, MINUS_ONE);
        collection.divide(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(1L, MINUS_ONE)));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersIsMultipliedByTwo() {
        assertTrue(createCollection1234().multiply(2L));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersWithNullIsMultipliedByTwo() {
        assertTrue(createCollection123Null().multiply(2L));
    }

    /**
     * Verifies that multiply returns false on an empty collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().multiply(2L));
    }

    /**
     * Verifies that multiply returns false when no number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenACollectionOfNumbersIsMultipliedByOne() {
        assertFalse(createCollection1234().multiply(1L));
    }

    /**
     * Verifies that multiply returns false when the collection contains zero only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().multiply(2L));
    }

    /**
     * Verifies that multiply returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().multiply(2L));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectly() {
        ModifiableLongCollection collection = createCollection1234();
        collection.multiply(2L);
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableLongCollection collection = createCollection123Null();
        collection.multiply(2L);
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that multiply can handle intermediate duplicates.
     */
    @Test
    public void multiplyShouldHandleIntermediateDuplicates() {
        ModifiableLongCollection collection =
                ModifiableLongCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1L, MINUS_ONE);
        collection.multiply(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(1L, MINUS_ONE)));
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
        ModifiableLongCollection collection = createCollection1234();
        collection.negate();
        assertTrue(
                collection.containsSame(ModifiableLongCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableLongCollection collection = createCollection123Null();
        collection.negate();
        assertTrue(collection.containsSame(ModifiableLongCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, null)));
    }

    /**
     * Verifies that subtract returns true when a number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().subtract(1L));
    }

    /**
     * Verifies that subtract returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsSubtractedFromACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().subtract(1L));
    }

    /**
     * Verifies that subtract returns false on an empty collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().subtract(1L));
    }

    /**
     * Verifies that subtract returns false when no number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenZeroIsSubractedFromACollectionOfNumbers() {
        assertFalse(createCollection1234().subtract(0L));
    }

    /**
     * Verifies that subtract returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().subtract(1L));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly.
     */
    @Test
    public void subtractShouldSubractAllNumbersCorrectly() {
        ModifiableLongCollection collection = createCollection1234();
        collection.subtract(1L);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(0L, 1L, 2L, THREE)));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void subtractShouldSubtractAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableLongCollection collection = createCollection123Null();
        collection.subtract(1L);
        assertTrue(collection.containsSame(ModifiableLongCollection.of(0L, 1L, 2L, null)));
    }

}
