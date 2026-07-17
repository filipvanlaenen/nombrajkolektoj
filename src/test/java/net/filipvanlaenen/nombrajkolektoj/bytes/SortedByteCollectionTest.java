package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.Range;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteCollection} class.
 */
public final class SortedByteCollectionTest extends OrderedByteCollectionTestBase<SortedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final ByteCollection collection123 = ByteCollection.of((byte) 1, (byte) 2, (byte) 3);

    @Override
    protected SortedByteCollection createByteCollection(final Byte... numbers) {
        return SortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final SortedByteCollection source) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedByteCollection createByteCollection(final SortedByteCollection source) {
        return SortedByteCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final SortedByteCollection source) {
        return SortedByteCollection.of(Comparator.naturalOrder(), source);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final SortedByteCollection source,
            final int fromIndex, final int toIndex) {
        return SortedByteCollection.of(Comparator.naturalOrder(), source, fromIndex, toIndex);
    }

    /**
     * Verifies that the constructor of the ArrayCollection class creates a byte collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAByteCollection() {
        assertTrue(new SortedByteCollection.ArrayCollection(Comparator.naturalOrder(), (byte) 1, (byte) 2, BYTE_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a byte collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAByteCollection() {
        assertTrue(new SortedByteCollection.SortedTreeCollection(Comparator.naturalOrder(), (byte) 1, (byte) 2, BYTE_THREE)
                .containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(SortedByteCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted bytes collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedByteCollection source = SortedByteCollection.of(Comparator.naturalOrder(), (byte) 1, (byte) 2, BYTE_THREE);
        SortedByteCollection actual = SortedByteCollection.of(source);
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(source));
    }

    /**
     * Verifies that a sorted bytes collection created with a range from another sorted collection has the same
     * comparator and the correct elements.
     */
    @Test
    public void ofWithSortedCollectionAndRangeShouldReturnASortedCollectionWithTheSameComparatorAndCorrectElements() {
        SortedByteCollection source = SortedByteCollection.of(Comparator.naturalOrder(), (byte) 1, (byte) 2, BYTE_THREE);
        SortedByteCollection actual = SortedByteCollection.of(source, Range.greaterThan((byte) 1).lessThan(BYTE_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(ByteCollection.of((byte) 2)));
    }
}
