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
     * Creates a sorted longs collection containing the provided longs.
     *
     * @param longs    The longs to be included in the sorted longs collection.
     * @param comparator The comparator for the longs.
     * @return An sorted longs collection containing the provided longs.
     */
    protected abstract T createSortedLongCollection(Comparator<Long> comparator, Long... longs);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedLongCollection(Comparator.naturalOrder(), 1L, 2L);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
