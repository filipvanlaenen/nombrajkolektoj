package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ByteMapTestBase<T extends NumericMap<String, Byte>> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;
    /**
     * The byte five.
     */
    private static final Byte BYTE_FIVE = (byte) 5;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The magic number four.
     */
    private static final int FOUR = 4;
    /**
     * The magic number five.
     */
    private static final int FIVE = 5;
    /**
     * An entry for zero.
     */
    private static final Entry<String, Byte> ENTRY0 = new Entry<String, Byte>("zero", (byte) 0);
    /**
     * An entry for one.
     */
    protected static final Entry<String, Byte> ENTRY1 = new Entry<String, Byte>("one", (byte) 1);
    /**
     * An entry for two.
     */
    protected static final Entry<String, Byte> ENTRY2 = new Entry<String, Byte>("two", (byte) 2);
    /**
     * An entry for three.
     */
    protected static final Entry<String, Byte> ENTRY3 = new Entry<String, Byte>("three", (byte) 3);
    /**
     * Map with the bytes 1, 2 and 3.
     */
    private final T map123 = createByteMap(ENTRY1, ENTRY2, ENTRY3);

    /**
     * Creates an empty bytes map.
     *
     * @return An empty bytes map.
     */
    protected abstract T createEmptyByteMap();

    /**
     * Creates a bytes map containing the provided entries.
     *
     * @param entries The entries to be included in the bytes map.
     * @return A bytes map containing the provided entries.
     */
    protected abstract T createByteMap(Entry<String, Byte>... entries);

    /**
     * Creates a bytes map containing the provided entries.
     *
     * @param entries The entries to be included in the bytes map.
     * @return A bytes map containing the provided entries.
     */
    protected abstract T createByteMap(T map);

    /**
     * Creates a bytes map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the bytes map.
     * @return A bytes map containing the provided entries.
     */
    protected abstract T createByteMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Byte>... entries);

    /**
     * Creates a bytes map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A bytes map containing the provided key and value.
     */
    protected abstract T createByteMap(String key, Byte value);

    /**
     * Creates a bytes map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A bytes map containing the provided keys and values.
     */
    protected abstract T createByteMap(String key1, Byte value1, String key2, Byte value2);

    /**
     * Creates a bytes map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A bytes map containing the provided keys and values.
     */
    protected abstract T createByteMap(String key1, Byte value1, String key2, Byte value2, String key3,
            Byte value3);

    /**
     * Creates a bytes map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A bytes map containing the provided keys and values.
     */
    protected abstract T createByteMap(String key1, Byte value1, String key2, Byte value2, String key3,
            Byte value3, String key4, Byte value4);

    /**
     * Creates a bytes map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @param key5   The fifth key for the entry.
     * @param value5 The fifth value for the entry.
     * @return A bytes map containing the provided keys and values.
     */
    protected abstract T createByteMap(String key1, Byte value1, String key2, Byte value2, String key3,
            Byte value3, String key4, Byte value4, String key5, Byte value5);

    /**
     * Verifies that a bytes map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnAByteMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createByteMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createByteMap("one", (byte) 1).size());
        assertEquals(2, createByteMap("one", (byte) 1, "two", (byte) 2).size());
        assertEquals(THREE, createByteMap("one", (byte) 1, "two", (byte) 2, "three", BYTE_THREE).size());
        assertEquals(FOUR, createByteMap("one", (byte) 1, "two", (byte) 2, "three", BYTE_THREE, "four", BYTE_FOUR).size());
        assertEquals(FIVE,
                createByteMap("one", (byte) 1, "two", (byte) 2, "three", BYTE_THREE, "four", BYTE_FOUR, "five", BYTE_FIVE)
                        .size());
    }

    /**
     * Verifies that the <code>of</code> method with a prototype clones a map.
     */
    @Test
    public void ofWithByteMapShouldCloneTheMap() {
        T actual = createByteMap(map123);
        assertEquals(THREE, actual.size());
        assertTrue(actual.contains(ENTRY1));
        assertTrue(actual.contains(ENTRY2));
        assertTrue(actual.contains(ENTRY3));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal map.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.contains(ENTRY1));
        assertFalse(map123.contains(ENTRY0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.containsAll(createByteMap(ENTRY1)));
        assertFalse(map123.containsAll(createByteMap(ENTRY0)));
    }

    /**
     * Verifies that the <code>containsKey</code> method is wired correctly to the internal map.
     */
    @Test
    public void containsKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.containsKey("one"));
        assertFalse(map123.containsKey("zero"));
    }

    /**
     * Verifies that the <code>containsValue</code> method is wired correctly to the internal map.
     */
    @Test
    public void containsValueShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.containsValue((byte) 1));
        assertFalse(map123.containsValue((byte) 0));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal map.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.contains(map123.get()));
    }

    /**
     * Verifies that the <code>get</code> with key method is wired correctly to the internal map.
     */
    @Test
    public void getWithKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals((byte) 1, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(ByteCollection.of((byte) 1)));
    }

    /**
     * Verifies that the <code>getKeyAndValueCardinality</code> method is wired correctly to the internal map.
     */
    @Test
    public void getKeyAndValueCardinalityShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(DISTINCT_KEYS, map123.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>getKeys</code> method is wired correctly to the internal map.
     */
    @Test
    public void getKeysShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getKeys().containsSame(Collection.of("one", "two", "three")));
    }

    /**
     * Verifies that the <code>getValues</code> method is wired correctly to the internal map.
     */
    @Test
    public void getValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getValues().containsSame(ByteCollection.of((byte) 1, (byte) 2, BYTE_THREE)));
    }

    /**
     * Verifies that an empty bytes map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyByteMap() {
        assertTrue(createEmptyByteMap().isEmpty());
    }

    /**
     * Verifies that the <code>size</code> method is wired correctly to the internal map.
     */
    @Test
    public void sizeShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(THREE, map123.size());
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal map.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(THREE, map123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal map.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(THREE, map123.toArray().length);
    }
}
