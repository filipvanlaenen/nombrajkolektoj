package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 */
public final class BigIntegerCollectionTest extends BigIntegerCollectionTestBase<BigIntegerCollection> {
    @Override
    protected BigIntegerCollection createEmptyBigIntegerCollection() {
        return BigIntegerCollection.empty();
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return BigIntegerCollection.of(source);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return BigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return BigIntegerCollection.of(numbers);
    }
}
