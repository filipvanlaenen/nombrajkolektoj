package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableShortMapTestBase<T extends UpdatableNumericMap<String, Short>>
        extends ShortMapTestBase<T> {
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
