package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableFloatMapTestBase<T extends UpdatableNumericMap<String, Float>>
        extends FloatMapTestBase<T> {
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
