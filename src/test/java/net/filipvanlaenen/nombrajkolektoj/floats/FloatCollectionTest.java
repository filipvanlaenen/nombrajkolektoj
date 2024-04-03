package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} class.
 */
public class FloatCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the floats 1F, 2F and 3F.
     */
    private static final FloatCollection COLLECTION123 = FloatCollection.of(1F, 2F, 3F);

    /**
     * Verifies that an empty floats collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyFloatsCollection() {
        assertTrue(FloatCollection.empty().isEmpty());
    }

    /**
     * Verifies that a floats collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAFloatsCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, FloatCollection.of(DISTINCT_ELEMENTS, 1F).getElementCardinality());
    }

    /**
     * Verifies that a floats collection created from another collection has the same element cardinality and integers.
     */
    @Test
    public void ofWithCollectionShouldReturnAFloatsCollectionWithTheSameElementCardinalityAndFloats() {
        Collection<Float> source = Collection.of(DISTINCT_ELEMENTS, 1F);
        FloatCollection actual = new FloatCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1F));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(1F));
        assertFalse(COLLECTION123.contains(0F));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(FloatCollection.of(1F)));
        assertFalse(COLLECTION123.containsAll(FloatCollection.of(0F)));
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
