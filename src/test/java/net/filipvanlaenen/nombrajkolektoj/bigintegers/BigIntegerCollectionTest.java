package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 */
public final class BigIntegerCollectionTest extends BigIntegerCollectionTestBase<BigIntegerCollection> {
    @Override
    protected BigIntegerCollection createEmptyBigIntegerCollection() {
        return BigIntegerCollection.empty();
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new BigIntegerCollection.ArrayCollection(source);
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
