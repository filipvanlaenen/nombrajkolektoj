package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatCollection} class.
 */
public final class SortedFloatCollectionTest extends SortedFloatCollectionTestBase<SortedFloatCollection> {
    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final SortedFloatCollection source) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final SortedFloatCollection source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
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
    protected SortedFloatCollection createOrderedFloatCollection(final SortedFloatCollection source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final SortedFloatCollection source,
            final int fromIndex, final int toIndex) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
