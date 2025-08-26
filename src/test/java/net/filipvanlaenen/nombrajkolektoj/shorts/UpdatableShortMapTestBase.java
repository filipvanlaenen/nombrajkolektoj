package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DISTINCT_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableShortMapTestBase<T extends UpdatableNumericMap<String, Short>>
        extends ShortMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;

    /**
     * Creates a shorts map containing the provided entries.
     *
     * @param entries The entries to be included in the shorts map.
     * @return A shorts map containing the provided entries.
     */
    protected abstract T createUpdatableShortMap(Entry<String, Short>... entries);

    /**
     * Creates a shorts map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A shorts map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableShortMap(Short defaultValue, String... keys);

    /**
     * Creates a shorts map containing the provided keys and a default value with the provided key and value
     * cardinality.
     *
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value.
     * @param keys                   The keys.
     * @return A shorts map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableShortMap(KeyAndValueCardinality keyAndValueCardinality, Short defaultValue,
            String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableShortMap((short) 0, "a", "b", "c");
        assertEquals((short) 0, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>of</code> methods with key and value cardinality, keys and a default value is wired
     * correctly to the internal map.
     */
    @Test
    public void ofWithKeyAndValueCardinalityAndKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableShortMap(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, (short) 0, "a", "b", "c");
        assertEquals((short) 0, map.get("a"));
        assertEquals(THREE, map.size());
        assertEquals(DUPLICATE_KEYS_WITH_DISTINCT_VALUES, map.getKeyAndValueCardinality());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Short> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertEquals((short) 1, map123.update("one", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map123.get("one"));
    }
}
