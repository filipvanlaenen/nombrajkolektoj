package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableDoubleCollectionTestBase<T extends ModifiableNumericCollection<Double>>
        extends DoubleCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1D));
        assertFalse(collection.add(1D));
        assertTrue(collection.contains(1D));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createDoubleCollection(1D)));
        assertFalse(collection.addAll(createDoubleCollection(1D)));
        assertTrue(collection.contains(1D));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(1D);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.remove(1D));
        assertFalse(collection.remove(1D));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.removeAll(createDoubleCollection(1D)));
        assertFalse(collection.removeAll(createDoubleCollection(1D)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.removeIf(l -> l == 1D));
        assertFalse(collection.removeIf(l -> l == 1D));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createDoubleCollection(1D, 2D);
        assertFalse(collection.retainAll(createDoubleCollection(1D, 2D)));
        assertTrue(collection.retainAll(createDoubleCollection(1D)));
        assertEquals(1, collection.size());
    }
}
