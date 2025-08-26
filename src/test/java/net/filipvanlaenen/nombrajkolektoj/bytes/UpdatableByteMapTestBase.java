package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableByteMapTestBase<T extends UpdatableNumericMap<String, Byte>>
        extends ByteMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
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
     * Creates a bytes map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A bytes map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableByteMap(Byte defaultValue, String... keys);

    /**
     * Creates a bytes map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A bytes map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableByteMap(KeyAndValueCardinality keyAndValueCardinality, Byte defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableByteMap((byte) 0, "a", "b", "c");
        assertEquals((byte) 0, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableByteMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, (byte) 0, "a", "b", "c");
        assertEquals((byte) 0, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

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
