package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ShortCollectionTestBase<T extends ShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    /**
     * Creates a shorts collection with the provided shorts.
     *
     * @param numbers The shorts to be included in the shorts collection.
     * @return A shorts collection with the provided shorts.
     */
    protected abstract T createShortCollection(Short... numbers);

    /**
     * Creates a shorts collection with the provided element cardinality containing the provided shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts to be included in the shorts collection.
     * @return A shorts collection with the provided element cardinality containing the provided shorts.
     */
    protected abstract T createShortCollection(ElementCardinality elementCardinality, Short... numbers);

    /**
     * Creates a shorts collection from a collection of shorts with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of shorts.
     * @return A shorts collection containing the provided shorts with the provided element cardinality.
     */
    protected abstract T createShortCollection(ElementCardinality elementCardinality, T source);

    /**
     * Creates a shorts collection from a collection of shorts.
     *
     * @param source The collection of shorts.
     * @return A shorts collection containing the provided shorts.
     */
    protected abstract T createShortCollection(T source);

    /**
     * Verifies that a shorts collection without a specific element cardinality receives the default element
     * cardinality.
     */
    @Test
    public void ofWithoutElementCardinalityShouldReturnAShortCollectionWithTheDefaultCardinality() {
        assertEquals(DUPLICATE_ELEMENTS, createShortCollection((short) 1).getElementCardinality());
    }

    /**
     * Verifies that a shorts collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAShortCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createShortCollection(DISTINCT_ELEMENTS, (short) 1).getElementCardinality());
    }

    /**
     * Verifies that a shorts collection created from another collection has the same element cardinality and shorts.
     */
    @Test
    public void ofWithCollectionShouldReturnAShortCollectionWithTheSameElementCardinalityAndShorts() {
        T source = createShortCollection(DISTINCT_ELEMENTS, (short) 1);
        T actual = createShortCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((short) 1));
    }

    /**
     * Verifies that a shorts collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnAShortCollectionWithTheProvidedElementCardinality() {
        T source = createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE);
        T actual = createShortCollection(DISTINCT_ELEMENTS, source);
        ShortCollection expected = ShortCollection.of((short) 1, (short) 2, SHORT_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
