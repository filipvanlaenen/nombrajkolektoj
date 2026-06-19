package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerCollection} class.
 */
public final class ModifiableBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableBigIntegerCollection> {
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final NumericCollection<BigInteger> collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected ModifiableBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableBigIntegerCollection.empty();
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(numbers);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> source) {
        return ModifiableBigIntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return ModifiableBigIntegerCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableBigIntegerCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigIntegerCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO).containsSame(
                ModifiableBigIntegerCollection.intersectionOf(createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO), collection123)));
    }
}
