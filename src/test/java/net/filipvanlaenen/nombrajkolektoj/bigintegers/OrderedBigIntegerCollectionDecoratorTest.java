package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.OrderedBigIntegerCollection} class.
 */
public final class OrderedBigIntegerCollectionDecoratorTest
        extends OrderedBigIntegerCollectionDecoratorTestBase<OrderedBigIntegerCollection> {
    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return OrderedBigIntegerCollection.empty();
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }
}
