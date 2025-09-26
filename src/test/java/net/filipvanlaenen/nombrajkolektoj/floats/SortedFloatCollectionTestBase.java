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
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    /**
     * Creates a sorted floats collection containing the provided floats.
     *
     * @param numbers    The floats to be included in the sorted floats collection.
     * @param comparator The comparator for the floats.
     * @return An sorted floats collection containing the provided floats.
     */
    protected abstract T createSortedFloatCollection(Comparator<Float> comparator, Float... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedFloatCollection(Comparator.naturalOrder(), 1F, 2F);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(FLOAT_THREE, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getGreaterThan(2F));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getGreaterThanOrEqualTo(2F));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1F, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getLessThan(2F));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getLessThanOrEqualTo(2F));
    }
}
