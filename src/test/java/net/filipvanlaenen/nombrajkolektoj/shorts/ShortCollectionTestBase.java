package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ShortCollectionTestBase<T extends NumericCollection<Short>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final NumericCollection<Short> collection123 = createShortCollection((short) 1, (short) 2, (short) 3);

    /**
     * Creates an empty shorts collection.
     *
     * @return An empty shorts collection.
     */
    protected abstract T createEmptyShortCollection();

    /**
     * Creates a shorts collection from a collection of shorts.
     *
     * @param source The collection of shorts.
     * @return A shorts collection containing the provided shorts.
     */
    protected abstract T createShortCollection(Collection<Short> source);

    /**
     * Creates a shorts collection with the provided element cardinality containing the provided shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param shorts            The shorts to be included in the shorts collection.
     * @return A shorts collection with the provided element cardinality containing the provided shorts.
     */
    protected abstract T createShortCollection(ElementCardinality elementCardinality, Short... shorts);

    /**
     * Creates a shorts collection containing the provided shorts.
     *
     * @param shorts The shorts to be included in the shorts collection.
     * @return An shorts collection containing the provided shorts.
     */
    protected abstract T createShortCollection(Short... shorts);

    /**
     * Verifies that an empty shorts collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyShortCollection() {
        assertTrue(createEmptyShortCollection().isEmpty());
    }

    /**
     * Verifies that a shorts collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAShortCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createShortCollection(DISTINCT_ELEMENTS, (short) 1).getElementCardinality());
    }

    /**
     * Verifies that a shorts collection created from another collection has the same element cardinality and shorts.
     */
    @Test
    public void ofWithCollectionShouldReturnAShortCollectionWithTheSameElementCardinalityAndShorts() {
        Collection<Short> source = Collection.of(DISTINCT_ELEMENTS, (short) 1);
        T actual = createShortCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((short) 1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains((short) 1));
        assertFalse(collection123.contains((short) 0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createShortCollection((short) 1)));
        assertFalse(collection123.containsAll(createShortCollection((short) 0)));
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
