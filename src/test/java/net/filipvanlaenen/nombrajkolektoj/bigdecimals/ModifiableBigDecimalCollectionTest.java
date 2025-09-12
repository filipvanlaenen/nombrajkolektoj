package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} class.
 */
public final class ModifiableBigDecimalCollectionTest extends BigDecimalCollectionTestBase<ModifiableBigDecimalCollection> {
    @Override
    protected ModifiableBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableBigDecimalCollection.empty();
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new ModifiableBigDecimalCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(numbers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(BigDecimal.ONE));
        assertFalse(collection.add(BigDecimal.ONE));
        assertTrue(collection.contains(BigDecimal.ONE));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertFalse(collection.addAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertTrue(collection.contains(BigDecimal.ONE));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(BigDecimal.ONE);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertTrue(collection.remove(BigDecimal.ONE));
        assertFalse(collection.remove(BigDecimal.ONE));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertTrue(collection.removeAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertFalse(collection.removeAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertTrue(collection.removeIf(l -> l == BigDecimal.ONE));
        assertFalse(collection.removeIf(l -> l == BigDecimal.ONE));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigDecimalCollection collection = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertFalse(collection.retainAll(createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L))));
        assertTrue(collection.retainAll(createBigDecimalCollection(BigDecimal.ONE)));
        assertEquals(1, collection.size());
    }
}
