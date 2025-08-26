package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedFloatCollectionTestBase<T extends OrderedNumericCollection<Float>>
        extends FloatCollectionTestBase<T> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    /**
     * Creates an ordered floats collection containing the provided floats.
     *
     * @param numbers The floats to be included in the ordered floats collection.
     * @return An ordered floats collection containing the provided floats.
     */
    protected abstract T createOrderedFloatCollection(Float... numbers);

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createOrderedFloatCollection(1F, 2F, FLOAT_THREE).getAt(1));
    }
}
