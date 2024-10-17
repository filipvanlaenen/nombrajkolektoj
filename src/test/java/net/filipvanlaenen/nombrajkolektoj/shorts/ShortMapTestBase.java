package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ShortMapTestBase<T extends NumericMap<String, Short>> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;
    /**
     * The short five.
     */
    private static final Short SHORT_FIVE = (short) 5;
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
    private static final Entry<String, Short> ENTRY0 = new Entry<String, Short>("zero", (short) 0);
    /**
     * An entry for one.
     */
    private static final Entry<String, Short> ENTRY1 = new Entry<String, Short>("one", (short) 1);
    /**
     * Map with the shorts 1, 2 and 3.
     */
    private final NumericMap<String, Short> map123 = createShortMap(ENTRY1, new Entry<String, Short>("two", (short) 2),
            new Entry<String, Short>("three", SHORT_THREE));

    /**
     * Creates an empty shorts map.
     *
     * @return An empty shorts map.
     */
    protected abstract T createEmptyShortMap();

    /**
     * Creates a shorts map containing the provided entries.
     *
     * @param entries The entries to be included in the shorts map.
     * @return A shorts map containing the provided entries.
     */
    protected abstract T createShortMap(Entry<String, Short>... entries);

    /**
     * Creates a shorts map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the shorts map.
     * @return A shorts map containing the provided entries.
     */
    protected abstract T createShortMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Short>... entries);

    /**
     * Creates a shorts map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A shorts map containing the provided key and value.
     */
    protected abstract T createShortMap(String key, Short value);

    /**
     * Creates a shorts map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A shorts map containing the provided keys and values.
     */
    protected abstract T createShortMap(String key1, Short value1, String key2, Short value2);

    /**
     * Creates a shorts map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A shorts map containing the provided keys and values.
     */
    protected abstract T createShortMap(String key1, Short value1, String key2, Short value2, String key3,
            Short value3);

    /**
     * Creates a shorts map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A shorts map containing the provided keys and values.
     */
    protected abstract T createShortMap(String key1, Short value1, String key2, Short value2, String key3,
            Short value3, String key4, Short value4);

    /**
     * Creates a shorts map containing the provided keys and values.
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
     * @return A shorts map containing the provided keys and values.
     */
    protected abstract T createShortMap(String key1, Short value1, String key2, Short value2, String key3,
            Short value3, String key4, Short value4, String key5, Short value5);

    /**
     * Verifies that a shorts map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnAShortMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createShortMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createShortMap("one", (short) 1).size());
        assertEquals(2, createShortMap("one", (short) 1, "two", (short) 2).size());
        assertEquals(THREE, createShortMap("one", (short) 1, "two", (short) 2, "three", SHORT_THREE).size());
        assertEquals(FOUR, createShortMap("one", (short) 1, "two", (short) 2, "three", SHORT_THREE, "four", SHORT_FOUR).size());
        assertEquals(FIVE,
                createShortMap("one", (short) 1, "two", (short) 2, "three", SHORT_THREE, "four", SHORT_FOUR, "five", SHORT_FIVE)
                        .size());
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
        assertTrue(map123.containsAll(createShortMap(ENTRY1)));
        assertFalse(map123.containsAll(createShortMap(ENTRY0)));
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
        assertTrue(map123.containsValue((short) 1));
        assertFalse(map123.containsValue((short) 0));
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
        assertEquals((short) 1, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(ShortCollection.of((short) 1)));
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
        assertTrue(map123.getValues().containsSame(ShortCollection.of((short) 1, (short) 2, SHORT_THREE)));
    }

    /**
     * Verifies that an empty shorts map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyShortMap() {
        assertTrue(createEmptyShortMap().isEmpty());
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
