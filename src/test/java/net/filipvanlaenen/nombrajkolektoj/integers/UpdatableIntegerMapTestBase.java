package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableIntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableIntegerMapTestBase<T extends UpdatableNumericMap<String, Integer>>
        extends IntegerMapTestBase<T> {
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
