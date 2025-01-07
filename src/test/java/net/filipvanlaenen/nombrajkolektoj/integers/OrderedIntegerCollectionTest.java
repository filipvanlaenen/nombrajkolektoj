package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 */
public final class OrderedIntegerCollectionTest extends OrderedIntegerCollectionTestBase<OrderedIntegerCollection> {
    @Override
    protected OrderedIntegerCollection createEmptyIntegerCollection() {
        return OrderedIntegerCollection.empty();
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new OrderedIntegerCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... integers) {
        return OrderedIntegerCollection.of(elementCardinality, integers);
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final Integer... integers) {
        return OrderedIntegerCollection.of(integers);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final Integer... integers) {
        return OrderedIntegerCollection.of(integers);
    }
}
