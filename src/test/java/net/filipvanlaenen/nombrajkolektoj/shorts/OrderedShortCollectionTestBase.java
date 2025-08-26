package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedShortCollectionTestBase<T extends OrderedNumericCollection<Short>>
        extends ShortCollectionTestBase<T> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    /**
     * Creates an ordered shorts collection containing the provided shorts.
     *
     * @param numbers The shorts to be included in the ordered shorts collection.
     * @return An ordered shorts collection containing the provided shorts.
     */
    protected abstract T createOrderedShortCollection(Short... numbers);

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }
}
