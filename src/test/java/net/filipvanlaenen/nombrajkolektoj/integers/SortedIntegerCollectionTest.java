package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.SortedIntegerCollection} class.
 */
public final class SortedIntegerCollectionTest extends SortedIntegerCollectionTestBase<SortedIntegerCollection> {
    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source);
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

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final SortedIntegerCollection source,
            final int fromIndex, final int toIndex) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
