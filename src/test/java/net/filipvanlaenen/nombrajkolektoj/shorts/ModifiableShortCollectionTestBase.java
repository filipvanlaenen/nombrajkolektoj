package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableShortCollectionTestBase<T extends ModifiableNumericCollection<Short>>
        extends ShortCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add((short) 1));
        assertFalse(collection.add((short) 1));
        assertTrue(collection.contains((short) 1));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createShortCollection((short) 1)));
        assertFalse(collection.addAll(createShortCollection((short) 1)));
        assertTrue(collection.contains((short) 1));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection((short) 1);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.remove((short) 1));
        assertFalse(collection.remove((short) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.removeAll(createShortCollection((short) 1)));
        assertFalse(collection.removeAll(createShortCollection((short) 1)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.removeIf(l -> l == (short) 1));
        assertFalse(collection.removeIf(l -> l == (short) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createShortCollection((short) 1, (short) 2);
        assertFalse(collection.retainAll(createShortCollection((short) 1, (short) 2)));
        assertTrue(collection.retainAll(createShortCollection((short) 1)));
        assertEquals(1, collection.size());
    }
}
