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
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;

    /**
     * Creates a sorted integers collection containing the provided integers.
     *
     * @param numbers    The integers to be included in the sorted integers collection.
     * @param comparator The comparator for the integers.
     * @return An sorted integers collection containing the provided integers.
     */
    protected abstract T createSortedIntegerCollection(Comparator<Integer> comparator, Integer... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedIntegerCollection(Comparator.naturalOrder(), 1, 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(INTEGER_THREE, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getGreaterThan(2));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getGreaterThanOrEqualTo(2));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getLessThan(2));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getLessThanOrEqualTo(2));
    }
}
