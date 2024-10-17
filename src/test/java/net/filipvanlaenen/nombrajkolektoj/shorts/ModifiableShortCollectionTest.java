package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableShortCollection} class.
 */
public final class ModifiableShortCollectionTest extends ShortCollectionTestBase<ModifiableShortCollection> {
    @Override
    protected ModifiableShortCollection createEmptyShortCollection() {
        return ModifiableShortCollection.empty();
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final Collection<Short> source) {
        return new ModifiableShortCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... shorts) {
        return ModifiableShortCollection.of(elementCardinality, shorts);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final Short... integers) {
        return ModifiableShortCollection.of(integers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add((short) 1));
        assertFalse(collection.add((short) 1));
        assertTrue(collection.contains((short) 1));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createShortCollection((short) 1)));
        assertFalse(collection.addAll(createShortCollection((short) 1)));
        assertTrue(collection.contains((short) 1));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection((short) 1);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.remove((short) 1));
        assertFalse(collection.remove((short) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.removeAll(createShortCollection((short) 1)));
        assertFalse(collection.removeAll(createShortCollection((short) 1)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection((short) 1, (short) 2);
        assertTrue(collection.removeIf(l -> l == (short) 1));
        assertFalse(collection.removeIf(l -> l == (short) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableShortCollection collection = createShortCollection((short) 1, (short) 2);
        assertFalse(collection.retainAll(createShortCollection((short) 1, (short) 2)));
        assertTrue(collection.retainAll(createShortCollection((short) 1)));
        assertEquals(1, collection.size());
    }
}
