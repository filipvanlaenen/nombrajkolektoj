package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 */
public final class OrderedByteCollectionDecoratorTest
        extends OrderedByteCollectionDecoratorTestBase<OrderedByteCollection> {
    @Override
    protected OrderedByteCollection createByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedByteCollection createEmptyByteCollection() {
        return OrderedByteCollection.empty();
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }
}
