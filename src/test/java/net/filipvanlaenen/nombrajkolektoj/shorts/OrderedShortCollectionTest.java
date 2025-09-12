package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 */
public final class OrderedShortCollectionTest extends OrderedShortCollectionTestBase<OrderedShortCollection> {
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
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }
}
