package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
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
     * Creates an ordered doubles collection containing the provided doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles to be included in the ordered doubles collection.
     * @return An ordered doubles collection containing the provided doubles.
     */
    protected abstract T createOrderedDoubleCollection(ElementCardinality elementCardinality, Double... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).firstIndexOf(2D));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createOrderedDoubleCollection(1D, 2D, DOUBLE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedDoubleCollection(1D, 2D, DOUBLE_THREE).indexOf(2D));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).lastIndexOf(2D));
    }
}
