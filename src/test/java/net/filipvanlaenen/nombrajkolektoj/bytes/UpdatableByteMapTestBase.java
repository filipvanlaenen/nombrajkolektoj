package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableByteMapTestBase<T extends UpdatableNumericMap<String, Byte>>
        extends ByteMapTestBase<T> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;

    /**
     * Creates a bytes map containing the provided entries.
     *
     * @param entries The entries to be included in the bytes map.
     * @return A bytes map containing the provided entries.
     */
    protected abstract T createUpdatableByteMap(Entry<String, Byte>... entries);

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Byte> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertEquals((byte) 1, map123.update("one", BYTE_FOUR));
        assertEquals(BYTE_FOUR, map123.get("one"));
    }
}
