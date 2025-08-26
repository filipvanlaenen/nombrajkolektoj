package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableFloatMapTestBase<T extends UpdatableNumericMap<String, Float>>
        extends FloatMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;

    /**
     * Creates a floats map containing the provided entries.
     *
     * @param entries The entries to be included in the floats map.
     * @return A floats map containing the provided entries.
     */
    protected abstract T createUpdatableFloatMap(Entry<String, Float>... entries);

    /**
     * Creates a floats map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A floats map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableFloatMap(Float defaultValue, String... keys);

    /**
     * Creates a floats map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A floats map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableFloatMap(KeyAndValueCardinality keyAndValueCardinality, Float defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableFloatMap(0F, "a", "b", "c");
        assertEquals(0F, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableFloatMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, 0F, "a", "b", "c");
        assertEquals(0F, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Float> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertEquals(1F, map123.update("one", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map123.get("one"));
    }
}
