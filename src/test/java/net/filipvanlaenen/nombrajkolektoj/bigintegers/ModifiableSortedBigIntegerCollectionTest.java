package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableSortedBigIntegerCollection} class.
 */
public final class ModifiableSortedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableSortedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new ModifiableSortedBigIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(),
                BigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableSortedBigIntegerCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted BigIntegers collection containing the provided BigIntegers.
     *
     * @param numbers    The BigIntegers to be included in the modifiable sorted BigIntegers collection.
     * @param comparator The comparator for the BigIntegers.
     * @return An modifiable sorted BigIntegers collection containing the provided BigIntegers.
     */
    private ModifiableSortedBigIntegerCollection createSortedBigIntegerCollection(final Comparator<BigInteger> comparator,
            final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedBigIntegerCollection collection = createSortedBigIntegerCollection(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BIG_INTEGER_THREE, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getGreaterThan(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getGreaterThanOrEqualTo(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.ONE, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getLessThan(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getLessThanOrEqualTo(BigInteger.TWO));
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
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).removeAt(1));
    }
}
