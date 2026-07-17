package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalCollection} class.
 */
public final class SortedBigDecimalCollectionTest extends OrderedBigDecimalCollectionTestBase<SortedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final BigDecimalCollection collection123 = BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createBigDecimalCollection(final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return SortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final SortedBigDecimalCollection source) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigDecimalCollection createOrderedBigDecimalCollection(final SortedBigDecimalCollection source,
            final int fromIndex, final int toIndex) {
        return SortedBigDecimalCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new SortedBigDecimalCollection.ArrayCollection(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new SortedBigDecimalCollection.SortedTreeCollection(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedBigDecimalCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted BigDecimals collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedBigDecimalCollection source = SortedBigDecimalCollection.of(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        SortedBigDecimalCollection actual = SortedBigDecimalCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted BigDecimals collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedBigDecimalCollection source = SortedBigDecimalCollection.of(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        SortedBigDecimalCollection actual = SortedBigDecimalCollection.of(source, Range.greaterThan(BigDecimal.ONE).lessThan(BIG_DECIMAL_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(BigDecimalCollection.of(BigDecimal.valueOf(2L))));
    }
}
