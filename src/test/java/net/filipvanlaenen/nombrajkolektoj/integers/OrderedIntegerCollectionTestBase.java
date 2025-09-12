package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedIntegerCollectionTestBase<T extends OrderedNumericCollection<Integer>>
        extends IntegerCollectionTestBase<T> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;

    /**
     * Creates an ordered integers collection containing the provided integers.
     *
     * @param numbers The integers to be included in the ordered integers collection.
     * @return An ordered integers collection containing the provided integers.
     */
    protected abstract T createOrderedIntegerCollection(Integer... numbers);

    /**
     * Creates an ordered integers collection containing the provided integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers to be included in the ordered integers collection.
     * @return An ordered integers collection containing the provided integers.
     */
    protected abstract T createOrderedIntegerCollection(ElementCardinality elementCardinality, Integer... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).firstIndexOf(2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedIntegerCollection(1, 2, INTEGER_THREE).indexOf(2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).lastIndexOf(2));
    }
}
