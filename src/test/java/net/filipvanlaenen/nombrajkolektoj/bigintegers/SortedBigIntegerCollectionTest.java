package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.SortedBigIntegerCollection} class.
 */
public final class SortedBigIntegerCollectionTest extends SortedBigIntegerCollectionTestBase<SortedBigIntegerCollection> {
    @Override
    protected SortedBigIntegerCollection createEmptyBigIntegerCollection() {
        return SortedBigIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new SortedBigIntegerCollection.ArrayCollection(Comparator.naturalOrder(),
                BigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
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
    protected SortedBigIntegerCollection createSortedBigIntegerCollection(final Comparator<BigInteger> comparator,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(comparator, numbers);
    }
}
