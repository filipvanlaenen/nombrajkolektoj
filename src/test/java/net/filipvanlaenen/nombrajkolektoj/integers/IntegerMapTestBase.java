package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class IntegerMapTestBase<T extends NumericMap<String, Integer>> {
    /**
     * An entry for zero.
     */
    private static final Entry<String, Integer> ENTRY0 = new Entry<String, Integer>("zero", 0);
    /**
     * An entry for one.
     */
    private static final Entry<String, Integer> ENTRY1 = new Entry<String, Integer>("one", 1);
    /**
     * Map with the integers 1, 2 and 3.
     */
    private final NumericMap<String, Integer> map123 =
            createIntegerMap(ENTRY1, new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", 3));

    /**
     * Creates an empty integer map.
     *
     * @return An empty integer map.
     */
    protected abstract T createEmptyIntegerMap();

    /**
     * Creates an integer map containing the provided entries.
     *
     * @param entries The entries to be included in the integer map.
     * @return An integer map containing the provided entries.
     */
    protected abstract T createIntegerMap(Entry<String, Integer>... entries);

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
        assertTrue(map123.containsAll(createIntegerMap(ENTRY1)));
        assertFalse(map123.containsAll(createIntegerMap(ENTRY0)));
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
        assertTrue(map123.containsValue(1));
        assertFalse(map123.containsValue(0));
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
        assertEquals(1, map123.get("one"));
    }

    /**
     * Verifies that an empty integer map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyIntegerMap() {
        assertTrue(createEmptyIntegerMap().isEmpty());
    }
}
