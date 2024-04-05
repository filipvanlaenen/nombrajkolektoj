package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 */
public class ShortCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private static final ShortCollection COLLECTION123 = ShortCollection.of((short) 1, (short) 2, (short) 3);

    /**
     * Verifies that an empty shorts collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyShortCollection() {
        assertTrue(ShortCollection.empty().isEmpty());
    }

    /**
     * Verifies that a shorts collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAShortsCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, ShortCollection.of(DISTINCT_ELEMENTS, (short) 1).getElementCardinality());
    }

    /**
     * Verifies that a shorts collection created from another collection has the same element cardinality and shorts.
     */
    @Test
    public void ofWithCollectionShouldReturnAShortsCollectionWithTheSameElementCardinalityAndShorts() {
        Collection<Short> source = Collection.of(DISTINCT_ELEMENTS, (short) 1);
        ShortCollection actual = new ShortCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((short) 1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains((short) 1));
        assertFalse(COLLECTION123.contains((short) 0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(ShortCollection.of((short) 1)));
        assertFalse(COLLECTION123.containsAll(ShortCollection.of((short) 0)));
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
