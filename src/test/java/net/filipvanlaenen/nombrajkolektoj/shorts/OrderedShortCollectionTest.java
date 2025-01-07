package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 */
public final class OrderedShortCollectionTest extends ShortCollectionTestBase<OrderedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    @Override
    protected OrderedShortCollection createEmptyShortCollection() {
        return OrderedShortCollection.empty();
    }

    @Override
    protected OrderedShortCollection createShortCollection(final Collection<Short> source) {
        return new OrderedShortCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected OrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... shorts) {
        return OrderedShortCollection.of(elementCardinality, shorts);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final Short... shorts) {
        return OrderedShortCollection.of(shorts);
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }
}
