package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class IntegerMapTestBase<T extends NumericMap<String, Integer>> {
    /**
     * Creates an empty integer map.
     *
     * @return An empty integer map.
     */
    protected abstract T createEmptyIntegerMap();

    /**
     * Verifies that an empty integer map is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyIntegerMap() {
        assertTrue(createEmptyIntegerMap().isEmpty());
    }
}
