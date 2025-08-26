package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableIntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableIntegerMapTestBase<T extends UpdatableNumericMap<String, Integer>>
        extends IntegerMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;

    /**
     * Creates a integers map containing the provided entries.
     *
     * @param entries The entries to be included in the integers map.
     * @return A integers map containing the provided entries.
     */
    protected abstract T createUpdatableIntegerMap(Entry<String, Integer>... entries);

    /**
     * Creates a integers map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A integers map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableIntegerMap(Integer defaultValue, String... keys);

    /**
     * Creates a integers map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A integers map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableIntegerMap(KeyAndValueCardinality keyAndValueCardinality, Integer defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableIntegerMap(0, "a", "b", "c");
        assertEquals(0, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableIntegerMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, 0, "a", "b", "c");
        assertEquals(0, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Integer> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertEquals(1, map123.update("one", INTEGER_FOUR));
        assertEquals(INTEGER_FOUR, map123.get("one"));
    }
}
