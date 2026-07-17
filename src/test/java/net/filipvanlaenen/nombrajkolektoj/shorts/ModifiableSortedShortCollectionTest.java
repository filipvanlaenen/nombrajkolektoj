package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableSortedShortCollection} class.
 */
public final class ModifiableSortedShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableSortedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final ShortCollection collection123 = ShortCollection.of((short) 1, (short) 2, (short) 3);

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final Short... numbers) {
        return ModifiableSortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableSortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedShortCollection source) {
        return ModifiableSortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final ModifiableSortedShortCollection source) {
        return ModifiableSortedShortCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a short collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAShortCollection() {
        assertTrue(new ModifiableSortedShortCollection.SortedTreeCollection(Comparator.naturalOrder(), (short) 1, (short) 2,
                SHORT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedShortCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted shorts collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedShortCollection source = SortedShortCollection.of(Comparator.naturalOrder(), (short) 1, (short) 2, SHORT_THREE);
        ModifiableSortedShortCollection actual = ModifiableSortedShortCollection.of(source);
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
        ModifiableSortedShortCollection actual =
                ModifiableSortedShortCollection.of(source, Range.greaterThan((short) 1).lessThan(SHORT_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(ShortCollection.of((short) 2)));
    }

    /**
     * Verifies that an ordered shorts collection created as a slice from another ordered collection has the same
     * element cardinality and the correct shorts in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedShortCollection source =
                OrderedShortCollection.of(DISTINCT_ELEMENTS, (short) 1, (short) 2, SHORT_THREE, SHORT_FOUR);
        ModifiableSortedShortCollection actual =
                ModifiableSortedShortCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Short[] {(short) 2, SHORT_THREE}, actual.toArray());
    }
}
