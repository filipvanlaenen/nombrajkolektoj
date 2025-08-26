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
}
