package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

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
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    /**
     * Creates a doubles collection with the provided element cardinality containing the provided doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles to be included in the doubles collection.
     * @return A doubles collection with the provided element cardinality containing the provided doubles.
     */
    protected abstract T createDoubleCollection(ElementCardinality elementCardinality, Double... numbers);

    /**
     * Creates a doubles collection from a collection of doubles with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of doubles.
     * @return A doubles collection containing the provided doubles with the provided element cardinality.
     */
    protected abstract T createDoubleCollection(ElementCardinality elementCardinality,
            NumericCollection<Double> source);

    /**
     * Creates a doubles collection from a collection of doubles.
     *
     * @param source The collection of doubles.
     * @return A doubles collection containing the provided doubles.
     */
    protected abstract T createDoubleCollection(NumericCollection<Double> source);

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
     * Verifies that a doubles collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnADoubleCollectionWithTheProvidedElementCardinality() {
        DoubleCollection source = DoubleCollection.of(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE);
        T actual = createDoubleCollection(DISTINCT_ELEMENTS, source);
        DoubleCollection expected = DoubleCollection.of(1D, 2D, DOUBLE_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
