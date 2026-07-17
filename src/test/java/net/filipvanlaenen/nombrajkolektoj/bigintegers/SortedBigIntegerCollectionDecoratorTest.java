package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.OrderedBigIntegerCollection} class.
 */
public final class SortedBigIntegerCollectionDecoratorTest
        extends SortedBigIntegerCollectionDecoratorTestBase<SortedBigIntegerCollection> {
    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createEmptyBigIntegerCollection() {
        return SortedBigIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createSortedBigIntegerCollection(final Comparator<BigInteger> comparator,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(comparator, numbers);
    }
}
