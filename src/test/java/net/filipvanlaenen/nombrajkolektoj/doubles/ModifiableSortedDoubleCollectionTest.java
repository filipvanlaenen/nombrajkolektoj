package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableSortedDoubleCollection} class.
 */
public final class ModifiableSortedDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableSortedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final DoubleCollection collection123 = DoubleCollection.of(1D, 2D, 3D);

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedDoubleCollection source) {
        return ModifiableSortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final ModifiableSortedDoubleCollection source) {
        return ModifiableSortedDoubleCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a double collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateADoubleCollection() {
        assertTrue(new ModifiableSortedDoubleCollection.SortedTreeCollection(Comparator.naturalOrder(), 1D, 2D,
                DOUBLE_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedDoubleCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted doubles collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedDoubleCollection source = SortedDoubleCollection.of(Comparator.naturalOrder(), 1D, 2D, DOUBLE_THREE);
        ModifiableSortedDoubleCollection actual = ModifiableSortedDoubleCollection.of(source);
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
        ModifiableSortedDoubleCollection actual =
                ModifiableSortedDoubleCollection.of(source, Range.greaterThan(1D).lessThan(DOUBLE_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(DoubleCollection.of(2D)));
    }

    /**
     * Verifies that an ordered doubles collection created as a slice from another ordered collection has the same
     * element cardinality and the correct doubles in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedDoubleCollection source =
                OrderedDoubleCollection.of(DISTINCT_ELEMENTS, 1D, 2D, DOUBLE_THREE, DOUBLE_FOUR);
        ModifiableSortedDoubleCollection actual =
                ModifiableSortedDoubleCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Double[] {2D, DOUBLE_THREE}, actual.toArray());
    }
}
