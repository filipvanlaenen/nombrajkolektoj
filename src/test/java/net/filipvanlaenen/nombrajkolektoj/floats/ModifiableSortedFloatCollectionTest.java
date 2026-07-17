package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableSortedFloatCollection} class.
 */
public final class ModifiableSortedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableSortedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final FloatCollection collection123 = FloatCollection.of(1F, 2F, 3F);

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableSortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableSortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedFloatCollection source) {
        return ModifiableSortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final ModifiableSortedFloatCollection source) {
        return ModifiableSortedFloatCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a float collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAFloatCollection() {
        assertTrue(new ModifiableSortedFloatCollection.SortedTreeCollection(Comparator.naturalOrder(), 1F, 2F,
                FLOAT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedFloatCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted floats collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedFloatCollection source = SortedFloatCollection.of(Comparator.naturalOrder(), 1F, 2F, FLOAT_THREE);
        ModifiableSortedFloatCollection actual = ModifiableSortedFloatCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted floats collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedFloatCollection source = SortedFloatCollection.of(Comparator.naturalOrder(), 1F, 2F, FLOAT_THREE);
        ModifiableSortedFloatCollection actual =
                ModifiableSortedFloatCollection.of(source, Range.greaterThan(1F).lessThan(FLOAT_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(FloatCollection.of(2F)));
    }

    /**
     * Verifies that an ordered floats collection created as a slice from another ordered collection has the same
     * element cardinality and the correct floats in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedFloatCollection source =
                OrderedFloatCollection.of(DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE, FLOAT_FOUR);
        ModifiableSortedFloatCollection actual =
                ModifiableSortedFloatCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Float[] {2F, FLOAT_THREE}, actual.toArray());
    }
}
