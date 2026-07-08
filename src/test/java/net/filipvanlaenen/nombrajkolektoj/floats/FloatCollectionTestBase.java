package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class FloatCollectionTestBase<T extends NumericCollection<Float>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    /**
     * Creates a floats collection with the provided element cardinality containing the provided floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats to be included in the floats collection.
     * @return A floats collection with the provided element cardinality containing the provided floats.
     */
    protected abstract T createFloatCollection(ElementCardinality elementCardinality, Float... numbers);

    /**
     * Creates a floats collection from a collection of floats with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of floats.
     * @return A floats collection containing the provided floats with the provided element cardinality.
     */
    protected abstract T createFloatCollection(ElementCardinality elementCardinality,
            NumericCollection<Float> source);

    /**
     * Creates a floats collection from a collection of floats.
     *
     * @param source The collection of floats.
     * @return A floats collection containing the provided floats.
     */
    protected abstract T createFloatCollection(NumericCollection<Float> source);

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
     * Verifies that a floats collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnAFloatCollectionWithTheProvidedElementCardinality() {
        FloatCollection source = FloatCollection.of(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE);
        T actual = createFloatCollection(DISTINCT_ELEMENTS, source);
        FloatCollection expected = FloatCollection.of(1F, 2F, FLOAT_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
