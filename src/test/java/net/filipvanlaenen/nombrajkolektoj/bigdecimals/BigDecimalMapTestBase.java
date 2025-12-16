package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigDecimalMapTestBase<T extends NumericMap<String, BigDecimal>> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * The BigDecimal five.
     */
    private static final BigDecimal BIG_DECIMAL_FIVE = BigDecimal.valueOf(5L);
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
    private static final Entry<String, BigDecimal> ENTRY0 = new Entry<String, BigDecimal>("zero", BigDecimal.ZERO);
    /**
     * An entry for one.
     */
    protected static final Entry<String, BigDecimal> ENTRY1 = new Entry<String, BigDecimal>("one", BigDecimal.ONE);
    /**
     * Map with the BigDecimals 1, 2 and 3.
     */
    private final NumericMap<String, BigDecimal> map123 = createBigDecimalMap(ENTRY1, new Entry<String, BigDecimal>("two", BigDecimal.valueOf(2L)),
            new Entry<String, BigDecimal>("three", BIG_DECIMAL_THREE));

    /**
     * Creates an empty BigDecimals map.
     *
     * @return An empty BigDecimals map.
     */
    protected abstract T createEmptyBigDecimalMap();

    /**
     * Creates a BigDecimals map containing the provided entries.
     *
     * @param entries The entries to be included in the BigDecimals map.
     * @return A BigDecimals map containing the provided entries.
     */
    protected abstract T createBigDecimalMap(Entry<String, BigDecimal>... entries);

    /**
     * Creates a BigDecimals map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the BigDecimals map.
     * @return A BigDecimals map containing the provided entries.
     */
    protected abstract T createBigDecimalMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, BigDecimal>... entries);

    /**
     * Creates a BigDecimals map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A BigDecimals map containing the provided key and value.
     */
    protected abstract T createBigDecimalMap(String key, BigDecimal value);

    /**
     * Creates a BigDecimals map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A BigDecimals map containing the provided keys and values.
     */
    protected abstract T createBigDecimalMap(String key1, BigDecimal value1, String key2, BigDecimal value2);

    /**
     * Creates a BigDecimals map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A BigDecimals map containing the provided keys and values.
     */
    protected abstract T createBigDecimalMap(String key1, BigDecimal value1, String key2, BigDecimal value2, String key3,
            BigDecimal value3);

    /**
     * Creates a BigDecimals map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A BigDecimals map containing the provided keys and values.
     */
    protected abstract T createBigDecimalMap(String key1, BigDecimal value1, String key2, BigDecimal value2, String key3,
            BigDecimal value3, String key4, BigDecimal value4);

    /**
     * Creates a BigDecimals map containing the provided keys and values.
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
     * @return A BigDecimals map containing the provided keys and values.
     */
    protected abstract T createBigDecimalMap(String key1, BigDecimal value1, String key2, BigDecimal value2, String key3,
            BigDecimal value3, String key4, BigDecimal value4, String key5, BigDecimal value5);

    /**
     * Verifies that a BigDecimals map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnABigDecimalMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createBigDecimalMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createBigDecimalMap("one", BigDecimal.ONE).size());
        assertEquals(2, createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L)).size());
        assertEquals(THREE, createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "three", BIG_DECIMAL_THREE).size());
        assertEquals(FOUR, createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "three", BIG_DECIMAL_THREE, "four", BIG_DECIMAL_FOUR).size());
        assertEquals(FIVE,
                createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "three", BIG_DECIMAL_THREE, "four", BIG_DECIMAL_FOUR, "five", BIG_DECIMAL_FIVE)
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
        assertTrue(map123.containsAll(createBigDecimalMap(ENTRY1)));
        assertFalse(map123.containsAll(createBigDecimalMap(ENTRY0)));
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
        assertTrue(map123.containsValue(BigDecimal.ONE));
        assertFalse(map123.containsValue(BigDecimal.ZERO));
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
        assertEquals(BigDecimal.ONE, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(BigDecimalCollection.of(BigDecimal.ONE)));
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
        assertTrue(map123.getValues().containsSame(BigDecimalCollection.of(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE)));
    }

    /**
     * Verifies that an empty BigDecimals map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigDecimalMap() {
        assertTrue(createEmptyBigDecimalMap().isEmpty());
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
