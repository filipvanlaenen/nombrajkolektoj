package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class FloatCollectionTestBase<T extends NumericCollection<Float>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final NumericCollection<Float> collection123 = createFloatCollection(1F, 2F, 3F);

    /**
     * Creates an empty floats collection.
     *
     * @return An empty floats collection.
     */
    protected abstract T createEmptyFloatCollection();

    /**
     * Creates a floats collection from a collection of floats.
     *
     * @param source The collection of floats.
     * @return A floats collection containing the provided floats.
     */
    protected abstract T createFloatCollection(NumericCollection<Float> source);

    /**
     * Creates a floats collection with the provided element cardinality containing the provided floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats to be included in the floats collection.
     * @return A floats collection with the provided element cardinality containing the provided floats.
     */
    protected abstract T createFloatCollection(ElementCardinality elementCardinality, Float... numbers);

    /**
     * Creates a floats collection containing the provided floats.
     *
     * @param numbers The floats to be included in the floats collection.
     * @return An floats collection containing the provided floats.
     */
    protected abstract T createFloatCollection(Float... numbers);

    /**
     * Verifies that an empty floats collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyFloatCollection() {
        assertTrue(createEmptyFloatCollection().isEmpty());
    }

    /**
     * Verifies that a floats collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAFloatCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createFloatCollection(DISTINCT_ELEMENTS, 1F).getElementCardinality());
    }

    /**
     * Verifies that a floats collection created from another collection has the same element cardinality and floats.
     */
    @Test
    public void ofWithCollectionShouldReturnAFloatCollectionWithTheSameElementCardinalityAndFloats() {
        FloatCollection source = FloatCollection.of(DISTINCT_ELEMENTS, 1F);
        T actual = createFloatCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1F));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(1F));
        assertFalse(collection123.contains(0F));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createFloatCollection(1F)));
        assertFalse(collection123.containsAll(createFloatCollection(0F)));
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
