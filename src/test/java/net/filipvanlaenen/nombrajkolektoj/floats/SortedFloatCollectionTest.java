package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatCollection} class.
 */
public final class SortedFloatCollectionTest extends OrderedFloatCollectionTestBase<SortedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final FloatCollection collection123 = FloatCollection.of(1F, 2F, 3F);

    @Override
    protected SortedFloatCollection createFloatCollection(final Float... numbers) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final SortedFloatCollection source) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final SortedFloatCollection source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final SortedFloatCollection source) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final SortedFloatCollection source,
            final int fromIndex, final int toIndex) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a float collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAFloatCollection() {
        assertTrue(new SortedFloatCollection.ArrayCollection(Comparator.naturalOrder(), 1F, 2F, FLOAT_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a float collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAFloatCollection() {
        assertTrue(new SortedFloatCollection.SortedTreeCollection(Comparator.naturalOrder(), 1F, 2F, FLOAT_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedFloatCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted floats collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedFloatCollection source = SortedFloatCollection.of(Comparator.naturalOrder(), 1F, 2F, FLOAT_THREE);
        SortedFloatCollection actual = SortedFloatCollection.of(source);
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
        SortedFloatCollection actual = SortedFloatCollection.of(source, Range.greaterThan(1F).lessThan(FLOAT_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(FloatCollection.of(2F)));
    }
}
