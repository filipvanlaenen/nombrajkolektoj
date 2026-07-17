package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class OrderedFloatCollectionDecoratorTest
        extends OrderedFloatCollectionDecoratorTestBase<OrderedFloatCollection> {
    @Override
    protected OrderedFloatCollection createFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createEmptyFloatCollection() {
        return OrderedFloatCollection.empty();
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }
}
