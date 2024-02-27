package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} class.
 */
public class DoubleCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the doubles 1D, 2D and 3D.
     */
    private static final DoubleCollection COLLECTION123 = DoubleCollection.of(1D, 2D, 3D);

    /**
     * Verifies that an empty doubles collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyDoublesCollection() {
        assertTrue(DoubleCollection.empty().isEmpty());
    }

    /**
     * Verifies that a doubles collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnADoublesCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, DoubleCollection.of(DISTINCT_ELEMENTS, 1D).getElementCardinality());
    }

    /**
     * Verifies that a doubles collection created from another collection has the same element cardinality and integers.
     */
    @Test
    public void ofWithCollectionShouldReturnADoublesCollectionWithTheSameElementCardinalityAndDoubles() {
        Collection<Double> source = Collection.of(DISTINCT_ELEMENTS, 1D);
        DoubleCollection actual = new DoubleCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1D));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(1D));
        assertFalse(COLLECTION123.contains(0D));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(DoubleCollection.of(1D)));
        assertFalse(COLLECTION123.containsAll(DoubleCollection.of(0D)));
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
