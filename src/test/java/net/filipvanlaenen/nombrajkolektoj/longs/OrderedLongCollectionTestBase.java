package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedLongCollectionTestBase<T extends OrderedNumericCollection<Long>>
        extends LongCollectionTestBase<T> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    /**
     * Creates an ordered longs collection containing the provided longs.
     *
     * @param numbers The longs to be included in the ordered longs collection.
     * @return An ordered longs collection containing the provided longs.
     */
    protected abstract T createOrderedLongCollection(Long... numbers);

    /**
     * Creates an ordered longs collection containing the provided longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs to be included in the ordered longs collection.
     * @return An ordered longs collection containing the provided longs.
     */
    protected abstract T createOrderedLongCollection(ElementCardinality elementCardinality, Long... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).firstIndexOf(2L));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createOrderedLongCollection(1L, 2L, LONG_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedLongCollection(1L, 2L, LONG_THREE).indexOf(2L));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).lastIndexOf(2L));
    }
}
