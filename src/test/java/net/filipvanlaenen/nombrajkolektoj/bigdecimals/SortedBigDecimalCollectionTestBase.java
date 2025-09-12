package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedBigDecimalCollectionTestBase<T extends SortedNumericCollection<BigDecimal>>
        extends OrderedBigDecimalCollectionTestBase<T> {
    /**
     * Creates a sorted BigDecimals collection containing the provided BigDecimals.
     *
     * @param numbers    The BigDecimals to be included in the sorted BigDecimals collection.
     * @param comparator The comparator for the BigDecimals.
     * @return An sorted BigDecimals collection containing the provided BigDecimals.
     */
    protected abstract T createSortedBigDecimalCollection(Comparator<BigDecimal> comparator, BigDecimal... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedBigDecimalCollection(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
