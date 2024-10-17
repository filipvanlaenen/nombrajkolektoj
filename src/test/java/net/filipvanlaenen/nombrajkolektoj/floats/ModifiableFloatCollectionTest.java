package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} class.
 */
public final class ModifiableFloatCollectionTest extends FloatCollectionTestBase<ModifiableFloatCollection> {
    @Override
    protected ModifiableFloatCollection createEmptyFloatCollection() {
        return ModifiableFloatCollection.empty();
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final Collection<Float> source) {
        return new ModifiableFloatCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... floats) {
        return ModifiableFloatCollection.of(elementCardinality, floats);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final Float... integers) {
        return ModifiableFloatCollection.of(integers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1F));
        assertFalse(collection.add(1F));
        assertTrue(collection.contains(1F));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createFloatCollection(1F)));
        assertFalse(collection.addAll(createFloatCollection(1F)));
        assertTrue(collection.contains(1F));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(1F);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(1F, 2F);
        assertTrue(collection.remove(1F));
        assertFalse(collection.remove(1F));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(1F, 2F);
        assertTrue(collection.removeAll(createFloatCollection(1F)));
        assertFalse(collection.removeAll(createFloatCollection(1F)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(1F, 2F);
        assertTrue(collection.removeIf(l -> l == 1F));
        assertFalse(collection.removeIf(l -> l == 1F));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableFloatCollection collection = createFloatCollection(1F, 2F);
        assertFalse(collection.retainAll(createFloatCollection(1F, 2F)));
        assertTrue(collection.retainAll(createFloatCollection(1F)));
        assertEquals(1, collection.size());
    }
}
