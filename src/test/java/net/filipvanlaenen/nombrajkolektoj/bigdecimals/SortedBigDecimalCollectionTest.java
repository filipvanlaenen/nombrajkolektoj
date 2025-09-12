package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalCollection} class.
 */
public final class SortedBigDecimalCollectionTest extends SortedBigDecimalCollectionTestBase<SortedBigDecimalCollection> {
    @Override
    protected SortedBigDecimalCollection createEmptyBigDecimalCollection() {
        return SortedBigDecimalCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new SortedBigDecimalCollection.ArrayCollection(Comparator.naturalOrder(),
                BigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
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
