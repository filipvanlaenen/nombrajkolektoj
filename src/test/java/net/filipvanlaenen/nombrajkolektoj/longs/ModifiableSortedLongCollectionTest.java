package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableSortedLongCollection} class.
 */
public final class ModifiableSortedLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableSortedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final LongCollection collection123 = LongCollection.of(1L, 2L, 3L);

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final Long... numbers) {
        return ModifiableSortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableSortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedLongCollection source) {
        return ModifiableSortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final ModifiableSortedLongCollection source) {
        return ModifiableSortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a long collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateALongCollection() {
        assertTrue(new ModifiableSortedLongCollection.SortedTreeCollection(Comparator.naturalOrder(), 1L, 2L,
                LONG_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedLongCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted longs collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedLongCollection source = SortedLongCollection.of(Comparator.naturalOrder(), 1L, 2L, LONG_THREE);
        ModifiableSortedLongCollection actual = ModifiableSortedLongCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted longs collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedLongCollection source = SortedLongCollection.of(Comparator.naturalOrder(), 1L, 2L, LONG_THREE);
        ModifiableSortedLongCollection actual =
                ModifiableSortedLongCollection.of(source, Range.greaterThan(1L).lessThan(LONG_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(LongCollection.of(2L)));
    }

    /**
     * Verifies that an ordered longs collection created as a slice from another ordered collection has the same
     * element cardinality and the correct longs in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedLongCollection source =
                OrderedLongCollection.of(DISTINCT_ELEMENTS, 1L, 2L, LONG_THREE, LONG_FOUR);
        ModifiableSortedLongCollection actual =
                ModifiableSortedLongCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Long[] {2L, LONG_THREE}, actual.toArray());
    }
}
