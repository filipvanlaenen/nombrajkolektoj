package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
     * Creates an ordered bytes collection containing the provided bytes.
     *
     * @param numbers The bytes to be included in the ordered bytes collection.
     * @return An ordered bytes collection containing the provided bytes.
     */
    protected abstract T createOrderedByteCollection(Byte... numbers);

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createOrderedByteCollection((byte) 1, (byte) 2, BYTE_THREE).getAt(1));
    }
}
