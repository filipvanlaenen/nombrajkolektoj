package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.UpdatableBigDecimalMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableBigDecimalMapTestBase<T extends UpdatableNumericMap<String, BigDecimal>>
        extends BigDecimalMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);

    /**
     * Creates a BigDecimals map containing the provided entries.
     *
     * @param entries The entries to be included in the BigDecimals map.
     * @return A BigDecimals map containing the provided entries.
     */
    protected abstract T createUpdatableBigDecimalMap(Entry<String, BigDecimal>... entries);

    /**
     * Creates a BigDecimals map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A BigDecimals map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableBigDecimalMap(BigDecimal defaultValue, String... keys);

    /**
     * Creates a BigDecimals map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A BigDecimals map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableBigDecimalMap(KeyAndValueCardinality keyAndValueCardinality, BigDecimal defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableBigDecimalMap(BigDecimal.ZERO, "a", "b", "c");
        assertEquals(BigDecimal.ZERO, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableBigDecimalMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, BigDecimal.ZERO, "a", "b", "c");
        assertEquals(BigDecimal.ZERO, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, BigDecimal> map123 = createUpdatableBigDecimalMap(new Entry<String, BigDecimal>("one", BigDecimal.ONE),
                new Entry<String, BigDecimal>("two", BigDecimal.valueOf(2L)), new Entry<String, BigDecimal>("three", BIG_DECIMAL_THREE));
        assertEquals(BigDecimal.ONE, map123.update("one", BIG_DECIMAL_FOUR));
        assertEquals(BIG_DECIMAL_FOUR, map123.get("one"));
    }
}
