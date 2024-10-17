package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class FloatMapTestBase<T extends NumericMap<String, Float>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The float five.
     */
    private static final Float FLOAT_FIVE = 5F;
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
    private static final Entry<String, Float> ENTRY0 = new Entry<String, Float>("zero", 0F);
    /**
     * An entry for one.
     */
    private static final Entry<String, Float> ENTRY1 = new Entry<String, Float>("one", 1F);
    /**
     * Map with the floats 1, 2 and 3.
     */
    private final NumericMap<String, Float> map123 = createFloatMap(ENTRY1, new Entry<String, Float>("two", 2F),
            new Entry<String, Float>("three", FLOAT_THREE));

    /**
     * Creates an empty floats map.
     *
     * @return An empty floats map.
     */
    protected abstract T createEmptyFloatMap();

    /**
     * Creates a floats map containing the provided entries.
     *
     * @param entries The entries to be included in the floats map.
     * @return A floats map containing the provided entries.
     */
    protected abstract T createFloatMap(Entry<String, Float>... entries);

    /**
     * Creates a floats map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the floats map.
     * @return A floats map containing the provided entries.
     */
    protected abstract T createFloatMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Float>... entries);

    /**
     * Creates a floats map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A floats map containing the provided key and value.
     */
    protected abstract T createFloatMap(String key, Float value);

    /**
     * Creates a floats map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A floats map containing the provided keys and values.
     */
    protected abstract T createFloatMap(String key1, Float value1, String key2, Float value2);

    /**
     * Creates a floats map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A floats map containing the provided keys and values.
     */
    protected abstract T createFloatMap(String key1, Float value1, String key2, Float value2, String key3,
            Float value3);

    /**
     * Creates a floats map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A floats map containing the provided keys and values.
     */
    protected abstract T createFloatMap(String key1, Float value1, String key2, Float value2, String key3,
            Float value3, String key4, Float value4);

    /**
     * Creates a floats map containing the provided keys and values.
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
     * @return A floats map containing the provided keys and values.
     */
    protected abstract T createFloatMap(String key1, Float value1, String key2, Float value2, String key3,
            Float value3, String key4, Float value4, String key5, Float value5);

    /**
     * Verifies that a floats map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnAFloatMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createFloatMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createFloatMap("one", 1F).size());
        assertEquals(2, createFloatMap("one", 1F, "two", 2F).size());
        assertEquals(THREE, createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE).size());
        assertEquals(FOUR, createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE, "four", FLOAT_FOUR).size());
        assertEquals(FIVE,
                createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE, "four", FLOAT_FOUR, "five", FLOAT_FIVE)
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
        assertTrue(map123.containsAll(createFloatMap(ENTRY1)));
        assertFalse(map123.containsAll(createFloatMap(ENTRY0)));
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
        assertTrue(map123.containsValue(1F));
        assertFalse(map123.containsValue(0F));
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
        assertEquals(1F, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(FloatCollection.of(1F)));
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
        assertTrue(map123.getValues().containsSame(FloatCollection.of(1F, 2F, FLOAT_THREE)));
    }

    /**
     * Verifies that an empty floats map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyFloatMap() {
        assertTrue(createEmptyFloatMap().isEmpty());
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
