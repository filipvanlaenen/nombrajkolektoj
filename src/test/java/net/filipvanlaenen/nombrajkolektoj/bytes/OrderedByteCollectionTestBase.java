package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedByteCollectionTestBase<T extends OrderedNumericCollection<Byte>>
        extends ByteCollectionTestBase<T> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;

    /**
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param numbers The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(Byte... numbers);

    /**
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param source The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(OrderedNumericCollection<Byte> source);

    /**
     * Creates an ordered bytes collection containing the provided range of bytes.
     *
     * @param source    The bytes to be included in the ordered bytes collection.
     * @param fromIndex The index of the first element to be included in the new ordered bytes collection.
     * @param toIndex   The index of the first element not to be included in the new ordered bytes collection.
     * @return An ordered bytes collection containing the provided range of bytes.
     */
    protected abstract T createOrderedByteCollection(OrderedNumericCollection<Byte> source, final int fromIndex,
            final int toIndex);

    /**
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(ElementCardinality elementCardinality, Byte... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).firstIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createOrderedByteCollection((byte) 1, (byte) 2, BYTE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedByteCollection((byte) 1, (byte) 2, BYTE_THREE).indexOf((byte) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).lastIndexOf((byte) 2));
    }

    /**
     * Verifies that an ordered bytes collection created from another ordered collection has the same element
     * cardinality and bytes in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnAByteCollectionWithTheSameElementCardinalityAndBytes() {
        T source = createOrderedByteCollection(DISTINCT_ELEMENTS, (byte) 1, (byte) 2, BYTE_THREE);
        T actual = createOrderedByteCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Byte[] {(byte) 1, (byte) 2, BYTE_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered bytes collection created as a slice from another ordered collection has the same
     * element cardinality and the correct bytes in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedByteCollection(DISTINCT_ELEMENTS, (byte) 1, (byte) 2, BYTE_THREE, BYTE_FOUR);
        T actual = createOrderedByteCollection(source, 1, 3);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Byte[] {(byte) 2, BYTE_THREE}, actual.toArray());
    }
}
