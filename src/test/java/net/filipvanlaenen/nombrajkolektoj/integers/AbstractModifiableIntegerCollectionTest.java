package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.integers.AbstractModifiableIntegerCollection}
 * class. The class is tested through the
 * {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} implementation.
 */
public class AbstractModifiableIntegerCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The magic number four.
     */
    private static final int FOUR = 4;
    /**
     * The magic number five.
     */
    private static final int FIVE = 5;

    /**
     * Creates an empty collection.
     *
     * @return An empty collection.
     */
    private ModifiableIntegerCollection createEmptyCollection() {
        return ModifiableIntegerCollection.empty();
    }

    /**
     * Creates a collection with the numbers 1, 2, 3 and 4.
     *
     * @return A collection with the numbers 1, 2, 3 and 4.
     */
    private ModifiableIntegerCollection createCollection1234() {
        return ModifiableIntegerCollection.of(1, 2, THREE, FOUR);
    }

    /**
     * Creates a collection with the numbers 1, 2 and 3 and <code>null</code>.
     *
     * @return A collection with the numbers 1, 2 and 3 and <code>null</code>.
     */
    private ModifiableIntegerCollection createCollection123Null() {
        return ModifiableIntegerCollection.of(1, 2, THREE, null);
    }

    /**
     * Creates a collection with <code>null</code>.
     *
     * @return A collection with <code>null</code>.
     */
    private ModifiableIntegerCollection createCollectionNull() {
        return ModifiableIntegerCollection.of(new Integer[] {null});
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbers() {
        assertTrue(createCollection1234().augment(1));
    }

    /**
     * Verifies that augment returns true when a number was changed in the collection, even when <code>null</code> is
     * present in the collection.
     */
    @Test
    public void augmentShouldReturnTrueWhenOneIsAddedToACollectionOfNumbersWithNull() {
        assertTrue(createCollection123Null().augment(1));
    }

    /**
     * Verifies that augment returns false on an empty collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionIsEmpty() {
        assertFalse(createEmptyCollection().augment(1));
    }

    /**
     * Verifies that augment returns false when no number was changed in the collection.
     */
    @Test
    public void augmentShouldReturnFalseWhenZeroIsAddedToACollectionOfNumbers() {
        assertFalse(createCollection1234().augment(0));
    }

    /**
     * Verifies that augment returns false when the collection contains <code>null</code> only.
     */
    @Test
    public void augmentShouldReturnFalseWhenCollectionContainsNullOnly() {
        assertFalse(createCollectionNull().augment(1));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly.
     */
    @Test
    public void agumentShouldAugmentAllNumbersCorrectly() {
        ModifiableIntegerCollection collection = createCollection1234();
        collection.augment(1);
        assertTrue(collection.containsSame(ModifiableIntegerCollection.of(2, THREE, FOUR, FIVE)));
    }

    /**
     * Verifies that augment augments all the numbers in the collection correctly, also when <code>null</code> is
     * present.
     */
    @Test
    public void agumentShouldAugmentAllNumbersCorrectlyWhenNullIsPresent() {
        ModifiableIntegerCollection collection = createCollection123Null();
        collection.augment(1);
        assertTrue(collection.containsSame(ModifiableIntegerCollection.of(2, THREE, FOUR, null)));
    }
}
