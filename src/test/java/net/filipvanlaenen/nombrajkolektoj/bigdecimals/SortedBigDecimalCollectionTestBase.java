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
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

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

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BIG_DECIMAL_THREE, createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getGreaterThan(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getGreaterThanOrEqualTo(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.ONE, createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getLessThan(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getLessThanOrEqualTo(BigDecimal.valueOf(2L)));
    }
}
