package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongCollection} class.
 */
public final class SortedLongCollectionTest extends OrderedLongCollectionTestBase<SortedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final LongCollection collection123 = LongCollection.of(1L, 2L, 3L);

    @Override
    protected SortedLongCollection createLongCollection(final Long... numbers) {
        return SortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final SortedLongCollection source) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createLongCollection(final SortedLongCollection source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return SortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final SortedLongCollection source) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedLongCollection createOrderedLongCollection(final SortedLongCollection source,
            final int fromIndex, final int toIndex) {
        return SortedLongCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a long collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateALongCollection() {
        assertTrue(new SortedLongCollection.ArrayCollection(Comparator.naturalOrder(), 1L, 2L, LONG_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a long collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateALongCollection() {
        assertTrue(new SortedLongCollection.SortedTreeCollection(Comparator.naturalOrder(), 1L, 2L, LONG_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedLongCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted longs collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedLongCollection source = SortedLongCollection.of(Comparator.naturalOrder(), 1L, 2L, LONG_THREE);
        SortedLongCollection actual = SortedLongCollection.of(source);
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
        SortedLongCollection actual = SortedLongCollection.of(source, Range.greaterThan(1L).lessThan(LONG_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(LongCollection.of(2L)));
    }
}
