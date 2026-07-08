package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class DoubleCollectionDecoratorTestBase<T extends NumericCollection<Double>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final NumericCollection<Double> collection123 = createDoubleCollection(1D, 2D, 3D);

    /**
     * Creates an empty doubles collection.
     *
     * @return An empty doubles collection.
     */
    protected abstract T createEmptyDoubleCollection();

    /**
     * Creates a doubles collection containing the provided doubles.
     *
     * @param numbers The doubles to be included in the doubles collection.
     * @return An doubles collection containing the provided doubles.
     */
    protected abstract T createDoubleCollection(Double... numbers);

    /**
     * Verifies that an empty doubles collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyDoubleCollection() {
        assertTrue(createEmptyDoubleCollection().isEmpty());
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(1D));
        assertFalse(collection123.contains(0D));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createDoubleCollection(1D)));
        assertFalse(collection123.containsAll(createDoubleCollection(0D)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(collection123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.toArray().length);
    }
}
