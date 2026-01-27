package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableSortedByteCollection} class.
 */
public final class ModifiableSortedByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableSortedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final NumericCollection<Byte> source) {
        return new ModifiableSortedByteCollection.SortedTreeCollection(Comparator.naturalOrder(),
                ByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

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
    protected ModifiableSortedByteCollection createEmptyByteCollection() {
        return ModifiableSortedByteCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted bytes collection containing the provided bytes.
     *
     * @param numbers    The bytes to be included in the modifiable sorted bytes collection.
     * @param comparator The comparator for the bytes.
     * @return An modifiable sorted bytes collection containing the provided bytes.
     */
    private ModifiableSortedByteCollection createSortedByteCollection(final Comparator<Byte> comparator,
            final Byte... numbers) {
        return ModifiableSortedByteCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedByteCollection collection = createSortedByteCollection(Comparator.naturalOrder(), (byte) 1, (byte) 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BYTE_THREE, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getGreaterThan((byte) 2));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getGreaterThanOrEqualTo((byte) 2));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 1, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getLessThan((byte) 2));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getLessThanOrEqualTo((byte) 2));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).firstIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).indexOf((byte) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).lastIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).removeAt(1));
    }
}
