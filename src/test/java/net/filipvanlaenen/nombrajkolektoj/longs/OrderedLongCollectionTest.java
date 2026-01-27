package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class OrderedLongCollectionTest extends OrderedLongCollectionTestBase<OrderedLongCollection> {
    @Override
    protected OrderedLongCollection createEmptyLongCollection() {
        return OrderedLongCollection.empty();
    }

    @Override
    protected OrderedLongCollection createLongCollection(final NumericCollection<Long> source) {
        return new OrderedLongCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected OrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return OrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Long... numbers) {
        return OrderedLongCollection.of(numbers);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(final Long... numbers) {
        return OrderedLongCollection.of(numbers);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return OrderedLongCollection.of(elementCardinality, numbers);
    }
}
