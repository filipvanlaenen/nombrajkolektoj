package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableSortedBigDecimalCollection} class.
 */
public final class ModifiableSortedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableSortedBigDecimalCollection> {
    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new ModifiableSortedBigDecimalCollection.SortedTreeCollection(Comparator.naturalOrder(),
                BigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableSortedBigDecimalCollection.empty(Comparator.naturalOrder());
    }
}
