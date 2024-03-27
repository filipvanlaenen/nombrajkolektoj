package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} class.
 */
public final class ModifiableIntegerCollectionTest extends IntegerCollectionTestBase<ModifiableIntegerCollection> {
    @Override
    protected ModifiableIntegerCollection createEmptyIntegerCollection() {
        return ModifiableIntegerCollection.empty();
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new ModifiableIntegerCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... integers) {
        return ModifiableIntegerCollection.of(elementCardinality, integers);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final Integer... integers) {
        return ModifiableIntegerCollection.of(integers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1));
        assertFalse(collection.add(1));
        assertTrue(collection.contains(1));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createIntegerCollection(1)));
        assertFalse(collection.addAll(createIntegerCollection(1)));
        assertTrue(collection.contains(1));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(1);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(1, 2);
        assertTrue(collection.remove(1));
        assertFalse(collection.remove(1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(1, 2);
        assertTrue(collection.removeAll(createIntegerCollection(1)));
        assertFalse(collection.removeAll(createIntegerCollection(1)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(1, 2);
        assertTrue(collection.removeIf(i -> i == 1));
        assertFalse(collection.removeIf(i -> i == 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableIntegerCollection collection = createIntegerCollection(1, 2);
        assertFalse(collection.retainAll(createIntegerCollection(1, 2)));
        assertTrue(collection.retainAll(createIntegerCollection(1)));
        assertEquals(1, collection.size());
    }
}
