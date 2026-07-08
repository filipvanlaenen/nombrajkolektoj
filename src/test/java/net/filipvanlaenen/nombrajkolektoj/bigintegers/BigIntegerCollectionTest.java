package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 */
public final class BigIntegerCollectionTest extends BigIntegerCollectionTestBase<BigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * Collection with the BigIntegers 0, 1 and 2.
     */
    private final BigIntegerCollection collection012 = BigIntegerCollection.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final BigIntegerCollection collection123 = BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new BigIntegerCollection.ArrayCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new BigIntegerCollection.HashCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).containsAll(collection123));
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return BigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigIntegerCollection source) {
        return BigIntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected BigIntegerCollection createBigIntegerCollection(final BigIntegerCollection source) {
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
        assertTrue(BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO)
                .containsSame(BigIntegerCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(BigIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(BigIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(BigIntegerCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(BigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(BigIntegerCollection.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsSame(BigIntegerCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(BigIntegerCollection.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsSame(BigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
