package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 */
public class LongCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private static final LongCollection COLLECTION123 = LongCollection.of(1L, 2L, 3L);

    /**
     * Verifies that an empty longs collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyLongCollection() {
        assertTrue(LongCollection.empty().isEmpty());
    }

    /**
     * Verifies that an longs collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAnLongsCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, LongCollection.of(DISTINCT_ELEMENTS, 1L).getElementCardinality());
    }

    /**
     * Verifies that an longs collection created from another collection has the same element cardinality and longs.
     */
    @Test
    public void ofWithCollectionShouldReturnAnLongsCollectionWithTheSameElementCardinalityAndLongs() {
        Collection<Long> source = Collection.of(DISTINCT_ELEMENTS, 1L);
        LongCollection actual = new LongCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1L));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(1L));
        assertFalse(COLLECTION123.contains(0L));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(LongCollection.of(1L)));
        assertFalse(COLLECTION123.containsAll(LongCollection.of(0L)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(COLLECTION123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, COLLECTION123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, COLLECTION123.toArray().length);
    }
}
