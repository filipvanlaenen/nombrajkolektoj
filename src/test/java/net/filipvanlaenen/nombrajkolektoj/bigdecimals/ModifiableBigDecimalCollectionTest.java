package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} class.
 */
public final class ModifiableBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableBigDecimalCollection> {
    @Override
    protected ModifiableBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableBigDecimalCollection.empty();
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new ModifiableBigDecimalCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(numbers);
    }
}
