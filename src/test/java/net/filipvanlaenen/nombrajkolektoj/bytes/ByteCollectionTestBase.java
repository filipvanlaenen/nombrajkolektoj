package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ByteCollectionTestBase<T extends ByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;

    /**
     * Creates a bytes collection with the provided bytes.
     *
     * @param numbers The bytes to be included in the bytes collection.
     * @return A bytes collection with the provided bytes.
     */
    protected abstract T createByteCollection(Byte... numbers);

    /**
     * Creates a bytes collection with the provided element cardinality containing the provided bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes to be included in the bytes collection.
     * @return A bytes collection with the provided element cardinality containing the provided bytes.
     */
    protected abstract T createByteCollection(ElementCardinality elementCardinality, Byte... numbers);

    /**
     * Creates a bytes collection from a collection of bytes with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of bytes.
     * @return A bytes collection containing the provided bytes with the provided element cardinality.
     */
    protected abstract T createByteCollection(ElementCardinality elementCardinality, T source);

    /**
     * Creates a bytes collection from a collection of bytes.
     *
     * @param source The collection of bytes.
     * @return A bytes collection containing the provided bytes.
     */
    protected abstract T createByteCollection(T source);

    /**
     * Verifies that a bytes collection without a specific element cardinality receives the default element
     * cardinality.
     */
    @Test
    public void ofWithoutElementCardinalityShouldReturnAByteCollectionWithTheDefaultCardinality() {
        assertEquals(DUPLICATE_ELEMENTS, createByteCollection((byte) 1).getElementCardinality());
    }

    /**
     * Verifies that a bytes collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAByteCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createByteCollection(DISTINCT_ELEMENTS, (byte) 1).getElementCardinality());
    }

    /**
     * Verifies that a bytes collection created from another collection has the same element cardinality and bytes.
     */
    @Test
    public void ofWithCollectionShouldReturnAByteCollectionWithTheSameElementCardinalityAndBytes() {
        T source = createByteCollection(DISTINCT_ELEMENTS, (byte) 1);
        T actual = createByteCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((byte) 1));
    }

    /**
     * Verifies that a bytes collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnAByteCollectionWithTheProvidedElementCardinality() {
        T source = createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE);
        T actual = createByteCollection(DISTINCT_ELEMENTS, source);
        ByteCollection expected = ByteCollection.of((byte) 1, (byte) 2, BYTE_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
