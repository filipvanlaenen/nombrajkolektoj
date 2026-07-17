package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortCollection} class.
 */
public final class SortedShortCollectionTest extends OrderedShortCollectionTestBase<SortedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final ShortCollection collection123 = ShortCollection.of((short) 1, (short) 2, (short) 3);

    @Override
    protected SortedShortCollection createShortCollection(final Short... numbers) {
        return SortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final SortedShortCollection source) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createShortCollection(final SortedShortCollection source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return SortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final SortedShortCollection source) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedShortCollection createOrderedShortCollection(final SortedShortCollection source,
            final int fromIndex, final int toIndex) {
        return SortedShortCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a short collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAShortCollection() {
        assertTrue(new SortedShortCollection.ArrayCollection(Comparator.naturalOrder(), (short) 1, (short) 2, SHORT_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a short collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAShortCollection() {
        assertTrue(new SortedShortCollection.SortedTreeCollection(Comparator.naturalOrder(), (short) 1, (short) 2, SHORT_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedShortCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted shorts collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedShortCollection source = SortedShortCollection.of(Comparator.naturalOrder(), (short) 1, (short) 2, SHORT_THREE);
        SortedShortCollection actual = SortedShortCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted shorts collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedShortCollection source = SortedShortCollection.of(Comparator.naturalOrder(), (short) 1, (short) 2, SHORT_THREE);
        SortedShortCollection actual = SortedShortCollection.of(source, Range.greaterThan((short) 1).lessThan(SHORT_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(ShortCollection.of((short) 2)));
    }
}
