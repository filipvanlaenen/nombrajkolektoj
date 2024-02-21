package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 */
public class IntegerCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private static final IntegerCollection COLLECTION123 = IntegerCollection.of(1, 2, 3);

    /**
     * Verifies that an empty integer collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyIntegerCollection() {
        assertTrue(IntegerCollection.empty().isEmpty());
    }

    /**
     * Verifies that an integer collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAnIntegerCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, IntegerCollection.of(DISTINCT_ELEMENTS, 1).getElementCardinality());
    }

    /**
     * Verifies that an integer collection created from another collection has the same element cardinality and
     * integers.
     */
    @Test
    public void ofWithCollectionShouldReturnAnIntegerCollectionWithTheSameElementCardinalityAndIntegers() {
        Collection<Integer> source = Collection.of(DISTINCT_ELEMENTS, 1);
        IntegerCollection actual = new IntegerCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(1));
        assertFalse(COLLECTION123.contains(0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(IntegerCollection.of(1)));
        assertFalse(COLLECTION123.containsAll(IntegerCollection.of(0)));
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
