package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableLongMapTestBase<T extends UpdatableNumericMap<String, Long>>
        extends LongMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;

    /**
     * Creates a longs map containing the provided entries.
     *
     * @param entries The entries to be included in the longs map.
     * @return A longs map containing the provided entries.
     */
    protected abstract T createUpdatableLongMap(Entry<String, Long>... entries);

    /**
     * Creates a longs map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A longs map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableLongMap(Long defaultValue, String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableLongMap(0L, "a", "b", "c");
        assertEquals(0L, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Long> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertEquals(1L, map123.update("one", LONG_FOUR));
        assertEquals(LONG_FOUR, map123.get("one"));
    }
}
