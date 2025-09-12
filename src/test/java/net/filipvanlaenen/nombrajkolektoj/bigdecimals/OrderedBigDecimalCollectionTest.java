package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 */
public final class OrderedBigDecimalCollectionTest extends OrderedBigDecimalCollectionTestBase<OrderedBigDecimalCollection> {
    @Override
    protected OrderedBigDecimalCollection createEmptyBigDecimalCollection() {
        return OrderedBigDecimalCollection.empty();
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new OrderedBigDecimalCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(numbers);
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
