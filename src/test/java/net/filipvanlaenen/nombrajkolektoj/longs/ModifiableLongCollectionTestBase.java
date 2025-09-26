package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableLongCollectionTestBase<T extends ModifiableNumericCollection<Long>>
        extends LongCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1L));
        assertFalse(collection.add(1L));
        assertTrue(collection.contains(1L));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createLongCollection(1L)));
        assertFalse(collection.addAll(createLongCollection(1L)));
        assertTrue(collection.contains(1L));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(1L);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(1L, 2L);
        assertTrue(collection.remove(1L));
        assertFalse(collection.remove(1L));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(1L, 2L);
        assertTrue(collection.removeAll(createLongCollection(1L)));
        assertFalse(collection.removeAll(createLongCollection(1L)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(1L, 2L);
        assertTrue(collection.removeIf(l -> l == 1L));
        assertFalse(collection.removeIf(l -> l == 1L));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createLongCollection(1L, 2L);
        assertFalse(collection.retainAll(createLongCollection(1L, 2L)));
        assertTrue(collection.retainAll(createLongCollection(1L)));
        assertEquals(1, collection.size());
    }
}
