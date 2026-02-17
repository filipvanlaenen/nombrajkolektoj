package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class DoubleCollectionTestBase<T extends NumericCollection<Double>> {
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
     * Creates a doubles collection from a collection of doubles.
     *
     * @param source The collection of doubles.
     * @return A doubles collection containing the provided doubles.
     */
    protected abstract T createDoubleCollection(NumericCollection<Double> source);

    /**
     * Creates a doubles collection with the provided element cardinality containing the provided doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles to be included in the doubles collection.
     * @return A doubles collection with the provided element cardinality containing the provided doubles.
     */
    protected abstract T createDoubleCollection(ElementCardinality elementCardinality, Double... numbers);

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
     * Verifies that a doubles collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnADoubleCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createDoubleCollection(DISTINCT_ELEMENTS, 1D).getElementCardinality());
    }

    /**
     * Verifies that a doubles collection created from another collection has the same element cardinality and doubles.
     */
    @Test
    public void ofWithCollectionShouldReturnADoubleCollectionWithTheSameElementCardinalityAndDoubles() {
        DoubleCollection source = DoubleCollection.of(DISTINCT_ELEMENTS, 1D);
        T actual = createDoubleCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1D));
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
