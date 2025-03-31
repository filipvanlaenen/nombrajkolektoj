package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} class.
 */
public final class UpdatableShortMapTest extends ShortMapTestBase<UpdatableShortMap<String>> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;

    @Override
    protected UpdatableShortMap<String> createEmptyShortMap() {
        return UpdatableShortMap.<String>empty();
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return UpdatableShortMap.of(entries);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return UpdatableShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key, final Short value) {
        return UpdatableShortMap.of(key, value);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return UpdatableShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return UpdatableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableShortMap<String> map123 = createShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertEquals((short) 1, map123.update("one", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map123.get("one"));
    }
}
