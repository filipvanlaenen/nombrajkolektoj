package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class OrderedLongCollectionDecoratorTest
        extends OrderedLongCollectionDecoratorTestBase<OrderedLongCollection> {
    @Override
    protected OrderedLongCollection createLongCollection(final Long... numbers) {
        return OrderedLongCollection.of(numbers);
    }

    @Override
    protected OrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return OrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedLongCollection createEmptyLongCollection() {
        return OrderedLongCollection.empty();
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
