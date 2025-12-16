package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class DoubleMapTestBase<T extends NumericMap<String, Double>> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * The double five.
     */
    private static final Double DOUBLE_FIVE = 5D;
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
    private static final Entry<String, Double> ENTRY0 = new Entry<String, Double>("zero", 0D);
    /**
     * An entry for one.
     */
    protected static final Entry<String, Double> ENTRY1 = new Entry<String, Double>("one", 1D);
    /**
     * An entry for two.
     */
    protected static final Entry<String, Double> ENTRY2 = new Entry<String, Double>("two", 2D);
    /**
     * An entry for three.
     */
    protected static final Entry<String, Double> ENTRY3 = new Entry<String, Double>("three", 3D);
    /**
     * Map with the doubles 1, 2 and 3.
     */
    private final NumericMap<String, Double> map123 = createDoubleMap(ENTRY1, ENTRY2, ENTRY3);

    /**
     * Creates an empty doubles map.
     *
     * @return An empty doubles map.
     */
    protected abstract T createEmptyDoubleMap();

    /**
     * Creates a doubles map containing the provided entries.
     *
     * @param entries The entries to be included in the doubles map.
     * @return A doubles map containing the provided entries.
     */
    protected abstract T createDoubleMap(Entry<String, Double>... entries);

    /**
     * Creates a doubles map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the doubles map.
     * @return A doubles map containing the provided entries.
     */
    protected abstract T createDoubleMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, Double>... entries);

    /**
     * Creates a doubles map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A doubles map containing the provided key and value.
     */
    protected abstract T createDoubleMap(String key, Double value);

    /**
     * Creates a doubles map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A doubles map containing the provided keys and values.
     */
    protected abstract T createDoubleMap(String key1, Double value1, String key2, Double value2);

    /**
     * Creates a doubles map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A doubles map containing the provided keys and values.
     */
    protected abstract T createDoubleMap(String key1, Double value1, String key2, Double value2, String key3,
            Double value3);

    /**
     * Creates a doubles map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A doubles map containing the provided keys and values.
     */
    protected abstract T createDoubleMap(String key1, Double value1, String key2, Double value2, String key3,
            Double value3, String key4, Double value4);

    /**
     * Creates a doubles map containing the provided keys and values.
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
     * @return A doubles map containing the provided keys and values.
     */
    protected abstract T createDoubleMap(String key1, Double value1, String key2, Double value2, String key3,
            Double value3, String key4, Double value4, String key5, Double value5);

    /**
     * Verifies that a doubles map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnADoubleMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createDoubleMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createDoubleMap("one", 1D).size());
        assertEquals(2, createDoubleMap("one", 1D, "two", 2D).size());
        assertEquals(THREE, createDoubleMap("one", 1D, "two", 2D, "three", DOUBLE_THREE).size());
        assertEquals(FOUR, createDoubleMap("one", 1D, "two", 2D, "three", DOUBLE_THREE, "four", DOUBLE_FOUR).size());
        assertEquals(FIVE,
                createDoubleMap("one", 1D, "two", 2D, "three", DOUBLE_THREE, "four", DOUBLE_FOUR, "five", DOUBLE_FIVE)
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
        assertTrue(map123.containsAll(createDoubleMap(ENTRY1)));
        assertFalse(map123.containsAll(createDoubleMap(ENTRY0)));
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
        assertTrue(map123.containsValue(1D));
        assertFalse(map123.containsValue(0D));
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
        assertEquals(1D, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(DoubleCollection.of(1D)));
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
        assertTrue(map123.getValues().containsSame(DoubleCollection.of(1D, 2D, DOUBLE_THREE)));
    }

    /**
     * Verifies that an empty doubles map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyDoubleMap() {
        assertTrue(createEmptyDoubleMap().isEmpty());
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
