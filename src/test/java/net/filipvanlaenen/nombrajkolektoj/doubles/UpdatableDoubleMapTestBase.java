package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableDoubleMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class UpdatableDoubleMapTestBase<T extends UpdatableNumericMap<String, Double>>
        extends DoubleMapTestBase<T> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;

    /**
     * Creates a doubles map containing the provided entries.
     *
     * @param entries The entries to be included in the doubles map.
     * @return A doubles map containing the provided entries.
     */
    protected abstract T createUpdatableDoubleMap(Entry<String, Double>... entries);

    /**
     * Creates a doubles map containing the provided keys and a default value.
     *
     * @param defaultValue The default value.
     * @param keys         The keys.
     * @return A doubles map containing the provided keys with the default value.
     */
    protected abstract T createUpdatableDoubleMap(Double defaultValue, String... keys);

    /**
     * Verifies that the <code>of</code> methods with keys and a default value is wired correctly to the internal map.
     */
    @Test
    public void ofWithKeysAndDefaultValueShouldBeWiredCorrectlyToTheInternalMap() {
        T map = createUpdatableDoubleMap(0D, "a", "b", "c");
        assertEquals(0D, map.get("a"));
        assertEquals(THREE, map.size());
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableNumericMap<String, Double> map123 = createUpdatableDoubleMap(new Entry<String, Double>("one", 1D),
                new Entry<String, Double>("two", 2D), new Entry<String, Double>("three", DOUBLE_THREE));
        assertEquals(1D, map123.update("one", DOUBLE_FOUR));
        assertEquals(DOUBLE_FOUR, map123.get("one"));
    }
}
