package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerCollection} class.
 */
public final class ModifiableBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableBigIntegerCollection> {
    @Override
    protected ModifiableBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableBigIntegerCollection.empty();
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final Collection<BigInteger> source) {
        return new ModifiableBigIntegerCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(numbers);
    }
}
