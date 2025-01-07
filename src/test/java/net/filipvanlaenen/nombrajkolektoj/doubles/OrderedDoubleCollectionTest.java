package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} class.
 */
public final class OrderedDoubleCollectionTest extends DoubleCollectionTestBase<OrderedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    @Override
    protected OrderedDoubleCollection createEmptyDoubleCollection() {
        return OrderedDoubleCollection.empty();
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new OrderedDoubleCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... doubles) {
        return OrderedDoubleCollection.of(elementCardinality, doubles);
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Double... doubles) {
        return OrderedDoubleCollection.of(doubles);
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getAt(1));
    }
}
