package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.SortedIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedIntegerCollectionTestBase<T extends SortedNumericCollection<Integer>>
        extends OrderedIntegerCollectionTestBase<T> {
    /**
     * Creates a sorted integers collection containing the provided integers.
     *
     * @param integers    The integers to be included in the sorted integers collection.
     * @param comparator The comparator for the integers.
     * @return An sorted integers collection containing the provided integers.
     */
    protected abstract T createSortedIntegerCollection(Comparator<Integer> comparator, Integer... integers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedIntegerCollection(Comparator.naturalOrder(), 1, 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
