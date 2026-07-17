package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableSortedBigIntegerCollection} class.
 */
public final class ModifiableSortedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableSortedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final BigIntegerCollection collection123 = BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableSortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedBigIntegerCollection source) {
        return ModifiableSortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedBigIntegerCollection createBigIntegerCollection(final ModifiableSortedBigIntegerCollection source) {
        return ModifiableSortedBigIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new ModifiableSortedBigIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO,
                BIG_INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedBigIntegerCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted BigIntegers collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedBigIntegerCollection source = SortedBigIntegerCollection.of(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        ModifiableSortedBigIntegerCollection actual = ModifiableSortedBigIntegerCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted BigIntegers collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedBigIntegerCollection source = SortedBigIntegerCollection.of(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        ModifiableSortedBigIntegerCollection actual =
                ModifiableSortedBigIntegerCollection.of(source, Range.greaterThan(BigInteger.ONE).lessThan(BIG_INTEGER_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(BigIntegerCollection.of(BigInteger.TWO)));
    }

    /**
     * Verifies that an ordered BigIntegers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigIntegers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedBigIntegerCollection source =
                OrderedBigIntegerCollection.of(DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR);
        ModifiableSortedBigIntegerCollection actual =
                ModifiableSortedBigIntegerCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new BigInteger[] {BigInteger.TWO, BIG_INTEGER_THREE}, actual.toArray());
    }
}
