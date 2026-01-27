package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} class.
 */
public final class BigDecimalCollectionTest extends BigDecimalCollectionTestBase<BigDecimalCollection> {
    @Override
    protected BigDecimalCollection createEmptyBigDecimalCollection() {
        return BigDecimalCollection.empty();
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final NumericCollection<BigDecimal> source) {
        return BigDecimalCollection.of(source);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return BigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return BigDecimalCollection.of(numbers);
    }
}
