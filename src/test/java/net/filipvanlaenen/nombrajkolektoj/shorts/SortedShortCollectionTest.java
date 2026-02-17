package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 */
public final class SortedShortCollectionTest extends SortedShortCollectionTestBase<SortedShortCollection> {
    @Override
    protected SortedShortCollection createEmptyShortCollection() {
        return SortedShortCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedShortCollection createShortCollection(final NumericCollection<Short> source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
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

    @Override
    protected SortedShortCollection createOrderedShortCollection(OrderedNumericCollection<Short> source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
    }
}
