package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 */
public final class SortedBigDecimalCollectionDecoratorTest
        extends SortedBigDecimalCollectionDecoratorTestBase<SortedBigDecimalCollection> {
    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createEmptyBigDecimalCollection() {
        return SortedBigDecimalCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
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
}
