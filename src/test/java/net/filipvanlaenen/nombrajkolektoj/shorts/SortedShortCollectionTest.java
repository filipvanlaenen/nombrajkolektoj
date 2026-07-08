package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 */
public final class SortedShortCollectionTest extends SortedShortCollectionTestBase<SortedShortCollection> {
    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final SortedShortCollection source) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createShortCollection(final SortedShortCollection source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createSortedShortCollection(final Comparator<Short> comparator,
            final Short... numbers) {
        return SortedShortCollection.of(comparator, numbers);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final SortedShortCollection source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final SortedShortCollection source,
            final int fromIndex, final int toIndex) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
