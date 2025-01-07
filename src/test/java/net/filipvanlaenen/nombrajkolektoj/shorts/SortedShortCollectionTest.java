package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 */
public final class SortedShortCollectionTest extends OrderedShortCollectionTestBase<SortedShortCollection> {
    @Override
    protected SortedShortCollection createEmptyShortCollection() {
        return SortedShortCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedShortCollection createShortCollection(final Collection<Short> source) {
        return new SortedShortCollection.ArrayCollection(Comparator.naturalOrder(),
                ShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... shorts) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), shorts);
    }

    @Override
    protected SortedShortCollection createShortCollection(final Short... shorts) {
        return SortedShortCollection.of(Comparator.naturalOrder(), shorts);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final Short... shorts) {
        return SortedShortCollection.of(Comparator.naturalOrder(), shorts);
    }
}
