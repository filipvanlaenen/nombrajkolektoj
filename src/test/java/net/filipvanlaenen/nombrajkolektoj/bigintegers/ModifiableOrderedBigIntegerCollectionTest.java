package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableOrderedBigIntegerCollection} class.
 */
public final class ModifiableOrderedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableOrderedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new ModifiableOrderedBigIntegerCollection.ArrayCollection(
                OrderedBigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableOrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableOrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableOrderedBigIntegerCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertTrue(collection.addAllAt(1, createBigIntegerCollection(BigInteger.TWO)));
        assertFalse(collection.addAllAt(1, createBigIntegerCollection(BigInteger.TWO)));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertTrue(collection.addAt(1, BigInteger.TWO));
        assertFalse(collection.addAt(1, BigInteger.TWO));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).firstIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).indexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).lastIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertEquals(BIG_INTEGER_THREE, collection.putAt(1, BigInteger.TWO));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).removeAt(1));
    }
}
