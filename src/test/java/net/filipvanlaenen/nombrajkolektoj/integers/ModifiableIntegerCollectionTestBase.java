package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableIntegerCollectionTestBase<T extends ModifiableNumericCollection<Integer>>
        extends IntegerCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1));
        assertFalse(collection.add(1));
        assertTrue(collection.contains(1));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createIntegerCollection(1)));
        assertFalse(collection.addAll(createIntegerCollection(1)));
        assertTrue(collection.contains(1));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(1);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(1, 2);
        assertTrue(collection.remove(1));
        assertFalse(collection.remove(1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(1, 2);
        assertTrue(collection.removeAll(createIntegerCollection(1)));
        assertFalse(collection.removeAll(createIntegerCollection(1)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(1, 2);
        assertTrue(collection.removeIf(l -> l == 1));
        assertFalse(collection.removeIf(l -> l == 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createIntegerCollection(1, 2);
        assertFalse(collection.retainAll(createIntegerCollection(1, 2)));
        assertTrue(collection.retainAll(createIntegerCollection(1)));
        assertEquals(1, collection.size());
    }
}
