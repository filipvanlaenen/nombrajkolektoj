package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableFloatCollectionTestBase<T extends ModifiableNumericCollection<Float>>
        extends FloatCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1F));
        assertFalse(collection.add(1F));
        assertTrue(collection.contains(1F));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createFloatCollection(1F)));
        assertFalse(collection.addAll(createFloatCollection(1F)));
        assertTrue(collection.contains(1F));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(1F);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(1F, 2F);
        assertTrue(collection.remove(1F));
        assertFalse(collection.remove(1F));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(1F, 2F);
        assertTrue(collection.removeAll(createFloatCollection(1F)));
        assertFalse(collection.removeAll(createFloatCollection(1F)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(1F, 2F);
        assertTrue(collection.removeIf(l -> l == 1F));
        assertFalse(collection.removeIf(l -> l == 1F));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createFloatCollection(1F, 2F);
        assertFalse(collection.retainAll(createFloatCollection(1F, 2F)));
        assertTrue(collection.retainAll(createFloatCollection(1F)));
        assertEquals(1, collection.size());
    }
}
