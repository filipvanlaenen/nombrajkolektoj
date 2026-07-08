package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableOrderedBigIntegerCollection} class.
 */
public final class ModifiableOrderedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableOrderedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the BigIntegers one, two and three.
     */
    private static final BigInteger[] BIG_INTEGERS123 = new BigInteger[] {BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L)};
    /**
     * Collection with the BigIntegers 0, 1 and 2.
     */
    private final ModifiableOrderedBigIntegerCollection collection012 = ModifiableOrderedBigIntegerCollection.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final ModifiableOrderedBigIntegerCollection collection123 = ModifiableOrderedBigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigIntegerCollection() {
        assertTrue(
                new ModifiableOrderedBigIntegerCollection.ArrayCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new ModifiableOrderedBigIntegerCollection.LinkedListCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ModifiableOrderedBigIntegerCollection source) {
        return ModifiableOrderedBigIntegerCollection
                .of(OrderedBigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableOrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedBigIntegerCollection source) {
        return ModifiableOrderedBigIntegerCollection.of(elementCardinality,
                OrderedBigIntegerCollection.of(source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedBigIntegerCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered BigIntegers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigIntegers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedBigIntegerCollection source =
                ModifiableOrderedBigIntegerCollection.of(DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR);
        ModifiableOrderedBigIntegerCollection actual = ModifiableOrderedBigIntegerCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigInteger[] {BigInteger.TWO, BIG_INTEGER_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123, ModifiableOrderedBigIntegerCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123,
                ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                ModifiableOrderedBigIntegerCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
