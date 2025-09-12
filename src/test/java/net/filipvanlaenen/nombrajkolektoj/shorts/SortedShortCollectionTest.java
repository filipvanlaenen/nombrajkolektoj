package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 */
public final class SortedShortCollectionTest extends SortedShortCollectionTestBase<SortedShortCollection> {
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
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createShortCollection(final Short... numbers) {
        return SortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final Short... numbers) {
        return SortedShortCollection.of(Comparator.naturalOrder(), numbers);
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
}
