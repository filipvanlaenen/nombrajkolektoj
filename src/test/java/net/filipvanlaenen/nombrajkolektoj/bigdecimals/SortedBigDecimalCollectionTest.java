package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalCollection} class.
 */
public final class SortedBigDecimalCollectionTest extends SortedBigDecimalCollectionTestBase<SortedBigDecimalCollection> {
    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createSortedBigDecimalCollection(final Comparator<BigDecimal> comparator,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(comparator, numbers);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final SortedBigDecimalCollection source,
            final int fromIndex, final int toIndex) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }
}
