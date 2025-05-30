package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class OrderedLongCollectionTest extends OrderedLongCollectionTestBase<OrderedLongCollection> {
    @Override
    protected OrderedLongCollection createEmptyLongCollection() {
        return OrderedLongCollection.empty();
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Collection<Long> source) {
        return new OrderedLongCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected OrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... longs) {
        return OrderedLongCollection.of(elementCardinality, longs);
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Long... longs) {
        return OrderedLongCollection.of(longs);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(final Long... longs) {
        return OrderedLongCollection.of(longs);
    }
}
