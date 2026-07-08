package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class IntegerCollectionTestBase<T extends IntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;

    /**
     * Creates a integers collection with the provided element cardinality containing the provided integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers to be included in the integers collection.
     * @return A integers collection with the provided element cardinality containing the provided integers.
     */
    protected abstract T createIntegerCollection(ElementCardinality elementCardinality, Integer... numbers);

    /**
     * Creates a integers collection from a collection of integers with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of integers.
     * @return A integers collection containing the provided integers with the provided element cardinality.
     */
    protected abstract T createIntegerCollection(ElementCardinality elementCardinality, T source);

    /**
     * Creates a integers collection from a collection of integers.
     *
     * @param source The collection of integers.
     * @return A integers collection containing the provided integers.
     */
    protected abstract T createIntegerCollection(T source);

    /**
     * Verifies that a integers collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAIntegerCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createIntegerCollection(DISTINCT_ELEMENTS, 1).getElementCardinality());
    }

    /**
     * Verifies that a integers collection created from another collection has the same element cardinality and integers.
     */
    @Test
    public void ofWithCollectionShouldReturnAIntegerCollectionWithTheSameElementCardinalityAndIntegers() {
        T source = createIntegerCollection(DISTINCT_ELEMENTS, 1);
        T actual = createIntegerCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1));
    }

    /**
     * Verifies that a integers collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnAIntegerCollectionWithTheProvidedElementCardinality() {
        T source = createIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE);
        T actual = createIntegerCollection(DISTINCT_ELEMENTS, source);
        IntegerCollection expected = IntegerCollection.of(1, 2, INTEGER_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
