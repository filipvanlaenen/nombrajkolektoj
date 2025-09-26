package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedLongCollectionTestBase<T extends SortedNumericCollection<Long>>
        extends OrderedLongCollectionTestBase<T> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    /**
     * Creates a sorted longs collection containing the provided longs.
     *
     * @param numbers    The longs to be included in the sorted longs collection.
     * @param comparator The comparator for the longs.
     * @return An sorted longs collection containing the provided longs.
     */
    protected abstract T createSortedLongCollection(Comparator<Long> comparator, Long... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedLongCollection(Comparator.naturalOrder(), 1L, 2L);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(LONG_THREE, createOrderedLongCollection(1L, 2L, LONG_THREE).getGreaterThan(2L));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createOrderedLongCollection(1L, 2L, LONG_THREE).getGreaterThanOrEqualTo(2L));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1L, createOrderedLongCollection(1L, 2L, LONG_THREE).getLessThan(2L));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createOrderedLongCollection(1L, 2L, LONG_THREE).getLessThanOrEqualTo(2L));
    }
}
