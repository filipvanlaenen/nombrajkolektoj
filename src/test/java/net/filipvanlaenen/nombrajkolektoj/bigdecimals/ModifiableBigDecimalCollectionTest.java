package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} class.
 */
public final class ModifiableBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * Collection with the BigDecimals 0, 1 and 2.
     */
    private final ModifiableBigDecimalCollection collection012 = ModifiableBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L));
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final ModifiableBigDecimalCollection collection123 = ModifiableBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new ModifiableBigDecimalCollection.ArrayCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new ModifiableBigDecimalCollection.HashCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateABigDecimalCollection() {
        assertTrue(
                new ModifiableBigDecimalCollection.LinkedListCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final ModifiableBigDecimalCollection source) {
        return ModifiableBigDecimalCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ModifiableBigDecimalCollection source) {
        return ModifiableBigDecimalCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableBigDecimalCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigDecimalCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ModifiableBigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L))
                .containsSame(ModifiableBigDecimalCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableBigDecimalCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableBigDecimalCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigDecimalCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ModifiableBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsSame(ModifiableBigDecimalCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ModifiableBigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsSame(ModifiableBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
