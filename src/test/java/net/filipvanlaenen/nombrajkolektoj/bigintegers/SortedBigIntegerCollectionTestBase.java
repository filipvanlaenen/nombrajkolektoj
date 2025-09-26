package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.SortedBigIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedBigIntegerCollectionTestBase<T extends SortedNumericCollection<BigInteger>>
        extends OrderedBigIntegerCollectionTestBase<T> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    /**
     * Creates a sorted BigIntegers collection containing the provided BigIntegers.
     *
     * @param numbers    The BigIntegers to be included in the sorted BigIntegers collection.
     * @param comparator The comparator for the BigIntegers.
     * @return An sorted BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createSortedBigIntegerCollection(Comparator<BigInteger> comparator, BigInteger... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedBigIntegerCollection(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BIG_INTEGER_THREE, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getGreaterThan(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getGreaterThanOrEqualTo(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.ONE, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getLessThan(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getLessThanOrEqualTo(BigInteger.TWO));
    }
}
