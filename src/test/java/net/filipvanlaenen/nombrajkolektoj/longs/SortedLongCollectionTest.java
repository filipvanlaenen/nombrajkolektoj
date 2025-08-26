package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongCollection} class.
 */
public final class SortedLongCollectionTest extends SortedLongCollectionTestBase<SortedLongCollection> {
    @Override
    protected SortedLongCollection createEmptyLongCollection() {
        return SortedLongCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedLongCollection createLongCollection(final Collection<Long> source) {
        return new SortedLongCollection.ArrayCollection(Comparator.naturalOrder(),
                LongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... longs) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), longs);
    }

    @Override
    protected SortedLongCollection createLongCollection(final Long... longs) {
        return SortedLongCollection.of(Comparator.naturalOrder(), longs);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final Long... longs) {
        return SortedLongCollection.of(Comparator.naturalOrder(), longs);
    }

    @Override
    protected SortedLongCollection createSortedLongCollection(final Comparator<Long> comparator,
            final Long... longs) {
        return SortedLongCollection.of(comparator, longs);
    }
}
