package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedIntegerCollection(1, 2, INTEGER_THREE).getAt(1));
    }
}
