package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 */
public final class SortedIntegerCollectionDecoratorTest
        extends SortedIntegerCollectionDecoratorTestBase<SortedIntegerCollection> {
    @Override
    protected SortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createEmptyIntegerCollection() {
        return SortedIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final Integer... numbers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createSortedIntegerCollection(final Comparator<Integer> comparator,
            final Integer... numbers) {
        return SortedIntegerCollection.of(comparator, numbers);
    }
}
