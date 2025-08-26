package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerCollection} class.
 */
public final class ModifiableBigIntegerCollectionTest extends BigIntegerCollectionTestBase<ModifiableBigIntegerCollection> {
    @Override
    protected ModifiableBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableBigIntegerCollection.empty();
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new ModifiableBigIntegerCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(numbers);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add(BigInteger.ONE));
        assertFalse(collection.add(BigInteger.ONE));
        assertTrue(collection.contains(BigInteger.ONE));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createBigIntegerCollection(BigInteger.ONE)));
        assertFalse(collection.addAll(createBigIntegerCollection(BigInteger.ONE)));
        assertTrue(collection.contains(BigInteger.ONE));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(BigInteger.ONE);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        assertTrue(collection.remove(BigInteger.ONE));
        assertFalse(collection.remove(BigInteger.ONE));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        assertTrue(collection.removeAll(createBigIntegerCollection(BigInteger.ONE)));
        assertFalse(collection.removeAll(createBigIntegerCollection(BigInteger.ONE)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        assertTrue(collection.removeIf(l -> l == BigInteger.ONE));
        assertFalse(collection.removeIf(l -> l == BigInteger.ONE));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableBigIntegerCollection collection = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        assertFalse(collection.retainAll(createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO)));
        assertTrue(collection.retainAll(createBigIntegerCollection(BigInteger.ONE)));
        assertEquals(1, collection.size());
    }
}
