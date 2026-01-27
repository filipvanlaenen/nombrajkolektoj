package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.SortedIntegerCollection} class.
 */
public final class SortedIntegerCollectionTest extends SortedIntegerCollectionTestBase<SortedIntegerCollection> {
    @Override
    protected SortedIntegerCollection createEmptyIntegerCollection() {
        return SortedIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return new SortedIntegerCollection.ArrayCollection(Comparator.naturalOrder(),
                IntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final Integer... numbers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createSortedIntegerCollection(final Comparator<Integer> comparator,
            final Integer... numbers) {
        return SortedIntegerCollection.of(comparator, numbers);
    }
}
