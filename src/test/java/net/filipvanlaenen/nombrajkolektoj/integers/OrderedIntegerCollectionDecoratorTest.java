package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 */
public final class OrderedIntegerCollectionDecoratorTest
        extends OrderedIntegerCollectionDecoratorTestBase<OrderedIntegerCollection> {
    @Override
    protected OrderedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return OrderedIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedIntegerCollection createEmptyIntegerCollection() {
        return OrderedIntegerCollection.empty();
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final Integer... numbers) {
        return OrderedIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }
}
