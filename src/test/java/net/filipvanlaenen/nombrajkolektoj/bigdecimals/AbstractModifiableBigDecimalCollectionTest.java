package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.AbstractModifiableBigDecimalCollection}
 * class. The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection}
 * implementation.
 */
public class AbstractModifiableBigDecimalCollectionTest {
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
    private static final BigDecimal THREE = BigDecimal.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigDecimal FOUR = BigDecimal.valueOf(4L);
    /**
     * The magic number five.
     */
    private static final BigDecimal FIVE = BigDecimal.valueOf(5L);
    /**
     * The magic number six.
     */
    private static final BigDecimal SIX = BigDecimal.valueOf(6L);
    /**
     * The magic number eight.
     */
    private static final BigDecimal EIGHT = BigDecimal.valueOf(8L);

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableBigDecimalCollection createEmptyCollection() {
        return ModifiableBigDecimalCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableBigDecimalCollection createCollection1234() {
        return ModifiableBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableBigDecimalCollection createCollection123Null() {
        return ModifiableBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), THREE, null);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableBigDecimalCollection createCollection2468() {
        return ModifiableBigDecimalCollection.of(BigDecimal.valueOf(2L), FOUR, SIX, EIGHT);
    }

    /**
     * Creates a collection with the numbers 2, 4 and 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4 and 6 and <code>null</code>.
     */
    private ModifiableBigDecimalCollection createCollection246Null() {
        return ModifiableBigDecimalCollection.of(BigDecimal.valueOf(2L), FOUR, SIX, null);
    }

    /**
     * Creates a collection with the number 0.
     *
     * @return A collection with the number 0.
     */
    private ModifiableBigDecimalCollection createCollection0() {
        return ModifiableBigDecimalCollection.of(BigDecimal.ZERO);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableBigDecimalCollection createCollectionNull() {
        return ModifiableBigDecimalCollection.of(new BigDecimal[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment(BigDecimal.ONE));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment(BigDecimal.ONE));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment(BigDecimal.ONE));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment(BigDecimal.ZERO));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment(BigDecimal.ONE));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectly() {
        ModifiableBigDecimalCollection collection = createCollection1234();
        collection.augment(BigDecimal.ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.valueOf(2L), THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigDecimalCollection collection = createCollection123Null();
        collection.augment(BigDecimal.ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.valueOf(2L), THREE, FOUR, null)));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersIsDividedByTwo() {
        assertTrue(createCollection1234().divide(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersWithNullIsDividedByTwo() {
        assertTrue(createCollection123Null().divide(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that divide returns false on an empty collection.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().divide(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that divide returns false when no number was changed in the collection.
     */
    @Test
    public void divideShouldReturnFalseWhenACollectionOfNumbersIsDividedByOne() {
        assertFalse(createCollection1234().divide(BigDecimal.ONE));
    }

    /**
     * Verifies that divide returns false when the collection contains zero only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().divide(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that divide returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().divide(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectly() {
        ModifiableBigDecimalCollection collection = createCollection2468();
        collection.divide(BigDecimal.valueOf(2L));
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigDecimalCollection collection = createCollection246Null();
        collection.divide(BigDecimal.valueOf(2L));
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that divide can handle intermediate duplicates.
     */
    @Test
    public void divideShouldHandleIntermediateDuplicates() {
        ModifiableBigDecimalCollection collection =
                ModifiableBigDecimalCollection.of(ElementCardinality.DISTINCT_ELEMENTS, BigDecimal.ONE, MINUS_ONE);
        collection.divide(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.ONE, MINUS_ONE)));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersIsMultipliedByTwo() {
        assertTrue(createCollection1234().multiply(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersWithNullIsMultipliedByTwo() {
        assertTrue(createCollection123Null().multiply(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that multiply returns false on an empty collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().multiply(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that multiply returns false when no number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenACollectionOfNumbersIsMultipliedByOne() {
        assertFalse(createCollection1234().multiply(BigDecimal.ONE));
    }

    /**
     * Verifies that multiply returns false when the collection contains zero only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().multiply(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that multiply returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().multiply(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectly() {
        ModifiableBigDecimalCollection collection = createCollection1234();
        collection.multiply(BigDecimal.valueOf(2L));
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigDecimalCollection collection = createCollection123Null();
        collection.multiply(BigDecimal.valueOf(2L));
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that multiply can handle intermediate duplicates.
     */
    @Test
    public void multiplyShouldHandleIntermediateDuplicates() {
        ModifiableBigDecimalCollection collection =
                ModifiableBigDecimalCollection.of(ElementCardinality.DISTINCT_ELEMENTS, BigDecimal.ONE, MINUS_ONE);
        collection.multiply(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.ONE, MINUS_ONE)));
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
        ModifiableBigDecimalCollection collection = createCollection1234();
        collection.negate();
        assertTrue(
                collection.containsSame(ModifiableBigDecimalCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigDecimalCollection collection = createCollection123Null();
        collection.negate();
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, null)));
    }

    /**
     * Verifies that subtract returns true when a number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().subtract(BigDecimal.ONE));
    }

    /**
     * Verifies that subtract returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void subtractShouldReturnTrueWhenOneIsSubtractedFromACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().subtract(BigDecimal.ONE));
    }

    /**
     * Verifies that subtract returns false on an empty collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().subtract(BigDecimal.ONE));
    }

    /**
     * Verifies that subtract returns false when no number was changed in the collection.
     */
    @Test
    public void subtractShouldReturnFalseWhenZeroIsSubractedFromACollectionOfNumbers() {
        assertFalse(createCollection1234().subtract(BigDecimal.ZERO));
    }

    /**
     * Verifies that subtract returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void subtractShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().subtract(BigDecimal.ONE));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly.
     */
    @Test
    public void subtractShouldSubractAllNumbersCorrectly() {
        ModifiableBigDecimalCollection collection = createCollection1234();
        collection.subtract(BigDecimal.ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), THREE)));
    }

    /**
     * Verifies that subtract subtracts all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void subtractShouldSubtractAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableBigDecimalCollection collection = createCollection123Null();
        collection.subtract(BigDecimal.ONE);
        assertTrue(collection.containsSame(ModifiableBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), null)));
    }

}
