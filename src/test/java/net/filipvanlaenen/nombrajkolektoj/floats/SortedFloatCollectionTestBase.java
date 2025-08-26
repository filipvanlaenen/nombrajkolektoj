package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedFloatCollectionTestBase<T extends SortedNumericCollection<Float>>
        extends OrderedFloatCollectionTestBase<T> {
    /**
     * Creates a sorted floats collection containing the provided floats.
     *
     * @param floats    The floats to be included in the sorted floats collection.
     * @param comparator The comparator for the floats.
     * @return An sorted floats collection containing the provided floats.
     */
    protected abstract T createSortedFloatCollection(Comparator<Float> comparator, Float... floats);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedFloatCollection(Comparator.naturalOrder(), 1F, 2F);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
