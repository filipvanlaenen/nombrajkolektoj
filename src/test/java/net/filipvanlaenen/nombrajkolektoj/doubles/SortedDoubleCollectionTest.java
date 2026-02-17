package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleCollection} class.
 */
public final class SortedDoubleCollectionTest extends SortedDoubleCollectionTestBase<SortedDoubleCollection> {
    @Override
    protected SortedDoubleCollection createEmptyDoubleCollection() {
        return SortedDoubleCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final NumericCollection<Double> source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createSortedDoubleCollection(final Comparator<Double> comparator,
            final Double... numbers) {
        return SortedDoubleCollection.of(comparator, numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(OrderedNumericCollection<Double> source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final OrderedNumericCollection<Double> source,
            int fromIndex, int toIndex) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
