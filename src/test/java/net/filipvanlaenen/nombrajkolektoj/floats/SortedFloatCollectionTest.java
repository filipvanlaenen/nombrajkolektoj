package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatCollection} class.
 */
public final class SortedFloatCollectionTest extends SortedFloatCollectionTestBase<SortedFloatCollection> {
    @Override
    protected SortedFloatCollection createEmptyFloatCollection() {
        return SortedFloatCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final Float... numbers) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final Float... numbers) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createSortedFloatCollection(final Comparator<Float> comparator,
            final Float... numbers) {
        return SortedFloatCollection.of(comparator, numbers);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(OrderedNumericCollection<Float> source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
    }
}
