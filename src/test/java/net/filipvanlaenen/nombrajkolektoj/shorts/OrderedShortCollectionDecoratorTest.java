package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 */
public final class OrderedShortCollectionDecoratorTest
        extends OrderedShortCollectionDecoratorTestBase<OrderedShortCollection> {
    @Override
    protected OrderedShortCollection createShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createEmptyShortCollection() {
        return OrderedShortCollection.empty();
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
