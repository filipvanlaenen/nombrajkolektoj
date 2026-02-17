package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.SortedBigIntegerCollection} class.
 */
public final class SortedBigIntegerCollectionTest extends SortedBigIntegerCollectionTestBase<SortedBigIntegerCollection> {
    @Override
    protected SortedBigIntegerCollection createEmptyBigIntegerCollection() {
        return SortedBigIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
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

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(OrderedNumericCollection<BigInteger> source) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final OrderedNumericCollection<BigInteger> source,
            int fromIndex, int toIndex) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
