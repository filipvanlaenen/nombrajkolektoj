package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedShortCollectionTestBase<T extends SortedNumericCollection<Short>>
        extends OrderedShortCollectionTestBase<T> {
    /**
     * Creates a sorted shorts collection containing the provided shorts.
     *
     * @param shorts    The shorts to be included in the sorted shorts collection.
     * @param comparator The comparator for the shorts.
     * @return An sorted shorts collection containing the provided shorts.
     */
    protected abstract T createSortedShortCollection(Comparator<Short> comparator, Short... shorts);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedShortCollection(Comparator.naturalOrder(), (short) 1, (short) 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
