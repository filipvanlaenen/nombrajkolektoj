package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedByteCollectionTestBase<T extends OrderedByteCollection>
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
     * The magic number three.
     */
    private static final int THREE = 3;

    /**
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param source The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(T source);

    /**
     * Creates an ordered bytes collection containing the provided range of bytes.
     *
     * @param source    The bytes to be included in the ordered bytes collection.
     * @param fromIndex The index of the first element to be included in the new ordered bytes collection.
     * @param toIndex   The index of the first element not to be included in the new ordered bytes collection.
     * @return An ordered bytes collection containing the provided range of bytes.
     */
    protected abstract T createOrderedByteCollection(T source, int fromIndex, int toIndex);

    /**
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(ElementCardinality elementCardinality, Byte... numbers);

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
        T actual = createOrderedByteCollection(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Byte[] {(byte) 2, BYTE_THREE}, actual.toArray());
    }
}
