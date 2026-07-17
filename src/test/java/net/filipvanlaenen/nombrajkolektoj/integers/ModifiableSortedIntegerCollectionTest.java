package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableSortedIntegerCollection} class.
 */
public final class ModifiableSortedIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableSortedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final IntegerCollection collection123 = IntegerCollection.of(1, 2, 3);

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedIntegerCollection source) {
        return ModifiableSortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final ModifiableSortedIntegerCollection source) {
        return ModifiableSortedIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a int collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAIntegerCollection() {
        assertTrue(new ModifiableSortedIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(), 1, 2,
                INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedIntegerCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted integers collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedIntegerCollection source = SortedIntegerCollection.of(Comparator.naturalOrder(), 1, 2, INTEGER_THREE);
        ModifiableSortedIntegerCollection actual = ModifiableSortedIntegerCollection.of(source);
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
        ModifiableSortedIntegerCollection actual =
                ModifiableSortedIntegerCollection.of(source, Range.greaterThan(1).lessThan(INTEGER_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(IntegerCollection.of(2)));
    }

    /**
     * Verifies that an ordered integers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct integers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedIntegerCollection source =
                OrderedIntegerCollection.of(DISTINCT_ELEMENTS, 1, 2, INTEGER_THREE, INTEGER_FOUR);
        ModifiableSortedIntegerCollection actual =
                ModifiableSortedIntegerCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Integer[] {2, INTEGER_THREE}, actual.toArray());
    }
}
