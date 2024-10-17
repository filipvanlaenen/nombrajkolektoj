package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class LongCollectionTestBase<T extends NumericCollection<Long>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final NumericCollection<Long> collection123 = createLongCollection(1L, 2L, 3L);

    /**
     * Creates an empty longs collection.
     *
     * @return An empty longs collection.
     */
    protected abstract T createEmptyLongCollection();

    /**
     * Creates a longs collection from a collection of longs.
     *
     * @param source The collection of longs.
     * @return A longs collection containing the provided longs.
     */
    protected abstract T createLongCollection(Collection<Long> source);

    /**
     * Creates a longs collection with the provided element cardinality containing the provided longs.
     *
     * @param elementCardinality The element cardinality.
     * @param longs            The longs to be included in the longs collection.
     * @return A longs collection with the provided element cardinality containing the provided longs.
     */
    protected abstract T createLongCollection(ElementCardinality elementCardinality, Long... longs);

    /**
     * Creates a longs collection containing the provided longs.
     *
     * @param longs The longs to be included in the longs collection.
     * @return An longs collection containing the provided longs.
     */
    protected abstract T createLongCollection(Long... longs);

    /**
     * Verifies that an empty longs collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyLongCollection() {
        assertTrue(createEmptyLongCollection().isEmpty());
    }

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
        Collection<Long> source = Collection.of(DISTINCT_ELEMENTS, 1L);
        T actual = createLongCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1L));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(1L));
        assertFalse(collection123.contains(0L));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createLongCollection(1L)));
        assertFalse(collection123.containsAll(createLongCollection(0L)));
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
