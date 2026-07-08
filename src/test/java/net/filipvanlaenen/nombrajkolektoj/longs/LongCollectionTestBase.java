package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class LongCollectionTestBase<T extends NumericCollection<Long>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    /**
     * Creates a longs collection with the provided element cardinality containing the provided longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs to be included in the longs collection.
     * @return A longs collection with the provided element cardinality containing the provided longs.
     */
    protected abstract T createLongCollection(ElementCardinality elementCardinality, Long... numbers);

    /**
     * Creates a longs collection from a collection of longs with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of longs.
     * @return A longs collection containing the provided longs with the provided element cardinality.
     */
    protected abstract T createLongCollection(ElementCardinality elementCardinality,
            NumericCollection<Long> source);

    /**
     * Creates a longs collection from a collection of longs.
     *
     * @param source The collection of longs.
     * @return A longs collection containing the provided longs.
     */
    protected abstract T createLongCollection(NumericCollection<Long> source);

    /**
     * Verifies that a longs collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnALongCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createLongCollection(DISTINCT_ELEMENTS, 1L).getElementCardinality());
    }

    /**
     * Verifies that a longs collection created from another collection has the same element cardinality and longs.
     */
    @Test
    public void ofWithCollectionShouldReturnALongCollectionWithTheSameElementCardinalityAndLongs() {
        LongCollection source = LongCollection.of(DISTINCT_ELEMENTS, 1L);
        T actual = createLongCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1L));
    }

    /**
     * Verifies that a longs collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnALongCollectionWithTheProvidedElementCardinality() {
        LongCollection source = LongCollection.of(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE);
        T actual = createLongCollection(DISTINCT_ELEMENTS, source);
        LongCollection expected = LongCollection.of(1L, 2L, LONG_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
