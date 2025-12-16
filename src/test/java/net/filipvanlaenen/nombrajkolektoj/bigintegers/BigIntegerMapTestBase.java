package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DISTINCT_KEYS;
import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigIntegerMapTestBase<T extends NumericMap<String, BigInteger>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The BigInteger five.
     */
    private static final BigInteger BIG_INTEGER_FIVE = BigInteger.valueOf(5L);
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
    private static final Entry<String, BigInteger> ENTRY0 = new Entry<String, BigInteger>("zero", BigInteger.ZERO);
    /**
     * An entry for one.
     */
    protected static final Entry<String, BigInteger> ENTRY1 = new Entry<String, BigInteger>("one", BigInteger.ONE);
    /**
     * Map with the BigIntegers 1, 2 and 3.
     */
    private final NumericMap<String, BigInteger> map123 = createBigIntegerMap(ENTRY1, new Entry<String, BigInteger>("two", BigInteger.TWO),
            new Entry<String, BigInteger>("three", BIG_INTEGER_THREE));

    /**
     * Creates an empty BigIntegers map.
     *
     * @return An empty BigIntegers map.
     */
    protected abstract T createEmptyBigIntegerMap();

    /**
     * Creates a BigIntegers map containing the provided entries.
     *
     * @param entries The entries to be included in the BigIntegers map.
     * @return A BigIntegers map containing the provided entries.
     */
    protected abstract T createBigIntegerMap(Entry<String, BigInteger>... entries);

    /**
     * Creates a BigIntegers map containing the provided key and value cardinality and entries.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries to be included in the BigIntegers map.
     * @return A BigIntegers map containing the provided entries.
     */
    protected abstract T createBigIntegerMap(KeyAndValueCardinality keyAndValueCardinality,
            Entry<String, BigInteger>... entries);

    /**
     * Creates a BigIntegers map containing the provided key and value.
     *
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A BigIntegers map containing the provided key and value.
     */
    protected abstract T createBigIntegerMap(String key, BigInteger value);

    /**
     * Creates a BigIntegers map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A BigIntegers map containing the provided keys and values.
     */
    protected abstract T createBigIntegerMap(String key1, BigInteger value1, String key2, BigInteger value2);

    /**
     * Creates a BigIntegers map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A BigIntegers map containing the provided keys and values.
     */
    protected abstract T createBigIntegerMap(String key1, BigInteger value1, String key2, BigInteger value2, String key3,
            BigInteger value3);

    /**
     * Creates a BigIntegers map containing the provided keys and values.
     *
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A BigIntegers map containing the provided keys and values.
     */
    protected abstract T createBigIntegerMap(String key1, BigInteger value1, String key2, BigInteger value2, String key3,
            BigInteger value3, String key4, BigInteger value4);

    /**
     * Creates a BigIntegers map containing the provided keys and values.
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
     * @return A BigIntegers map containing the provided keys and values.
     */
    protected abstract T createBigIntegerMap(String key1, BigInteger value1, String key2, BigInteger value2, String key3,
            BigInteger value3, String key4, BigInteger value4, String key5, BigInteger value5);

    /**
     * Verifies that a BigIntegers map with a specific key and value cardinality receives that key and value cardinality.
     */
    @Test
    public void ofWithKeyAndValueCardinalityShouldReturnABigIntegerMapWithTheKeyAndValueCardinality() {
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES,
                createBigIntegerMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, ENTRY1).getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>of</code> methods with keys and values are wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndValuesShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(1, createBigIntegerMap("one", BigInteger.ONE).size());
        assertEquals(2, createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO).size());
        assertEquals(THREE, createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO, "three", BIG_INTEGER_THREE).size());
        assertEquals(FOUR, createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO, "three", BIG_INTEGER_THREE, "four", BIG_INTEGER_FOUR).size());
        assertEquals(FIVE,
                createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO, "three", BIG_INTEGER_THREE, "four", BIG_INTEGER_FOUR, "five", BIG_INTEGER_FIVE)
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
        assertTrue(map123.containsAll(createBigIntegerMap(ENTRY1)));
        assertFalse(map123.containsAll(createBigIntegerMap(ENTRY0)));
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
        assertTrue(map123.containsValue(BigInteger.ONE));
        assertFalse(map123.containsValue(BigInteger.ZERO));
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
        assertEquals(BigInteger.ONE, map123.get("one"));
    }

    /**
     * Verifies that the <code>getAll</code> method is wired correctly to the internal map.
     */
    @Test
    public void getAllShouldBeWiredCorrectlyToTheInternalMap() {
        assertTrue(map123.getAll("one").containsSame(BigIntegerCollection.of(BigInteger.ONE)));
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
        assertTrue(map123.getValues().containsSame(BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE)));
    }

    /**
     * Verifies that an empty BigIntegers map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigIntegerMap() {
        assertTrue(createEmptyBigIntegerMap().isEmpty());
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
