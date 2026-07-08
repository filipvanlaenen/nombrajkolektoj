package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableOrderedBigDecimalCollection} class.
 */
public final class ModifiableOrderedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableOrderedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the BigDecimals one, two and three.
     */
    private static final BigDecimal[] BIG_DECIMALS123 = new BigDecimal[] {BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L)};
    /**
     * Collection with the BigDecimals 0, 1 and 2.
     */
    private final ModifiableOrderedBigDecimalCollection collection012 = ModifiableOrderedBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L));
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final ModifiableOrderedBigDecimalCollection collection123 = ModifiableOrderedBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigDecimalCollection() {
        assertTrue(
                new ModifiableOrderedBigDecimalCollection.ArrayCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new ModifiableOrderedBigDecimalCollection.LinkedListCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ModifiableOrderedBigDecimalCollection source) {
        return ModifiableOrderedBigDecimalCollection
                .of(OrderedBigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableOrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedBigDecimalCollection source) {
        return ModifiableOrderedBigDecimalCollection.of(elementCardinality,
                OrderedBigDecimalCollection.of(source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedBigDecimalCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered BigDecimals collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigDecimals in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedBigDecimalCollection source =
                ModifiableOrderedBigDecimalCollection.of(DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR);
        ModifiableOrderedBigDecimalCollection actual = ModifiableOrderedBigDecimalCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigDecimal[] {BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigDecimalCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BIG_DECIMALS123, ModifiableOrderedBigDecimalCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BIG_DECIMALS123,
                ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE},
                ModifiableOrderedBigDecimalCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE},
                ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
