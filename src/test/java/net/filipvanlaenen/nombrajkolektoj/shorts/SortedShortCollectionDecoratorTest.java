package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 */
public final class SortedShortCollectionDecoratorTest
        extends SortedShortCollectionDecoratorTestBase<SortedShortCollection> {
    @Override
    protected SortedShortCollection createShortCollection(final Short... numbers) {
        return SortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createEmptyShortCollection() {
        return SortedShortCollection.empty(Comparator.naturalOrder());
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
