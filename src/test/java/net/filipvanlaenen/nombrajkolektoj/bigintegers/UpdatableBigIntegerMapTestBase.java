package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.UpdatableBigIntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableBigIntegerMapTestBase<T extends UpdatableNumericMap<String, BigInteger>>
        extends BigIntegerMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);

    /**
     * Creates a BigIntegers map containing the provided entries.
     *
     * @param entries The entries to be included in the BigIntegers map.
     * @return A BigIntegers map containing the provided entries.
     */
    protected abstract T createUpdatableBigIntegerMap(Entry<String, BigInteger>... entries);

    /**
     * Creates a BigIntegers map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A BigIntegers map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableBigIntegerMap(BigInteger defaultValue, String... keys);

    /**
     * Creates a BigIntegers map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A BigIntegers map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableBigIntegerMap(KeyAndValueCardinality keyAndValueCardinality, BigInteger defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableBigIntegerMap(BigInteger.ZERO, "a", "b", "c");
        assertEquals(BigInteger.ZERO, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableBigIntegerMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, BigInteger.ZERO, "a", "b", "c");
        assertEquals(BigInteger.ZERO, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, BigInteger> map123 = createUpdatableBigIntegerMap(new Entry<String, BigInteger>("one", BigInteger.ONE),
                new Entry<String, BigInteger>("two", BigInteger.TWO), new Entry<String, BigInteger>("three", BIG_INTEGER_THREE));
        assertEquals(BigInteger.ONE, map123.update("one", BIG_INTEGER_FOUR));
        assertEquals(BIG_INTEGER_FOUR, map123.get("one"));
    }
}
