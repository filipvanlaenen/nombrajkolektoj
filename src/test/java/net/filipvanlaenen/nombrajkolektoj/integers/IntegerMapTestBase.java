package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class IntegerMapTestBase<T extends NumericMap<String, Integer>> {
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
    private static final Entry<String, Integer> ENTRY0 = new Entry<String, Integer>("zero", 0);
    /**
     * An entry for one.
     */
    private static final Entry<String, Integer> ENTRY1 = new Entry<String, Integer>("one", 1);
    /**
     * Map with the integers 1, 2 and 3.
     */
    private final NumericMap<String, Integer> map123 =
            createIntegerMap(ENTRY1, new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", THREE));

    /**
     * Creates an empty integer map.
     *
     * @return An empty integer map.
     */
    protected abstract T createEmptyIntegerMap();

    /**
     * Creates an integer map containing the provided entries.
     *
     * @param entries The entries to be included in the integer map.
     * @return An integer map containing the provided entries.
     */
    protected abstract T createIntegerMap(Entry<String, Integer>... entries);

    /**
     * Creates an integer map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the integer map.
     * @return An integer map containing the provided entries.
     */
    protected abstract T createIntegerMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Integer>... entries);

    /**
     * Creates an integer map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return An integer map containing the provided key and value.
     */
    protected abstract T createIntegerMap(String key, Integer value);

    /**
     * Creates an integer map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return An integer map containing the provided keys and values.
     */
    protected abstract T createIntegerMap(String key1, Integer value1, String key2, Integer value2);

    /**
     * Creates an integer map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return An integer map containing the provided keys and values.
     */
    protected abstract T createIntegerMap(String key1, Integer value1, String key2, Integer value2, String key3,
            Integer value3);

    /**
     * Creates an integer map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return An integer map containing the provided keys and values.
     */
    protected abstract T createIntegerMap(String key1, Integer value1, String key2, Integer value2, String key3,
            Integer value3, String key4, Integer value4);

    /**
     * Creates an integer map containing the provided keys and values.
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
     * @return An integer map containing the provided keys and values.
     */
    protected abstract T createIntegerMap(String key1, Integer value1, String key2, Integer value2, String key3,
            Integer value3, String key4, Integer value4, String key5, Integer value5);

    /**
     * Verifies that an integer map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnAnIntegerMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createIntegerMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createIntegerMap("one", 1).size());
        assertEquals(2, createIntegerMap("one", 1, "two", 2).size());
        assertEquals(THREE, createIntegerMap("one", 1, "two", 2, "three", THREE).size());
        assertEquals(FOUR, createIntegerMap("one", 1, "two", 2, "three", THREE, "four", FOUR).size());
        assertEquals(FIVE, createIntegerMap("one", 1, "two", 2, "three", THREE, "four", FOUR, "five", FIVE).size());
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
        assertTrue(map123.containsAll(createIntegerMap(ENTRY1)));
        assertFalse(map123.containsAll(createIntegerMap(ENTRY0)));
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
        assertTrue(map123.containsValue(1));
        assertFalse(map123.containsValue(0));
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
        assertEquals(1, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(IntegerCollection.of(1)));
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
        assertTrue(map123.getValues().containsSame(IntegerCollection.of(1, 2, THREE)));
    }

    /**
     * Verifies that an empty integer map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyIntegerMap() {
        assertTrue(createEmptyIntegerMap().isEmpty());
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
