package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerCollection} class.
 */
public final class ModifiableBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * Collection with the BigIntegers 0, 1 and 2.
     */
    private final ModifiableBigIntegerCollection collection012 = createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final ModifiableBigIntegerCollection collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

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
            final ModifiableBigIntegerCollection source) {
        return ModifiableBigIntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableBigIntegerCollection createBigIntegerCollection(final ModifiableBigIntegerCollection source) {
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
        assertTrue(createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO)
                .containsSame(ModifiableBigIntegerCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableBigIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableBigIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigIntegerCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsSame(ModifiableBigIntegerCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsSame(ModifiableBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
