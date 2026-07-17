package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 */
public final class OrderedBigDecimalCollectionDecoratorTest
        extends OrderedBigDecimalCollectionDecoratorTestBase<OrderedBigDecimalCollection> {
    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createEmptyBigDecimalCollection() {
        return OrderedBigDecimalCollection.empty();
    }

    @Override
    protected OrderedBigDecimalCollection createOrderedBigDecimalCollection(final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createOrderedBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(elementCardinality, numbers);
    }
}
