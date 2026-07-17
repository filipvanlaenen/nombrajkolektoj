package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.SortedIntegerCollection} class.
 */
public final class SortedIntegerCollectionTest extends OrderedIntegerCollectionTestBase<SortedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final IntegerCollection collection123 = IntegerCollection.of(1, 2, 3);

    @Override
    protected SortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final SortedIntegerCollection source) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final SortedIntegerCollection source,
            final int fromIndex, final int toIndex) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a int collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAIntegerCollection() {
        assertTrue(new SortedIntegerCollection.ArrayCollection(Comparator.naturalOrder(), 1, 2, INTEGER_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a int collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAIntegerCollection() {
        assertTrue(new SortedIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(), 1, 2, INTEGER_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedIntegerCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted integers collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedIntegerCollection source = SortedIntegerCollection.of(Comparator.naturalOrder(), 1, 2, INTEGER_THREE);
        SortedIntegerCollection actual = SortedIntegerCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted integers collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedIntegerCollection source = SortedIntegerCollection.of(Comparator.naturalOrder(), 1, 2, INTEGER_THREE);
        SortedIntegerCollection actual = SortedIntegerCollection.of(source, Range.greaterThan(1).lessThan(INTEGER_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(IntegerCollection.of(2)));
    }
}
