package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 */
public final class BigIntegerCollectionTest extends BigIntegerCollectionTestBase<BigIntegerCollection> {
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final NumericCollection<BigInteger> collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected BigIntegerCollection createEmptyBigIntegerCollection() {
        return BigIntegerCollection.empty();
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return BigIntegerCollection.of(numbers);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return BigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> source) {
        return BigIntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return BigIntegerCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(BigIntegerCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(BigIntegerCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO)
                .containsSame(BigIntegerCollection.intersectionOf(createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO), collection123)));
    }
}
