package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedDoubleCollectionTestBase<T extends SortedNumericCollection<Double>>
        extends OrderedDoubleCollectionTestBase<T> {
    /**
     * Creates a sorted doubles collection containing the provided doubles.
     *
     * @param numbers    The doubles to be included in the sorted doubles collection.
     * @param comparator The comparator for the doubles.
     * @return An sorted doubles collection containing the provided doubles.
     */
    protected abstract T createSortedDoubleCollection(Comparator<Double> comparator, Double... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedDoubleCollection(Comparator.naturalOrder(), 1D, 2D);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
