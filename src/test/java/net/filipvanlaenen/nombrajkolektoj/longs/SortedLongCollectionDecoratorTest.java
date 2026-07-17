package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class SortedLongCollectionDecoratorTest
        extends SortedLongCollectionDecoratorTestBase<SortedLongCollection> {
    @Override
    protected SortedLongCollection createLongCollection(final Long... numbers) {
        return SortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createEmptyLongCollection() {
        return SortedLongCollection.empty(Comparator.naturalOrder());
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
}
