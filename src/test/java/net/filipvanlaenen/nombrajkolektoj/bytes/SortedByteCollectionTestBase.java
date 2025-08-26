package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */

public abstract class SortedByteCollectionTestBase<T extends SortedNumericCollection<Byte>>
        extends OrderedByteCollectionTestBase<T> {
    /**
     * Creates a sorted bytes collection containing the provided bytes.
     *
     * @param numbers    The bytes to be included in the sorted bytes collection.
     * @param comparator The comparator for the bytes.
     * @return An sorted bytes collection containing the provided bytes.
     */
    protected abstract T createSortedByteCollection(Comparator<Byte> comparator, Byte... numbers);

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createSortedByteCollection(Comparator.naturalOrder(), (byte) 1, (byte) 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }
}
