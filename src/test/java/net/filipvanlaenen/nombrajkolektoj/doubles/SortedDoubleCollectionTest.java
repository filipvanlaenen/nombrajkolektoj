package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleCollection} class.
 */
public final class SortedDoubleCollectionTest extends OrderedDoubleCollectionTestBase<SortedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final DoubleCollection collection123 = DoubleCollection.of(1D, 2D, 3D);

    @Override
    protected SortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final SortedDoubleCollection source) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final SortedDoubleCollection source,
            final int fromIndex, final int toIndex) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a double collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateADoubleCollection() {
        assertTrue(new SortedDoubleCollection.ArrayCollection(Comparator.naturalOrder(), 1D, 2D, DOUBLE_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a double collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateADoubleCollection() {
        assertTrue(new SortedDoubleCollection.SortedTreeCollection(Comparator.naturalOrder(), 1D, 2D, DOUBLE_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedDoubleCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted doubles collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedDoubleCollection source = SortedDoubleCollection.of(Comparator.naturalOrder(), 1D, 2D, DOUBLE_THREE);
        SortedDoubleCollection actual = SortedDoubleCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted doubles collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedDoubleCollection source = SortedDoubleCollection.of(Comparator.naturalOrder(), 1D, 2D, DOUBLE_THREE);
        SortedDoubleCollection actual = SortedDoubleCollection.of(source, Range.greaterThan(1D).lessThan(DOUBLE_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(DoubleCollection.of(2D)));
    }
}
