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
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    /**
     * Creates a sorted shorts collection containing the provided shorts.
     *
     * @param numbers    The shorts to be included in the sorted shorts collection.
     * @param comparator The comparator for the shorts.
     * @return An sorted shorts collection containing the provided shorts.
     */
    protected abstract T createSortedShortCollection(Comparator<Short> comparator, Short... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedShortCollection(Comparator.naturalOrder(), (short) 1, (short) 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(SHORT_THREE, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getGreaterThan((short) 2));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getGreaterThanOrEqualTo((short) 2));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 1, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getLessThan((short) 2));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getLessThanOrEqualTo((short) 2));
    }
}
