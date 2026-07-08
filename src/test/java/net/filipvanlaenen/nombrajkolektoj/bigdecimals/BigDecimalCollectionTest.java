package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} class.
 */
public final class BigDecimalCollectionTest extends BigDecimalCollectionTestBase<BigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * Collection with the BigDecimals 0, 1 and 2.
     */
    private final NumericCollection<BigDecimal> collection012 = BigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L));
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final NumericCollection<BigDecimal> collection123 = BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new BigDecimalCollection.ArrayCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new BigDecimalCollection.HashCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).containsAll(collection123));
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return BigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal> source) {
        return BigDecimalCollection.of(elementCardinality, source);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final NumericCollection<BigDecimal> source) {
        return BigDecimalCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(BigDecimalCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(BigDecimalCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L))
                .containsSame(BigDecimalCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(BigDecimalCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(BigDecimalCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(BigDecimalCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(BigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(BigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsSame(BigDecimalCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(BigDecimalCollection.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsSame(BigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
