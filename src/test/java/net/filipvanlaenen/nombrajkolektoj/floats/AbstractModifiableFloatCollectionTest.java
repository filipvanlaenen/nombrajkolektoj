package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.floats.AbstractModifiableFloatCollection}
 * class. The class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection}
 * implementation.
 */
public class AbstractModifiableFloatCollectionTest {
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
    private static final float THREE = 3F;
    /**
     * The magic number four.
     */
    private static final float FOUR = 4F;
    /**
     * The magic number five.
     */
    private static final float FIVE = 5F;
    /**
     * The magic number six.
     */
    private static final float SIX = 6F;
    /**
     * The magic number eight.
     */
    private static final float EIGHT = 8F;

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableFloatCollection createEmptyCollection() {
        return ModifiableFloatCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableFloatCollection createCollection1234() {
        return ModifiableFloatCollection.of(1F, 2F, THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableFloatCollection createCollection123Null() {
        return ModifiableFloatCollection.of(1F, 2F, THREE, null);
    }

    /**
     * Creates a collection with the numbers 2, 4, 6 and 8.
     *
     * @return A collection with the numbers 2, 4, 6 and 8.
     */
    private ModifiableFloatCollection createCollection2468() {
        return ModifiableFloatCollection.of(2F, FOUR, SIX, EIGHT);
    }

    /**
     * Creates a collection with the numbers 2, 4 and 6 and <code>null</code>.
     *
     * @return A collection with the numbers 2, 4 and 6 and <code>null</code>.
     */
    private ModifiableFloatCollection createCollection246Null() {
        return ModifiableFloatCollection.of(2F, FOUR, SIX, null);
    }

    /**
     * Creates a collection with the number 0.
     *
     * @return A collection with the number 0.
     */
    private ModifiableFloatCollection createCollection0() {
        return ModifiableFloatCollection.of(0F);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableFloatCollection createCollectionNull() {
        return ModifiableFloatCollection.of(new Float[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment(1F));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment(1F));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment(1F));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment(0F));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment(1F));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectly() {
        ModifiableFloatCollection collection = createCollection1234();
        collection.augment(1F);
        assertTrue(collection.containsSame(ModifiableFloatCollection.of(2F, THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void augmentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableFloatCollection collection = createCollection123Null();
        collection.augment(1F);
        assertTrue(collection.containsSame(ModifiableFloatCollection.of(2F, THREE, FOUR, null)));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersIsDividedByTwo() {
        assertTrue(createCollection1234().divide(2F));
    }

    /**
     * Verifies that divide returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void divideShouldReturnTrueWhenACollectionOfNumbersWithNullIsDividedByTwo() {
        assertTrue(createCollection123Null().divide(2F));
    }

    /**
     * Verifies that divide returns false on an empty collection.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().divide(2F));
    }

    /**
     * Verifies that divide returns false when no number was changed in the collection.
     */
    @Test
    public void divideShouldReturnFalseWhenACollectionOfNumbersIsDividedByOne() {
        assertFalse(createCollection1234().divide(1F));
    }

    /**
     * Verifies that divide returns false when the collection contains zero only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().divide(2F));
    }

    /**
     * Verifies that divide returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void divideShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().divide(2F));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectly() {
        ModifiableFloatCollection collection = createCollection2468();
        collection.divide(2F);
        assertTrue(collection.containsSame(createCollection1234()));
    }

    /**
     * Verifies that divide divides all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void divideShouldDivideAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableFloatCollection collection = createCollection246Null();
        collection.divide(2F);
        assertTrue(collection.containsSame(createCollection123Null()));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersIsMultipliedByTwo() {
        assertTrue(createCollection1234().multiply(2F));
    }

    /**
     * Verifies that multiply returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void multiplyShouldReturnTrueWhenACollectionOfNumbersWithNullIsMultipliedByTwo() {
        assertTrue(createCollection123Null().multiply(2F));
    }

    /**
     * Verifies that multiply returns false on an empty collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().multiply(2F));
    }

    /**
     * Verifies that multiply returns false when no number was changed in the collection.
     */
    @Test
    public void multiplyShouldReturnFalseWhenACollectionOfNumbersIsMultipliedByOne() {
        assertFalse(createCollection1234().multiply(1F));
    }

    /**
     * Verifies that multiply returns false when the collection contains zero only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsZeroOnly() {
        assertFalse(createCollection0().multiply(2F));
    }

    /**
     * Verifies that multiply returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void multiplyShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().multiply(2F));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectly() {
        ModifiableFloatCollection collection = createCollection1234();
        collection.multiply(2F);
        assertTrue(collection.containsSame(createCollection2468()));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void multiplyShouldMultiplyAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableFloatCollection collection = createCollection123Null();
        collection.multiply(2F);
        assertTrue(collection.containsSame(createCollection246Null()));
    }

    /**
     * Verifies that multiply multiplies all the numbers in the collection correctly.
     */
    @Test
    public void foo() {
        ModifiableFloatCollection collection =
                ModifiableFloatCollection.of(ElementCardinality.DISTINCT_ELEMENTS, 1F, MINUS_ONE);
        collection.multiply(MINUS_ONE);
        assertTrue(collection.containsSame(ModifiableFloatCollection.of(1F, MINUS_ONE)));
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
        ModifiableFloatCollection collection = createCollection1234();
        collection.negate();
        assertTrue(
                collection.containsSame(ModifiableFloatCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, MINUS_FOUR)));
    }

    /**
     * Verifies that negate negates all the numbers in the collection correctly, also when <code>null</code> is present.
     */
    @Test
    public void negateShouldNegateAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableFloatCollection collection = createCollection123Null();
        collection.negate();
        assertTrue(collection.containsSame(ModifiableFloatCollection.of(MINUS_ONE, MINUS_TWO, MINUS_THREE, null)));
    }
}
