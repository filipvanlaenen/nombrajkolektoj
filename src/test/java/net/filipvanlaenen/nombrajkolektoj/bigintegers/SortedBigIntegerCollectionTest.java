package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.SortedBigIntegerCollection} class.
 */
public final class SortedBigIntegerCollectionTest extends OrderedBigIntegerCollectionTestBase<SortedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final BigIntegerCollection collection123 = BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final SortedBigIntegerCollection source) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigIntegerCollection createBigIntegerCollection(final SortedBigIntegerCollection source) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return SortedBigIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final SortedBigIntegerCollection source) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedBigIntegerCollection createOrderedBigIntegerCollection(final SortedBigIntegerCollection source,
            final int fromIndex, final int toIndex) {
        return SortedBigIntegerCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new SortedBigIntegerCollection.ArrayCollection(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a BigInteger collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateABigIntegerCollection() {
        assertTrue(new SortedBigIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedBigIntegerCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted BigIntegers collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedBigIntegerCollection source = SortedBigIntegerCollection.of(Comparator.naturalOrder(), BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        SortedBigIntegerCollection actual = SortedBigIntegerCollection.of(source);
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
        SortedBigIntegerCollection actual = SortedBigIntegerCollection.of(source, Range.greaterThan(BigInteger.ONE).lessThan(BIG_INTEGER_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(BigIntegerCollection.of(BigInteger.TWO)));
    }
}
