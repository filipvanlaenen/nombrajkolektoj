package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableIntegerMap} class.
 */
public final class UpdatableIntegerMapTest extends IntegerMapTestBase<UpdatableIntegerMap<String>> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;

    @Override
    protected UpdatableIntegerMap<String> createEmptyIntegerMap() {
        return UpdatableIntegerMap.<String>empty();
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return UpdatableIntegerMap.of(entries);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return UpdatableIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return UpdatableIntegerMap.of(key, value);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return UpdatableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableIntegerMap<String> map123 = createIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertEquals(1, map123.update("one", INTEGER_FOUR));
        assertEquals(INTEGER_FOUR, map123.get("one"));
    }
}
