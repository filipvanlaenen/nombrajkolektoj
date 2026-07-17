package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableSortedBigDecimalCollection} class.
 */
public final class ModifiableSortedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableSortedBigDecimalCollection> {
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
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final BigDecimalCollection collection123 = BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedBigDecimalCollection source) {
        return ModifiableSortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final ModifiableSortedBigDecimalCollection source) {
        return ModifiableSortedBigDecimalCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a BigDecimal collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateABigDecimalCollection() {
        assertTrue(new ModifiableSortedBigDecimalCollection.SortedTreeCollection(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L),
                BIG_DECIMAL_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedBigDecimalCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted BigDecimals collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedBigDecimalCollection source = SortedBigDecimalCollection.of(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        ModifiableSortedBigDecimalCollection actual = ModifiableSortedBigDecimalCollection.of(source);
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
        ModifiableSortedBigDecimalCollection actual =
                ModifiableSortedBigDecimalCollection.of(source, Range.greaterThan(BigDecimal.ONE).lessThan(BIG_DECIMAL_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(BigDecimalCollection.of(BigDecimal.valueOf(2L))));
    }

    /**
     * Verifies that an ordered BigDecimals collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigDecimals in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedBigDecimalCollection source =
                OrderedBigDecimalCollection.of(DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR);
        ModifiableSortedBigDecimalCollection actual =
                ModifiableSortedBigDecimalCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new BigDecimal[] {BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }
}
