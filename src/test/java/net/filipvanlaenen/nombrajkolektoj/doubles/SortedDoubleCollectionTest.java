package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleCollection} class.
 */
public final class SortedDoubleCollectionTest extends SortedDoubleCollectionTestBase<SortedDoubleCollection> {
    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createSortedDoubleCollection(final Comparator<Double> comparator,
            final Double... numbers) {
        return SortedDoubleCollection.of(comparator, numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final SortedDoubleCollection source,
            final int fromIndex, final int toIndex) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
