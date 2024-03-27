package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class IntegerCollectionTestBase<T extends NumericCollection<Integer>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final NumericCollection<Integer> collection123 = createIntegerCollection(1, 2, 3);

    /**
     * Creates an empty integer collection.
     *
     * @return An empty integer collection.
     */
    protected abstract T createEmptyIntegerCollection();

    /**
     * Creates an integer collection from a collection of integers.
     *
     * @param source The collection of integers.
     * @return An integer collection containing the provided integers.
     */
    protected abstract T createIntegerCollection(Collection<Integer> source);

    /**
     * Creates an integer collection with the provided element cardinality containing the provided integers.
     *
     * @param elementCardinality The element cardinality.
     * @param integers           The integers to be included in the integer collection.
     * @return An integer collection with the provided element cardinality containing the provided integers.
     */
    protected abstract T createIntegerCollection(ElementCardinality elementCardinality, Integer... integers);

    /**
     * Creates an integer collection containing the provided integers.
     *
     * @param integers The integers to be included in the integer collection.
     * @return An integer collection containing the provided integers.
     */
    protected abstract T createIntegerCollection(Integer... integers);

    /**
     * Verifies that an empty integer collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyIntegerCollection() {
        assertTrue(createEmptyIntegerCollection().isEmpty());
    }

    /**
     * Verifies that an integer collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAnIntegerCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createIntegerCollection(DISTINCT_ELEMENTS, 1).getElementCardinality());
    }

    /**
     * Verifies that an integer collection created from another collection has the same element cardinality and
     * integers.
     */
    @Test
    public void ofWithCollectionShouldReturnAnIntegerCollectionWithTheSameElementCardinalityAndIntegers() {
        Collection<Integer> source = Collection.of(DISTINCT_ELEMENTS, 1);
        T actual = createIntegerCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(1));
        assertFalse(collection123.contains(0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createIntegerCollection(1)));
        assertFalse(collection123.containsAll(createIntegerCollection(0)));
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
