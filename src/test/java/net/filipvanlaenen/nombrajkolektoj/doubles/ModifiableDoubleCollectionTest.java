package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} class.
 */
public final class ModifiableDoubleCollectionTest extends DoubleCollectionTestBase<ModifiableDoubleCollection> {
    @Override
    protected ModifiableDoubleCollection createEmptyDoubleCollection() {
        return ModifiableDoubleCollection.empty();
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new ModifiableDoubleCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableDoubleCollection.of(numbers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(1D));
        assertFalse(collection.add(1D));
        assertTrue(collection.contains(1D));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createDoubleCollection(1D)));
        assertFalse(collection.addAll(createDoubleCollection(1D)));
        assertTrue(collection.contains(1D));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(1D);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.remove(1D));
        assertFalse(collection.remove(1D));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.removeAll(createDoubleCollection(1D)));
        assertFalse(collection.removeAll(createDoubleCollection(1D)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(1D, 2D);
        assertTrue(collection.removeIf(l -> l == 1D));
        assertFalse(collection.removeIf(l -> l == 1D));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableDoubleCollection collection = createDoubleCollection(1D, 2D);
        assertFalse(collection.retainAll(createDoubleCollection(1D, 2D)));
        assertTrue(collection.retainAll(createDoubleCollection(1D)));
        assertEquals(1, collection.size());
    }
}
