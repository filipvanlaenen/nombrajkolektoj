package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongCollection} class.
 */
public final class SortedLongCollectionTest extends SortedLongCollectionTestBase<SortedLongCollection> {
    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final SortedLongCollection source) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createLongCollection(final SortedLongCollection source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final Long... numbers) {
        return SortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createSortedLongCollection(final Comparator<Long> comparator,
            final Long... numbers) {
        return SortedLongCollection.of(comparator, numbers);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final SortedLongCollection source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final SortedLongCollection source,
            final int fromIndex, final int toIndex) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
