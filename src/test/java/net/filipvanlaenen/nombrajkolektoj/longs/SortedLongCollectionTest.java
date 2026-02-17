package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongCollection} class.
 */
public final class SortedLongCollectionTest extends SortedLongCollectionTestBase<SortedLongCollection> {
    @Override
    protected SortedLongCollection createEmptyLongCollection() {
        return SortedLongCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedLongCollection createLongCollection(final NumericCollection<Long> source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createLongCollection(final Long... numbers) {
        return SortedLongCollection.of(Comparator.naturalOrder(), numbers);
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
    protected SortedLongCollection createOrderedLongCollection(OrderedNumericCollection<Long> source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }
}
