package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableSortedBigIntegerCollection} class.
 */
public final class ModifiableSortedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableSortedBigIntegerCollection> {
    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new ModifiableSortedBigIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(),
                BigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableSortedBigIntegerCollection.empty(Comparator.naturalOrder());
    }
}
