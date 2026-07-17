package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableSortedByteCollection} class.
 */
public final class ModifiableSortedByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableSortedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final ByteCollection collection123 = ByteCollection.of((byte) 1, (byte) 2, (byte) 3);

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableSortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableSortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final ModifiableSortedByteCollection source) {
        return ModifiableSortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), source);
    }

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final ModifiableSortedByteCollection source) {
        return ModifiableSortedByteCollection.of(Comparator.naturalOrder(), source);
    }

    /**
     * Verifies that the constructor of the SortedTreeCollection class creates a byte collection.
     */
    @Test
    public void constructorOfSortedTreeCollectionShouldCreateAByteCollection() {
        assertTrue(new ModifiableSortedByteCollection.SortedTreeCollection(Comparator.naturalOrder(), (byte) 1, (byte) 2,
                BYTE_THREE).containsAll(collection123));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableSortedByteCollection.empty(Comparator.naturalOrder()).isEmpty());
    }

    /**
     * Verifies that a sorted bytes collection created from another sorted collection has the same comparator and the
     * same elements.
     */
    @Test
    public void ofWithSortedCollectionShouldReturnASortedCollectionWithTheSameComparatorAndElements() {
        SortedByteCollection source = SortedByteCollection.of(Comparator.naturalOrder(), (byte) 1, (byte) 2, BYTE_THREE);
        ModifiableSortedByteCollection actual = ModifiableSortedByteCollection.of(source);
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
        ModifiableSortedByteCollection actual =
                ModifiableSortedByteCollection.of(source, Range.greaterThan((byte) 1).lessThan(BYTE_THREE));
        assertEquals(source.getComparator(), actual.getComparator());
        assertTrue(actual.containsSame(ByteCollection.of((byte) 2)));
    }

    /**
     * Verifies that an ordered bytes collection created as a slice from another ordered collection has the same
     * element cardinality and the correct bytes in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        OrderedByteCollection source =
                OrderedByteCollection.of(DISTINCT_ELEMENTS, (byte) 1, (byte) 2, BYTE_THREE, BYTE_FOUR);
        ModifiableSortedByteCollection actual =
                ModifiableSortedByteCollection.of(Comparator.naturalOrder(), source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(Comparator.naturalOrder(), actual.getComparator());
        assertArrayEquals(new Byte[] {(byte) 2, BYTE_THREE}, actual.toArray());
    }
}
