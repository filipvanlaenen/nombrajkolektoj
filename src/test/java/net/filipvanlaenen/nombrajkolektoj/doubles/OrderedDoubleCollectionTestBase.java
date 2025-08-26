package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedDoubleCollectionTestBase<T extends OrderedNumericCollection<Double>>
        extends DoubleCollectionTestBase<T> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    /**
     * Creates an ordered doubles collection containing the provided doubles.
     *
     * @param numbers The doubles to be included in the ordered doubles collection.
     * @return An ordered doubles collection containing the provided doubles.
     */
    protected abstract T createOrderedDoubleCollection(Double... numbers);

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createOrderedDoubleCollection(1D, 2D, DOUBLE_THREE).getAt(1));
    }
}
