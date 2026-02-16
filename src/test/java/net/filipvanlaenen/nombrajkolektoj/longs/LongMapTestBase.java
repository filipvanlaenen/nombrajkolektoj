package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class LongMapTestBase<T extends NumericMap<String, Long>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;
    /**
     * The long five.
     */
    private static final Long LONG_FIVE = 5L;
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
    private static final Entry<String, Long> ENTRY0 = new Entry<String, Long>("zero", 0L);
    /**
     * An entry for one.
     */
    protected static final Entry<String, Long> ENTRY1 = new Entry<String, Long>("one", 1L);
    /**
     * An entry for two.
     */
    protected static final Entry<String, Long> ENTRY2 = new Entry<String, Long>("two", 2L);
    /**
     * An entry for three.
     */
    protected static final Entry<String, Long> ENTRY3 = new Entry<String, Long>("three", 3L);
    /**
     * Map with the longs 1, 2 and 3.
     */
    private final T map123 = createLongMap(ENTRY1, ENTRY2, ENTRY3);

    /**
     * Creates an empty longs map.
     *
     * @return An empty longs map.
     */
    protected abstract T createEmptyLongMap();

    /**
     * Creates a longs map containing the provided entries.
     *
     * @param entries The entries to be included in the longs map.
     * @return A longs map containing the provided entries.
     */
    protected abstract T createLongMap(Entry<String, Long>... entries);

    /**
     * Creates a longs map containing the provided entries.
     *
     * @param entries The entries to be included in the longs map.
     * @return A longs map containing the provided entries.
     */
    protected abstract T createLongMap(T map);

    /**
     * Creates a longs map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the longs map.
     * @return A longs map containing the provided entries.
     */
    protected abstract T createLongMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Long>... entries);

    /**
     * Creates a longs map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A longs map containing the provided key and value.
     */
    protected abstract T createLongMap(String key, Long value);

    /**
     * Creates a longs map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A longs map containing the provided keys and values.
     */
    protected abstract T createLongMap(String key1, Long value1, String key2, Long value2);

    /**
     * Creates a longs map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A longs map containing the provided keys and values.
     */
    protected abstract T createLongMap(String key1, Long value1, String key2, Long value2, String key3,
            Long value3);

    /**
     * Creates a longs map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A longs map containing the provided keys and values.
     */
    protected abstract T createLongMap(String key1, Long value1, String key2, Long value2, String key3,
            Long value3, String key4, Long value4);

    /**
     * Creates a longs map containing the provided keys and values.
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
     * @return A longs map containing the provided keys and values.
     */
    protected abstract T createLongMap(String key1, Long value1, String key2, Long value2, String key3,
            Long value3, String key4, Long value4, String key5, Long value5);

    /**
     * Verifies that a longs map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnALongMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createLongMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createLongMap("one", 1L).size());
        assertEquals(2, createLongMap("one", 1L, "two", 2L).size());
        assertEquals(THREE, createLongMap("one", 1L, "two", 2L, "three", LONG_THREE).size());
        assertEquals(FOUR, createLongMap("one", 1L, "two", 2L, "three", LONG_THREE, "four", LONG_FOUR).size());
        assertEquals(FIVE,
                createLongMap("one", 1L, "two", 2L, "three", LONG_THREE, "four", LONG_FOUR, "five", LONG_FIVE)
                        .size());
    }

    /**
     * Verifies that the <code>of</code> method with a prototype clones a map.
     */
    @Test
    public void ofWithLongMapShouldCloneTheMap() {
        T actual = createLongMap(map123);
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
        assertTrue(map123.containsAll(createLongMap(ENTRY1)));
        assertFalse(map123.containsAll(createLongMap(ENTRY0)));
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
        assertTrue(map123.containsValue(1L));
        assertFalse(map123.containsValue(0L));
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
        assertEquals(1L, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(LongCollection.of(1L)));
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
        assertTrue(map123.getValues().containsSame(LongCollection.of(1L, 2L, LONG_THREE)));
    }

    /**
     * Verifies that an empty longs map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyLongMap() {
        assertTrue(createEmptyLongMap().isEmpty());
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
