package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.OrderedBigIntegerCollection} class.
 */
public final class OrderedBigIntegerCollectionTest extends OrderedBigIntegerCollectionTestBase<OrderedBigIntegerCollection> {
    @Override
    protected OrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return OrderedBigIntegerCollection.empty();
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return new OrderedBigIntegerCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
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
