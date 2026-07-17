package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class SortedFloatCollectionDecoratorTest
        extends SortedFloatCollectionDecoratorTestBase<SortedFloatCollection> {
    @Override
    protected SortedFloatCollection createFloatCollection(final Float... numbers) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createEmptyFloatCollection() {
        return SortedFloatCollection.empty(Comparator.naturalOrder());
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
}
